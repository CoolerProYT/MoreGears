package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;

import java.util.Objects;

public class MGEnderiteArmorEvent {
    public static void onPlayerHurt(){
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof PlayerEntity player && livingEntity.getWorld() instanceof ServerWorld serverWorld) {
                Registry<DamageType> damageTypeReg = serverWorld.getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).orElse(null);
                Iterable<ItemStack> armorlist = player.getArmorItems();

                if (damageTypeReg != null) {
                    for (ItemStack armor : armorlist){
                        if (armor.getItem() == MGItems.ENDERITE_HELMET || armor.getItem() == MGItems.ENDERITE_CHESTPLATE || armor.getItem() == MGItems.ENDERITE_LEGGINGS || armor.getItem() == MGItems.ENDERITE_BOOTS){
                            if (Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.IN_FIRE)) || Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.ON_FIRE)) || Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.LAVA))){
                                player.extinguish();
                                return false;
                            }
                        }

                        if (armor.getItem() == MGItems.ENDERITE_HELMET){
                            if (Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.FLY_INTO_WALL))) {
                                return false;
                            }

                            if (Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.DROWN))) {
                                player.setAir(player.getMaxAir());
                                return false;
                            }
                        }

                        if (armor.getItem() == MGItems.ENDERITE_BOOTS){
                            if (Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.FALL)) || Objects.equals(damageSource.getType(), damageTypeReg.get(DamageTypes.HOT_FLOOR))){
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
