package com.coolerpromc.moregears.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MGArrowEntity extends PersistentProjectileEntity {
    private final ItemStack stack;

    public MGArrowEntity(EntityType<? extends PersistentProjectileEntity> p_331098_, World p_331626_, ItemStack pickupItemStack) {
        super(p_331098_, p_331626_);
        this.stack = pickupItemStack;
    }

    public MGArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, LivingEntity owner, World level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon, double baseDamage) {
        super(entityType, owner, level, pickupItemStack.copyWithCount(1), firedFromWeapon);
        this.stack = pickupItemStack;
        this.pickupType = PickupPermission.ALLOWED;

        if (firedFromWeapon != null && firedFromWeapon.getItem() instanceof BowItem){
            int powerLevel = EnchantmentHelper.getLevel(level.getRegistryManager().getOptionalEntry(Enchantments.POWER).orElseThrow(), firedFromWeapon);
            if (powerLevel > 0) {
                baseDamage += (baseDamage * 0.25D) * (powerLevel + 1);
            }

            int infinityLevel = EnchantmentHelper.getLevel(level.getRegistryManager().getOptionalEntry(Enchantments.INFINITY).orElseThrow(), firedFromWeapon);
            this.pickupType = infinityLevel > 0 ? PickupPermission.CREATIVE_ONLY : PickupPermission.ALLOWED;
        }
        this.setDamage(baseDamage);
    }

    public MGArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, double x, double y, double z, World level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
        this.stack = pickupItemStack;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return stack;
    }
}