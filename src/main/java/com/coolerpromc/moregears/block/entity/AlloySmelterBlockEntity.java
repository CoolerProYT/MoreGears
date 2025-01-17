package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.screen.AlloySmelterMenu;
import com.coolerpromc.moregears.util.ImplementedInventory;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class AlloySmelterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final MGEnergyStorage energyStorage = new MGEnergyStorage(100000, 1000, 0) {
        @Override
        protected void onFinalCommit() {
            super.onFinalCommit();
            markDirty();
            if (world != null)
                world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }

        @Override
        public boolean supportsExtraction() {
            return false;
        }

        @Override
        public boolean supportsInsertion() {
            return true;
        }
    };
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public static final int FUEL_SLOT = 0;
    public static final int[] INPUT_SLOT = {1, 2};
    public static final int[] OUTPUT_SLOT = {3};

    protected final PropertyDelegate data;
    private int progress = 0;
    private int maxProgress = 100;
    private int burnProgress = 0;
    private int maxBurnProgress = 0;
    private boolean isBurning = false;

    public AlloySmelterBlockEntity(BlockPos pos, BlockState state) {
        super(MGBlockEntities.ALLOY_SMELTER_BE, pos, state);
        this.data = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AlloySmelterBlockEntity.this.progress;
                    case 1 -> AlloySmelterBlockEntity.this.maxProgress;
                    case 2 -> AlloySmelterBlockEntity.this.energyStorage.amount;
                    case 3 -> AlloySmelterBlockEntity.this.energyStorage.capacity;
                    case 4 -> AlloySmelterBlockEntity.this.burnProgress;
                    case 5 -> AlloySmelterBlockEntity.this.maxBurnProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AlloySmelterBlockEntity.this.progress = value;
                    case 1 -> AlloySmelterBlockEntity.this.maxProgress = value;
                    case 5 -> AlloySmelterBlockEntity.this.maxBurnProgress = value;
                }
            }

            @Override
            public int size() {
                return 6;
            }
        };
    }

    public MGEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.moregears.alloy_smelter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlloySmelterMenu(syncId, playerInventory, this, this.data);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("energy", energyStorage.amount);

        nbt.putInt("progress", progress);
        nbt.putInt("burnProgress", burnProgress);
        nbt.putInt("maxBurnProgress", maxBurnProgress);
        nbt.putBoolean("isBurning", isBurning);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        Inventories.readNbt(nbt, inventory);
        energyStorage.setEnergy(nbt.getInt("energy"));

        progress = nbt.getInt("progress");
        burnProgress = nbt.getInt("burnProgress");
        maxBurnProgress = nbt.getInt("maxBurnProgress");
        isBurning = nbt.getBoolean("isBurning");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        var nbt = super.toInitialChunkDataNbt();
        writeNbt(nbt);
        return nbt;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return slot == OUTPUT_SLOT[0] && side == Direction.DOWN;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if (slot == FUEL_SLOT && side == Direction.UP) {
            return AbstractFurnaceBlockEntity.canUseAsFuel(stack);
        } else return slot == INPUT_SLOT[0] || slot == INPUT_SLOT[1] && side != Direction.UP && side != Direction.DOWN;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        generateEnergy();
        markDirty();
        if (world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);

        if (hasRecipe() && energyStorage.amount >= 1) {
            increaseCraftingProgress();
            try (Transaction transaction = Transaction.openOuter()) {
                energyStorage.extract(10, transaction);
                transaction.commit();
            }
            markDirty(world, pos, state);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
                markDirty(world, pos, state);
            }
        } else {
            resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void generateEnergy() {
        if (getFuelTime(inventory.get(FUEL_SLOT)) > 0 && !isBurning) {
            maxBurnProgress = Math.max(getFuelTime(inventory.get(FUEL_SLOT)), 0);
        }

        if (getFuelTime(inventory.get(FUEL_SLOT)) > 0 || isBurning && energyStorage.amount < energyStorage.capacity) {
            if (burnProgress >= maxBurnProgress) {
                burnProgress = 0;
                isBurning = false;
                return;
            }

            if (burnProgress == 0) {
                this.removeStack(FUEL_SLOT, 1);
                isBurning = true;
            }

            try (Transaction transaction = Transaction.openOuter()) {
                energyStorage.insert(100, transaction);
                transaction.commit();
            }
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
                if (ingredient.test(inventory.get(INPUT_SLOT[0]))) {
                    extractFromSlot0 += Math.min(inventory.get(INPUT_SLOT[0]).getCount(), ingredient.getMatchingStacks()[0].getCount());
                } else if (ingredient.test(inventory.get(INPUT_SLOT[1]))) {
                    extractFromSlot1 += Math.min(inventory.get(INPUT_SLOT[1]).getCount(), ingredient.getMatchingStacks()[0].getCount());
                }
            }

            if (extractFromSlot0 > 0) {
                this.removeStack(INPUT_SLOT[0], extractFromSlot0);
            }
            if (extractFromSlot1 > 0) {
                this.removeStack(INPUT_SLOT[1], extractFromSlot1);
            }

            int outputSlot = findSuitableOutputSlot(results);
            if (outputSlot != -1) {
                this.inventory.set(outputSlot, new ItemStack(results.getItem(), this.inventory.get(outputSlot).getCount() + results.getCount()));
            } else {
                System.err.println("No suitable output slot found for item: " + results);
            }
        }
    }

    private int findSuitableOutputSlot(ItemStack result) {
        for (int i : OUTPUT_SLOT) {
            ItemStack stackInSlot = this.inventory.get(i);
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxCount())) {
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
        for (int inputSlot : INPUT_SLOT) {
            userInputs.add(this.inventory.get(inputSlot));
        }

        // Check if all recipe ingredients are matched with user inputs
        for (Ingredient recipeIngredient : recipeIngredients) {
            boolean ingredientMatched = false;

            // Try to match the ingredient with one of the user inputs
            Iterator<ItemStack> userInputIterator = userInputs.iterator();
            while (userInputIterator.hasNext()) {
                ItemStack userInput = userInputIterator.next();

                if (recipeIngredient.test(userInput) && userInput.getCount() >= recipeIngredient.getMatchingStacks()[0].getCount()) {
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


    private boolean checkSlot(ItemStack results) {
        int count = 0;
        int emptyCount = 0;
        count++;

        for (int i : OUTPUT_SLOT) {
            ItemStack stackInSlot = this.inventory.get(i);
            if (!stackInSlot.isEmpty()) {
                if (stackInSlot.getItem() == results.getItem()) {
                    if (stackInSlot.getCount() + results.getCount() <= 64) {
                        emptyCount++;
                    }
                }
            } else {
                emptyCount++;
            }
        }

        return emptyCount >= count;
    }

    private Optional<AlloySmeltingRecipe> getCurrentRecipe() {
        ItemStack[] inputs = new ItemStack[2];

        for (int i : INPUT_SLOT) {
            inputs[i - 1] = this.inventory.get(i);
        }

        return this.world.getRecipeManager().getFirstMatch(AlloySmeltingRecipe.Type.INSTANCE, new SimpleInventory(inputs), world);
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        for (int i : OUTPUT_SLOT) {
            ItemStack stackInSlot = this.inventory.get(i);
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxCount())) {
                return true;
            }
        }

        return false;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        for (int i : OUTPUT_SLOT) {
            ItemStack stackInSlot = this.inventory.get(i);
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

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            Item item = fuel.getItem();
            return (Integer) AbstractFurnaceBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
        }
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(pos);
    }
}
