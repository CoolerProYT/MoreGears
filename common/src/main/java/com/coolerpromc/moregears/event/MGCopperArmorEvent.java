package com.coolerpromc.moregears.event;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.Objects;

public class MGCopperArmorEvent {
    public static boolean preventLightningBolt(Entity livingEntity, DamageSource damageSource) {
        if (livingEntity instanceof Player player && livingEntity.level() instanceof ServerLevel serverWorld){
            Registry<DamageType> damageTypeReg = serverWorld.registryAccess().lookup(Registries.DAMAGE_TYPE).orElse(null);
            if (damageTypeReg != null && (Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.LIGHTNING_BOLT)))){
                return !isCopperArmor(player);
            }
        }
        return true;
    }

    private static boolean isCopperArmor(Player player){
        List<ItemStack> armor = List.of(player.getItemBySlot(EquipmentSlot.FEET), player.getItemBySlot(EquipmentSlot.LEGS), player.getItemBySlot(EquipmentSlot.CHEST), player.getItemBySlot(EquipmentSlot.HEAD));
        return armor.get(0).getItem() == Items.COPPER_BOOTS &&
                armor.get(1).getItem() == Items.COPPER_LEGGINGS &&
                armor.get(2).getItem() == Items.COPPER_CHESTPLATE &&
                armor.get(3).getItem() == Items.COPPER_HELMET;
    }
}
