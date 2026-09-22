package com.coolerpromc.moregears.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

public class MGThrownTridentEntity extends ThrownTrident {
    public MGThrownTridentEntity(EntityType<? extends ThrownTrident> type, Level level) {
        super(type, level);
    }

    public static MGThrownTridentEntity create(EntityType<? extends ThrownTrident> type, Level level, LivingEntity owner, ItemStack tridentItem) {
        MGThrownTridentEntity trident = new MGThrownTridentEntity(type, level);
        trident.setPos(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        trident.setOwner(owner);
        trident.setPickupItemStack(tridentItem.copy());
        trident.entityData.set(ID_LOYALTY, trident.loyaltyOf(tridentItem));
        trident.entityData.set(ID_FOIL, tridentItem.hasFoil());
        return trident;
    }

    private byte loyaltyOf(ItemStack tridentItem) {
        return this.level() instanceof ServerLevel serverLevel ? (byte) Mth.clamp(EnchantmentHelper.getTridentReturnToOwnerAcceleration(serverLevel, tridentItem, this), 0, 127) : 0;
    }
}
