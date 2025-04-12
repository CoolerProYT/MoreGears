package com.coolerpromc.moregears.mixin;

import com.coolerpromc.moregears.util.InfiniteArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ArrowItem.class)
public abstract class ArrowItemMixin implements InfiniteArrow {
    @Override
    public boolean isInfinite(ItemStack arrowStack, ItemStack bowStack, LivingEntity shooter) {
        return false;
    }
}
