package com.coolerpromc.moregears.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MGArrowEntity extends PersistentProjectileEntity {
    private final ItemStack stack;

    public MGArrowEntity(EntityType<MGArrowEntity> p_331098_, World p_331626_, ItemStack pickupItemStack) {
        super(p_331098_, p_331626_);
        this.stack = pickupItemStack;
    }

    public MGArrowEntity(EntityType<MGArrowEntity> entityType, LivingEntity owner, World level, ItemStack pickupItemStack, double baseDamage) {
        super(entityType, owner, level);
        this.stack = pickupItemStack;
        this.pickupType = PickupPermission.ALLOWED;
        ItemStack firedFromWeapon = owner.getActiveItem();

        if (firedFromWeapon != null && firedFromWeapon.getItem() instanceof BowItem){
            int powerLevel = EnchantmentHelper.getLevel(Enchantments.POWER, firedFromWeapon);
            if (powerLevel > 0) {
                baseDamage += (baseDamage * 0.25D) * (powerLevel + 1);
            }

            int infinityLevel = EnchantmentHelper.getLevel(Enchantments.INFINITY, firedFromWeapon);
            this.pickupType = infinityLevel > 0 ? PickupPermission.DISALLOWED : PickupPermission.ALLOWED;
        }
        this.setDamage(baseDamage);
    }

    @Override
    protected ItemStack asItemStack() {
        return stack;
    }
}