package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Objects;

public class MGEnderiteArmorEvent {
    public static void onPlayerHurt(){
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof Player player && livingEntity.level() instanceof ServerLevel serverWorld) {
                Registry<DamageType> damageTypeReg = serverWorld.registryAccess().lookup(Registries.DAMAGE_TYPE).orElse(null);
                List<ItemStack> armorlist = List.of(player.getItemBySlot(EquipmentSlot.FEET), player.getItemBySlot(EquipmentSlot.HEAD), player.getItemBySlot(EquipmentSlot.CHEST), player.getItemBySlot(EquipmentSlot.LEGS));

                if (damageTypeReg != null) {
                    for (ItemStack armor : armorlist){
                        if (armor.getItem() == MGItems.ENDERITE_HELMET || armor.getItem() == MGItems.ENDERITE_CHESTPLATE || armor.getItem() == MGItems.ENDERITE_LEGGINGS || armor.getItem() == MGItems.ENDERITE_BOOTS){
                            if (Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.IN_FIRE)) || Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.ON_FIRE)) || Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.LAVA))){
                                player.clearFire();
                                return false;
                            }
                        }

                        if (armor.getItem() == MGItems.ENDERITE_HELMET){
                            if (Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.FLY_INTO_WALL))) {
                                return false;
                            }

                            if (Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.DROWN))) {
                                player.setAirSupply(player.getMaxAirSupply());
                                return false;
                            }
                        }

                        if (armor.getItem() == MGItems.ENDERITE_BOOTS){
                            if (Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.FALL)) || Objects.equals(damageSource.type(), damageTypeReg.getValue(DamageTypes.HOT_FLOOR))){
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        });
    }
}
