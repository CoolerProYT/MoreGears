package com.coolerpromc.moregears.item.custom;

import com.coolerpromc.moregears.entity.MGThrownTridentEntity;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class MGTridentItem extends TridentItem {
    private final Supplier<EntityType<? extends ThrownTrident>> projectileType;

    public MGTridentItem(Properties properties, Supplier<EntityType<? extends ThrownTrident>> projectileType) {
        super(properties);
        this.projectileType = projectileType;
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        if (!(entity instanceof Player player)) {
            return false;
        }

        int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
        if (timeHeld < THROW_THRESHOLD_TIME) {
            return false;
        }

        float riptideStrength = EnchantmentHelper.getTridentSpinAttackStrength(itemStack, player);
        if (riptideStrength > 0.0F && !(player.isInWaterOrRain() && !player.isPassenger())) {
            return false;
        }

        if (itemStack.nextDamageWillBreak()) {
            return false;
        }

        Holder<SoundEvent> sound = EnchantmentHelper.pickHighestLevel(itemStack, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
        player.awardStat(Stats.ITEM_USED.get(this));

        if (level instanceof ServerLevel serverLevel) {
            itemStack.hurtWithoutBreaking(1, player);
            if (riptideStrength == 0.0F) {
                ItemStack thrownItemStack = itemStack.consumeAndReturn(1, player);
                ThrownTrident trident = Projectile.spawnProjectileFromRotation((spawnLevel, shooter, stack) -> MGThrownTridentEntity.create(this.projectileType.get(), spawnLevel, shooter, stack), serverLevel, thrownItemStack, player, 0.0F, PROJECTILE_SHOOT_POWER, 1.0F);
                if (player.hasInfiniteMaterials()) {
                    trident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.playSound(null, trident, sound.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                return true;
            }
        }

        if (riptideStrength > 0.0F) {
            float yRot = player.getYRot();
            float xRot = player.getXRot();
            float xd = -Mth.sin(yRot * (float) (Math.PI / 180.0)) * Mth.cos(xRot * (float) (Math.PI / 180.0));
            float yd = -Mth.sin(xRot * (float) (Math.PI / 180.0));
            float zd = Mth.cos(yRot * (float) (Math.PI / 180.0)) * Mth.cos(xRot * (float) (Math.PI / 180.0));
            float dist = Mth.sqrt(xd * xd + yd * yd + zd * zd);
            xd *= riptideStrength / dist;
            yd *= riptideStrength / dist;
            zd *= riptideStrength / dist;
            player.push(xd, yd, zd);
            player.startAutoSpinAttack(20, 8.0F, itemStack);
            if (player.onGround()) {
                player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));
            }

            level.playSound(null, player, sound.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
            return true;
        }

        return false;
    }
}
