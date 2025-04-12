package com.coolerpromc.moregears.entity.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MGArrowEntity extends PersistentProjectileEntity {
    private final ItemStack stack;

    public MGArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.stack = ItemStack.EMPTY;
    }

    public MGArrowEntity(EntityType<? extends PersistentProjectileEntity> type, LivingEntity owner, World world, ItemStack stack, @Nullable ItemStack shotFrom, double baseDamage) {
        super(type, owner, world, stack, shotFrom);
        this.stack = stack;
        this.pickupType = PickupPermission.ALLOWED;

        if (shotFrom != null && shotFrom.isOf(Items.BOW)){
            int powerLevel = EnchantmentHelper.getLevel(world.getRegistryManager().getEntryOrThrow(Enchantments.POWER), shotFrom);
            if (powerLevel > 0) {
                baseDamage += (baseDamage * 0.25D) * (powerLevel + 1);
            }

            int infinityLevel = EnchantmentHelper.getLevel(world.getRegistryManager().getEntryOrThrow(Enchantments.INFINITY), shotFrom);
            this.pickupType = infinityLevel > 0 ? PickupPermission.CREATIVE_ONLY : PickupPermission.ALLOWED;
        }
        this.setDamage(baseDamage);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return stack;
    }
}
