package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;

import java.util.List;
import java.util.Objects;

public class MGCopperArmorEvent {
    public static void preventLightningBolt() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof PlayerEntity player && livingEntity.getEntityWorld() instanceof ServerWorld serverWorld){
                Registry<DamageType> damageTypeReg = serverWorld.getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).orElse(null);
                if (damageTypeReg != null && (Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.LIGHTNING_BOLT)))){
                    return !isCopperArmor(player);
                }
            }
            return true;
        });
    }

    private static boolean isCopperArmor(PlayerEntity player){
        List<ItemStack> armor = List.of(player.getEquippedStack(EquipmentSlot.FEET), player.getEquippedStack(EquipmentSlot.LEGS), player.getEquippedStack(EquipmentSlot.CHEST), player.getEquippedStack(EquipmentSlot.HEAD));
        return armor.get(0).getItem() == MGItems.COPPER_BOOTS &&
                armor.get(1).getItem() == MGItems.COPPER_LEGGINGS &&
                armor.get(2).getItem() == MGItems.COPPER_CHESTPLATE &&
                armor.get(3).getItem() == MGItems.COPPER_HELMET;
    }
}
