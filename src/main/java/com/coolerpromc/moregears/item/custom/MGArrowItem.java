package com.coolerpromc.moregears.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MGArrowItem extends ArrowItem {
    private final double baseDamage;
    private final EntityType<MGArrowEntity> entityType;

    public MGArrowItem(Item.Settings p_40512_, double baseDamage, EntityType<MGArrowEntity> entityType) {
        super(p_40512_);
        this.baseDamage = baseDamage;
        this.entityType = entityType;
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new MGArrowEntity(entityType, shooter, world, stack.copyWithCount(1), baseDamage);
    }
}