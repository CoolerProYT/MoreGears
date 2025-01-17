package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.screen.AlloySmelterMenu;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class AlloySmelterBlockEntity extends BlockEntity implements MenuProvider {
    private final MGEnergyStorage energyStorage = new MGEnergyStorage(100000, 10000, 0);

    private final ItemStackHandler fuelHandler = new ItemStackHandler(1){
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
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

    private final LazyOptional<ItemStackHandler> fuelHandlerCap = LazyOptional.of(() -> fuelHandler);
    private final LazyOptional<ItemStackHandler> inputHandlerCap = LazyOptional.of(() -> inputHandler);
    private final LazyOptional<ItemStackHandler> outputHandlerCap = LazyOptional.of(() -> outputHandler);

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
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.ENERGY){
            return LazyOptional.of(() -> energyStorage).cast();
        }
        else{
            if (side == Direction.DOWN){
                return outputHandlerCap.cast();
            }
            else if (side == Direction.UP){
                return fuelHandlerCap.cast();
            }
            else if (side == Direction.NORTH || side == Direction.SOUTH || side == Direction.EAST || side == Direction.WEST){
                return inputHandlerCap.cast();
            }
        }

        return super.getCapability(cap, side);
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
    protected void saveAdditional(CompoundTag tag) {
        tag.put("fuel", fuelHandler.serializeNBT());
        tag.put("input", inputHandler.serializeNBT());
        tag.put("output", outputHandler.serializeNBT());
        tag.putInt("energy", energyStorage.getEnergyStored());

        tag.putInt("progress", progress);
        tag.putInt("burnProgress", burnProgress);
        tag.putInt("maxBurnProgress", maxBurnProgress);
        tag.putBoolean("isBurning", isBurning);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        fuelHandler.deserializeNBT(tag.getCompound("fuel"));
        inputHandler.deserializeNBT(tag.getCompound("input"));
        outputHandler.deserializeNBT(tag.getCompound("output"));
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
        if (ForgeHooks.getBurnTime(fuelHandler.getStackInSlot(0), RecipeType.SMELTING) > 0 && !isBurning){
            maxBurnProgress = Math.max(ForgeHooks.getBurnTime(fuelHandler.getStackInSlot(0), RecipeType.SMELTING), 0);
        }

        if(ForgeHooks.getBurnTime(fuelHandler.getStackInSlot(0), RecipeType.SMELTING) > 0 || isBurning && energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored()){
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
        Optional<AlloySmeltingRecipe> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            ItemStack results = recipe.get().getOutput();

            int extractFromSlot0 = 0;
            int extractFromSlot1 = 0;

            for (Ingredient ingredient : recipe.get().getInputItems()) {
                if (ingredient.test(inputHandler.getStackInSlot(0))) {
                    extractFromSlot0 += Math.min(inputHandler.getStackInSlot(0).getCount(), ingredient.getItems()[0].getCount());
                } else if (ingredient.test(inputHandler.getStackInSlot(1))) {
                    extractFromSlot1 += Math.min(inputHandler.getStackInSlot(1).getCount(), ingredient.getItems()[0].getCount());
                }
            }

            if (extractFromSlot0 > 0) {
                inputHandler.extractItem(0, extractFromSlot0, false);
            }
            if (extractFromSlot1 > 0) {
                inputHandler.extractItem(1, extractFromSlot1, false);
            }

            int outputSlot = findSuitableOutputSlot(results);
            if (outputSlot != -1) {
                this.outputHandler.setStackInSlot(outputSlot, new ItemStack(results.getItem(), this.outputHandler.getStackInSlot(outputSlot).getCount() + results.getCount()));

            } else {
                System.err.println("No suitable output slot found for item: " + results);
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
        Optional<AlloySmeltingRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        // Retrieve recipe inputs and outputs
        AlloySmeltingRecipe currentRecipe = recipe.get();
        List<Ingredient> recipeIngredients = currentRecipe.getInputItems();
        ItemStack outputResults = currentRecipe.getOutput();

        // Create a mutable copy of the user inputs
        List<ItemStack> userInputs = new ArrayList<>();
        userInputs.add(this.inputHandler.getStackInSlot(0));
        userInputs.add(this.inputHandler.getStackInSlot(1));

        // Check if all recipe ingredients are matched with user inputs
        for (Ingredient recipeIngredient : recipeIngredients) {
            boolean ingredientMatched = false;

            // Try to match the ingredient with one of the user inputs
            Iterator<ItemStack> userInputIterator = userInputs.iterator();
            while (userInputIterator.hasNext()) {
                ItemStack userInput = userInputIterator.next();

                if (recipeIngredient.test(userInput) && userInput.getCount() >= recipeIngredient.getItems()[0].getCount()) {
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
        if (!canInsertAmountIntoOutputSlot(outputResults) || !canInsertItemIntoOutputSlot(outputResults.getItem())) {
            return false;
        }

        // Final validation of the slots (if any additional checks are required)
        return checkSlot(outputResults);
    }


    private boolean checkSlot(ItemStack results){
        int count = 0;
        int emptyCount = 0;
        count++;

        for (int i = 0; i < this.outputHandler.getSlots(); i++) {
            ItemStack stackInSlot = this.outputHandler.getStackInSlot(i);
            if(!stackInSlot.isEmpty()){
                if(stackInSlot.getItem() == results.getItem()){
                    if(stackInSlot.getCount() + results.getCount() <= 64){
                        emptyCount++;
                    }
                }
            }
            else {
                emptyCount++;
            }
        }

        return emptyCount >= count;
    }

    private Optional<AlloySmeltingRecipe> getCurrentRecipe(){
        ItemStack[] inputs = new ItemStack[this.inputHandler.getSlots()];

        for (int i = 0; i < this.inputHandler.getSlots(); i++) {
            inputs[i] = this.inputHandler.getStackInSlot(i);
        }
        return this.level.getRecipeManager().getRecipeFor(AlloySmeltingRecipe.Type.INSTANCE, new SimpleContainer(inputs), level);
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
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
