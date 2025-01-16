package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.recipe.custom.MultipleRecipeInput;
import com.coolerpromc.moregears.screen.AlloySmelterMenu;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class AlloySmelterBlockEntity extends BlockEntity implements MenuProvider {
    private final MGEnergyStorage energyStorage = new MGEnergyStorage(100000, 10000, 0);

    private final ItemStackHandler fuelHandler = new ItemStackHandler(1){
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            assert level != null;
            return stack.getBurnTime(RecipeType.BLASTING, level.fuelValues()) > 0;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private final ItemStackHandler inputHandler = new ItemStackHandler(2){
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return true;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private final ItemStackHandler outputHandler = new ItemStackHandler(1){
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int burnProgress = 0;
    private int maxBurnProgress = 0;
    private boolean isBurning = false;

    public AlloySmelterBlockEntity(BlockPos pos, BlockState blockState) {
        super(MGBlockEntities.ALLOY_SMELTER_BE.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> AlloySmelterBlockEntity.this.progress;
                    case 1 -> AlloySmelterBlockEntity.this.maxProgress;
                    case 2 -> AlloySmelterBlockEntity.this.energyStorage.getEnergyStored();
                    case 3 -> AlloySmelterBlockEntity.this.energyStorage.getMaxEnergyStored();
                    case 4 -> AlloySmelterBlockEntity.this.burnProgress;
                    case 5 -> AlloySmelterBlockEntity.this.maxBurnProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> AlloySmelterBlockEntity.this.progress = pValue;
                    case 1 -> AlloySmelterBlockEntity.this.maxProgress = pValue;
                    case 5 -> AlloySmelterBlockEntity.this.maxBurnProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
    }

    public MGEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    public ItemStackHandler getFuelHandler() {
        return fuelHandler;
    }

    public ItemStackHandler getInputHandler() {
        return inputHandler;
    }

    public ItemStackHandler getOutputHandler() {
        return outputHandler;
    }

    public ContainerData getData() {
        return data;
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(4);
        inventory.setItem(0, inputHandler.getStackInSlot(0));
        inventory.setItem(1, inputHandler.getStackInSlot(1));
        inventory.setItem(2, outputHandler.getStackInSlot(0));
        inventory.setItem(3, fuelHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.moregears.alloy_smelter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AlloySmelterMenu(i, inventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("fuel", fuelHandler.serializeNBT(registries));
        tag.put("input", inputHandler.serializeNBT(registries));
        tag.put("output", outputHandler.serializeNBT(registries));
        tag.putInt("energy", energyStorage.getEnergyStored());

        tag.putInt("progress", progress);
        tag.putInt("burnProgress", burnProgress);
        tag.putInt("maxBurnProgress", maxBurnProgress);
        tag.putBoolean("isBurning", isBurning);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        fuelHandler.deserializeNBT(registries, tag.getCompound("fuel"));
        inputHandler.deserializeNBT(registries, tag.getCompound("input"));
        outputHandler.deserializeNBT(registries, tag.getCompound("output"));
        energyStorage.setEnergy(tag.getInt("energy"));

        progress = tag.getInt("progress");
        burnProgress = tag.getInt("burnProgress");
        maxBurnProgress = tag.getInt("maxBurnProgress");
        isBurning = tag.getBoolean("isBurning");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        generateEnergy();
        setChanged(pLevel, pPos, pState);

        if(hasRecipe() && energyStorage.getEnergyStored() >= 1){
            increaseCraftingProgress();
            energyStorage.removeEnergy(10);
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
                setChanged(pLevel, pPos, pState);
            }
        } else {
            resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private void generateEnergy(){
        assert level != null;
        if (fuelHandler.getStackInSlot(0).getBurnTime(RecipeType.BLASTING, level.fuelValues()) > 0 && !isBurning){
            maxBurnProgress = Math.max(fuelHandler.getStackInSlot(0).getBurnTime(RecipeType.BLASTING, level.fuelValues()), 0);
        }

        if(fuelHandler.getStackInSlot(0).getBurnTime(RecipeType.BLASTING, level.fuelValues()) > 0 || isBurning && energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored()){
            if (burnProgress >= maxBurnProgress){
                burnProgress = 0;
                isBurning = false;
                return;
            }

            if (burnProgress == 0){
                fuelHandler.extractItem(0, 1, false);
                isBurning = true;
            }

            energyStorage.receiveEnergy(100, false);
            burnProgress++;
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<AlloySmeltingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            List<ItemStack> results = recipe.get().value().output();

            int extractFromSlot0 = 0;
            int extractFromSlot1 = 0;

            for (SizedIngredient ingredient : recipe.get().value().inputItems()) {
                if (ingredient.test(inputHandler.getStackInSlot(0))) {
                    extractFromSlot0 += Math.min(inputHandler.getStackInSlot(0).getCount(), ingredient.count());
                } else if (ingredient.test(inputHandler.getStackInSlot(1))) {
                    extractFromSlot1 += Math.min(inputHandler.getStackInSlot(1).getCount(), ingredient.count());
                }
            }

            if (extractFromSlot0 > 0) {
                inputHandler.extractItem(0, extractFromSlot0, false);
            }
            if (extractFromSlot1 > 0) {
                inputHandler.extractItem(1, extractFromSlot1, false);
            }

            for (ItemStack result : results) {
                int outputSlot = findSuitableOutputSlot(result);
                if (outputSlot != -1) {
                    this.outputHandler.setStackInSlot(outputSlot, new ItemStack(result.getItem(),
                            this.outputHandler.getStackInSlot(outputSlot).getCount() + result.getCount()));

                } else {
                    System.err.println("No suitable output slot found for item: " + result);
                }
            }
        }
    }

    private int findSuitableOutputSlot(ItemStack result) {
        // Implement logic to find a suitable output slot for the given result
        // Return the slot index or -1 if no suitable slot is found
        for (int i = 0; i < this.outputHandler.getSlots(); i++) {
            ItemStack stackInSlot = this.outputHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxStackSize())) {
                return i;
            }
        }
        return -1;
    }

    private boolean hasRecipe() {
        // Get the current recipe, return false if not present
        Optional<RecipeHolder<AlloySmeltingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        // Retrieve recipe inputs and outputs
        AlloySmeltingRecipe currentRecipe = recipe.get().value();
        List<SizedIngredient> recipeIngredients = currentRecipe.inputItems();
        List<ItemStack> outputResults = currentRecipe.output();

        // Create a mutable copy of the user inputs
        List<ItemStack> userInputs = new ArrayList<>();
        userInputs.add(this.inputHandler.getStackInSlot(0));
        userInputs.add(this.inputHandler.getStackInSlot(1));

        // Check if all recipe ingredients are matched with user inputs
        for (SizedIngredient recipeIngredient : recipeIngredients) {
            boolean ingredientMatched = false;

            // Try to match the ingredient with one of the user inputs
            Iterator<ItemStack> userInputIterator = userInputs.iterator();
            while (userInputIterator.hasNext()) {
                ItemStack userInput = userInputIterator.next();

                if (recipeIngredient.ingredient().test(userInput) && userInput.getCount() >= recipeIngredient.count()) {
                    // Match found; remove the input to avoid duplicate matches
                    userInputIterator.remove();
                    ingredientMatched = true;
                    break;
                }
            }

            if (!ingredientMatched) {
                // If no match is found for a recipe ingredient, the recipe does not match
                return false;
            }
        }

        // Check if outputs can fit into the output slots
        for (ItemStack result : outputResults) {
            if (!canInsertAmountIntoOutputSlot(result) || !canInsertItemIntoOutputSlot(result.getItem())) {
                return false;
            }
        }

        // Final validation of the slots (if any additional checks are required)
        return checkSlot(outputResults);
    }


    private boolean checkSlot(List<ItemStack> results){
        int count = 0;
        int emptyCount = 0;
        for (ItemStack result : results){
            count++;
        }

        for (int i = 0; i < this.outputHandler.getSlots(); i++) {
            ItemStack stackInSlot = this.outputHandler.getStackInSlot(i);
            if(!stackInSlot.isEmpty()){
                for (ItemStack result : results){
                    if(stackInSlot.getItem() == result.getItem()){
                        if(stackInSlot.getCount() + result.getCount() <= 64){
                            emptyCount++;
                        }
                    }
                }
            }
            else {
                emptyCount++;
            }
        }

        return emptyCount >= count;
    }

    private Optional<RecipeHolder<AlloySmeltingRecipe>> getCurrentRecipe(){
        List<ItemStack> inputs = new ArrayList<>();

        for (int i = 0; i < this.inputHandler.getSlots(); i++) {
            inputs.add(this.inputHandler.getStackInSlot(i));
        }

        ServerLevel serverLevel = (ServerLevel) level;
        assert serverLevel != null;
        RecipeManager recipeManager = serverLevel.recipeAccess();

        return recipeManager.getRecipeFor(MGRecipes.ALLOY_SMELTING_TYPE.get(), new MultipleRecipeInput(inputs), level);
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        for (int i = 0; i < this.outputHandler.getSlots(); i++) {
            ItemStack stackInSlot = this.outputHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxStackSize())) {
                return true;
            }
        }
        return false;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        for (int i = 0; i < this.outputHandler.getSlots(); i++) {
            ItemStack stackInSlot = this.outputHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || stackInSlot.getItem() == item) {
                return true;
            }
        }
        return false;
    }


    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}
