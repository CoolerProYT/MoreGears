package com.coolerpromc.moregears.item.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MGArrowEntity extends AbstractArrow {
    private final ItemStack stack;

    public MGArrowEntity(EntityType<? extends AbstractArrow> p_331098_, Level p_331626_, ItemStack pickupItemStack) {
        super(p_331098_, p_331626_);
        this.stack = pickupItemStack;
    }

    public MGArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity owner, Level level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon, double baseDamage) {
        super(entityType, owner, level, pickupItemStack.copyWithCount(1), firedFromWeapon);
        this.stack = pickupItemStack;
        this.pickup = Pickup.ALLOWED;

        if (firedFromWeapon != null && firedFromWeapon.is(Items.BOW)){
            int powerLevel = firedFromWeapon.getEnchantmentLevel(level.registryAccess().getOrThrow(Enchantments.POWER));
            if (powerLevel > 0) {
                baseDamage += (baseDamage * 0.25D) * (powerLevel + 1);
            }

            int infinityLevel = firedFromWeapon.getEnchantmentLevel(level.registryAccess().getOrThrow(Enchantments.INFINITY));
            this.pickup = infinityLevel > 0 ? Pickup.DISALLOWED : Pickup.ALLOWED;
        }
        this.setBaseDamage(baseDamage);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return stack;
    }
}
