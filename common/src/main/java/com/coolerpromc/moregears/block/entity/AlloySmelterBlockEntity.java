package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.recipe.custom.MultipleRecipeInput;
import com.coolerpromc.moregears.screen.AlloySmelterMenu;
import com.coolerpromc.moregears.util.AlloySmelterInventory;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class AlloySmelterBlockEntity extends BlockEntity implements MenuProvider {
    private final MGEnergyStorage energyStorage = new MGEnergyStorage(100000, 10000, 0);

    private final AlloySmelterInventory fuelHandler = new AlloySmelterInventory(1){
        @Override
        public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
            return false;
        }

        @Override
        public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
            return canPlaceItem(i, itemStack);
        }

        @Override
        public boolean canPlaceItem(int slot, ItemStack itemStack) {
            return level.fuelValues().isFuel(itemStack);
        }
    };

    private final AlloySmelterInventory inputHandler = new AlloySmelterInventory(2){
        @Override
        public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
            return false;
        }
    };

    private final AlloySmelterInventory outputHandler = new AlloySmelterInventory(1){
        @Override
        public boolean canPlaceItem(int slot, ItemStack itemStack) {
            return false;
        }

        @Override
        public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
            return false;
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
                    case 2 -> AlloySmelterBlockEntity.this.energyStorage.getAmountAsInt();
                    case 3 -> AlloySmelterBlockEntity.this.energyStorage.getCapacityAsInt();
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

    public ItemStacksResourceHandler getFuelHandler() {
        return fuelHandler;
    }

    public ItemStacksResourceHandler getInputHandler() {
        return inputHandler;
    }

    public ItemStacksResourceHandler getOutputHandler() {
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
        inventory.setItem(0, inputHandler.getResource(0).toStack(inputHandler.getAmountAsInt(0)));
        inventory.setItem(1, inputHandler.getResource(1).toStack(inputHandler.getAmountAsInt(1)));
        inventory.setItem(2, outputHandler.getResource(0).toStack(outputHandler.getAmountAsInt(0)));
        inventory.setItem(3, fuelHandler.getResource(0).toStack(fuelHandler.getAmountAsInt(0)));

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
    protected void saveAdditional(ValueOutput valueOutput) {
        fuelHandler.serialize(valueOutput.child("fuelHandler"));
        inputHandler.serialize(valueOutput.child("inputHandler"));
        outputHandler.serialize(valueOutput.child("outputHandler"));
        valueOutput.putInt("energy", energyStorage.getAmountAsInt());
        valueOutput.putInt("progress", progress);
        valueOutput.putInt("burnProgress", burnProgress);
        valueOutput.putInt("maxBurnProgress", maxBurnProgress);
        valueOutput.putBoolean("isBurning", isBurning);
        super.saveAdditional(valueOutput);
    }

    @Override
    protected void loadAdditional(ValueInput valueInput) {
        fuelHandler.deserialize(valueInput.childOrEmpty("fuelHandler"));
        inputHandler.deserialize(valueInput.childOrEmpty("inputHandler"));
        outputHandler.deserialize(valueInput.childOrEmpty("outputHandler"));
        energyStorage.setEnergy(valueInput.getIntOr("energy", 0));
        progress = valueInput.getIntOr("progress", 0);
        burnProgress = valueInput.getIntOr("burnProgress", 0);
        maxBurnProgress = valueInput.getIntOr("maxBurnProgress", 0);
        isBurning = valueInput.getBooleanOr("isBurning", false);
        super.loadAdditional(valueInput);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        generateEnergy();
        setChanged(pLevel, pPos, pState);

        if(hasRecipe() && energyStorage.getAmountAsInt() >= 1){
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
        if (fuelHandler.getResource(0).toStack().getBurnTime(RecipeType.BLASTING, level.fuelValues()) > 0 && !isBurning){
            maxBurnProgress = Math.max(fuelHandler.getResource(0).toStack().getBurnTime(RecipeType.BLASTING, level.fuelValues()), 0);
        }

        if((fuelHandler.getResource(0).toStack().getBurnTime(RecipeType.BLASTING, level.fuelValues()) > 0 || isBurning) && energyStorage.getAmountAsInt() < energyStorage.getCapacityAsInt()){
            if (burnProgress >= maxBurnProgress){
                burnProgress = 0;
                isBurning = false;
                return;
            }

            if (burnProgress == 0){
                try(Transaction tx = Transaction.open(null)){
                    if(fuelHandler.extract(fuelHandler.getResource(0), 1, tx) == 1){
                        tx.commit();
                        isBurning = true;
                    }
                }
            }

            energyStorage.addEnergy(100);
            burnProgress++;
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<AlloySmeltingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            List<ItemStack> results = recipe.get().value().output().stream().map(ItemStackTemplate::create).toList();

            int extractFromSlot0 = 0;
            int extractFromSlot1 = 0;

            for (SizedIngredient ingredient : recipe.get().value().inputItems()) {
                if (ingredient.test(inputHandler.getResource(0).toStack(inputHandler.getAmountAsInt(0)))) {
                    extractFromSlot0 += Math.min(inputHandler.getAmountAsInt(0), ingredient.count());
                } else if (ingredient.test(inputHandler.getResource(1).toStack(inputHandler.getAmountAsInt(1)))) {
                    extractFromSlot1 += Math.min(inputHandler.getAmountAsInt(1), ingredient.count());
                }
            }

            if (extractFromSlot0 > 0) {
                try(Transaction tx = Transaction.open(null)){
                    if (inputHandler.extract(inputHandler.getResource(0), extractFromSlot0, tx) == extractFromSlot0){
                        tx.commit();
                    }
                }
            }
            if (extractFromSlot1 > 0) {
                try(Transaction tx = Transaction.open(null)){
                    if (inputHandler.extract(inputHandler.getResource(1), extractFromSlot1, tx) == extractFromSlot1){
                        tx.commit();
                    }
                }
            }

            for (ItemStack result : results) {
                int outputSlot = findSuitableOutputSlot(result);
                if (outputSlot != -1) {
                    this.outputHandler.set(outputSlot, ItemResource.of(result.getItem()), this.outputHandler.getAmountAsInt(outputSlot) + result.getCount());

                } else {
                    System.err.println("No suitable output slot found for item: " + result);
                }
            }
        }
    }

    private int findSuitableOutputSlot(ItemStack result) {
        for (int i = 0; i < this.outputHandler.size(); i++) {
            ItemStack stackInSlot = this.outputHandler.getResource(i).toStack(this.outputHandler.getAmountAsInt(i));
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
        List<ItemStack> outputResults = currentRecipe.output().stream().map(ItemStackTemplate::create).toList();

        // Create a mutable copy of the user inputs
        List<ItemStack> userInputs = new ArrayList<>();
        userInputs.add(this.inputHandler.getResource(0).toStack(this.inputHandler.getAmountAsInt(0)));
        userInputs.add(this.inputHandler.getResource(1).toStack(this.inputHandler.getAmountAsInt(1)));

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

        for (int i = 0; i < this.outputHandler.size(); i++) {
            ItemStack stackInSlot = this.outputHandler.getResource(i).toStack(this.outputHandler.getAmountAsInt(i));
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

        for (int i = 0; i < this.inputHandler.size(); i++) {
            inputs.add(this.inputHandler.getResource(i).toStack(this.inputHandler.getAmountAsInt(i)));
        }

        ServerLevel serverLevel = (ServerLevel) level;
        assert serverLevel != null;
        RecipeManager recipeManager = serverLevel.recipeAccess();

        return recipeManager.getRecipeFor(MGRecipes.ALLOY_SMELTING_TYPE.get(), new MultipleRecipeInput(inputs), level);
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        for (int i = 0; i < this.outputHandler.size(); i++) {
            ItemStack stackInSlot = this.outputHandler.getResource(i).toStack(this.outputHandler.getAmountAsInt(i));
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxStackSize())) {
                return true;
            }
        }
        return false;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        for (int i = 0; i < this.outputHandler.size(); i++) {
            ItemStack stackInSlot = this.outputHandler.getResource(i).toStack(this.outputHandler.getAmountAsInt(i));
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

    @Override
    public void preRemoveSideEffects(BlockPos p_394577_, BlockState p_394161_) {
        drops();
    }
}
