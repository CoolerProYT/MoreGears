package com.coolerpromc.moregears.item.custom;

import com.coolerpromc.moregears.entity.MGArrowEntity;
import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MGArrowItem extends ArrowItem {
    private final double baseDamage;
    private final EntityType<? extends AbstractArrow> entityType;

    public MGArrowItem(Properties p_40512_, double baseDamage, EntityType<? extends AbstractArrow> entityType) {
        super(p_40512_);
        this.baseDamage = baseDamage;
        this.entityType = entityType;
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new MGArrowEntity(entityType, shooter, level, ammo.copyWithCount(1), weapon, baseDamage);
    }

    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return EnchantmentHelper.getItemEnchantmentLevel(livingEntity.registryAccess().getOrThrow(Enchantments.INFINITY), bow) > 0;
    }

    @Override
    public Projectile asProjectile(Level level, Position location, ItemStack stack, Direction p_338469_) {
        MGArrowEntity arrow = new MGArrowEntity(
                entityType,
                location.x(),
                location.y(),
                location.z(),
                level,
                stack.copyWithCount(1),
                null
        );
        arrow.setBaseDamage(baseDamage);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }

    public enum MGArrowType implements StringRepresentable {
        COPPER("copper"),
        BRONZE("bronze"),
        STEEL("steel"),
        RUBY("ruby"),
        TITANIUM("titanium"),
        ENDERITE("enderite");

        public static final Codec<MGArrowType> CODEC = StringRepresentable.fromEnum(MGArrowType::values);
        private final String name;

        MGArrowType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
