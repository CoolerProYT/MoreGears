package com.coolerpromc.moregears.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class MGArrowItem extends ArrowItem {
    private final double baseDamage;
    private final RegistryObject<EntityType<MGArrowEntity>> entityType;

    public MGArrowItem(Properties p_40512_, double baseDamage, RegistryObject<EntityType<MGArrowEntity>> entityType) {
        super(p_40512_);
        this.baseDamage = baseDamage;
        this.entityType = entityType;
    }

    @Override
    public AbstractArrow createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        return new MGArrowEntity(entityType.get(), p_40515_, p_40513_, p_40514_.copyWithCount(1), baseDamage);
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        return bow.getEnchantmentLevel(Enchantments.INFINITY_ARROWS) > 0;

    }

    @Override
    public @Nullable Entity createEntity(Level level, Entity location, ItemStack stack) {
        MGArrowEntity arrow = new MGArrowEntity(
                entityType.get(),
                location.getX(),
                location.getY(),
                location.getZ(),
                level,
                stack.copyWithCount(1),
                null
        );
        arrow.setBaseDamage(baseDamage);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
}