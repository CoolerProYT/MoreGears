package com.coolerpromc.moregears.item.custom;

import com.coolerpromc.moregears.entity.custom.MGArrowEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MGArrowItem extends ArrowItem {
    private final double baseDamage;
    private final EntityType<? extends PersistentProjectileEntity> entityType;

    public MGArrowItem(Item.Settings p_40512_, double baseDamage, EntityType<? extends PersistentProjectileEntity> entityType) {
        super(p_40512_);
        this.baseDamage = baseDamage;
        this.entityType = entityType;
    }

    @Override
    public PersistentProjectileEntity createArrow(World level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new MGArrowEntity(entityType, shooter, level, ammo.copyWithCount(1), weapon, baseDamage);
    }

    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return EnchantmentHelper.getEquipmentLevel(livingEntity.getWorld().getRegistryManager().getEntryOrThrow(Enchantments.INFINITY), livingEntity) > 0;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        MGArrowEntity arrow = new MGArrowEntity(
                entityType,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                world,
                stack.copyWithCount(1),
                null
        );
        arrow.setDamage(baseDamage);
        arrow.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return arrow;
    }
}