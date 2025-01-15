package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.block.entity.AlloySmelterBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class AlloySmelterMenu extends ScreenHandler {
    public final AlloySmelterBlockEntity blockEntity;
    private final Inventory inventory;
    private final PropertyDelegate data;

    public AlloySmelterMenu(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(6));
    }

    public AlloySmelterMenu(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(MGMenuTypes.ALLOY_SMELTER_MENU, syncId);
        checkSize((Inventory) blockEntity, 4);
        this.blockEntity = (AlloySmelterBlockEntity) blockEntity;
        this.inventory = (Inventory) blockEntity;
        this.data = propertyDelegate;

        this.addSlot(new Slot(inventory, 0 ,31, 23));
        this.addSlot(new Slot(inventory, 1 ,83, 23));
        this.addSlot(new Slot(inventory, 2 ,119, 23));
        this.addSlot(new Slot(inventory, 3 ,101, 55));

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);

        addProperties(propertyDelegate);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public long getEnergy() {
        return this.blockEntity.getEnergyStorage().getAmount();
    }

    public long getMaxEnergy() {
        return this.blockEntity.getEnergyStorage().getCapacity();
    }

    public int getEnergyStoredScaled() {
        return (int) (((float) getEnergy() / (float) getMaxEnergy()) * 58);
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 25; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public boolean isGeneratingEnergy() {
        return this.data.get(4) > 0;
    }

    public int getEnergyProgress() {
        int progress = this.data.get(4);
        int maxProgress = this.data.get(5);
        int progressArrowSize = 18;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
}
