package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class MGEnderiteArmorEvent {
    public static void onPlayerHurt(){
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof PlayerEntity player){
                assert MinecraftClient.getInstance().world != null;

                Iterable<ItemStack> armorlist = player.getArmorItems();
                DamageSources damageSources = MinecraftClient.getInstance().world.getDamageSources();

                for (ItemStack armor : armorlist){
                    if (armor.getItem() == MGItems.ENDERITE_HELMET || armor.getItem() == MGItems.ENDERITE_CHESTPLATE || armor.getItem() == MGItems.ENDERITE_LEGGINGS || armor.getItem() == MGItems.ENDERITE_BOOTS){
                        if (Objects.equals(damageSource.getType(), damageSources.inFire().getType()) || Objects.equals(damageSource.getType(), damageSources.onFire().getType()) || Objects.equals(damageSource.getType(), damageSources.lava().getType())){
                            player.extinguish();
                            return false;
                        }
                    }

                    if (armor.getItem() == MGItems.ENDERITE_HELMET){
                        if (Objects.equals(damageSource.getType(), damageSources.flyIntoWall().getType())) {
                            return false;
                        }

                        if (Objects.equals(damageSource.getType(), damageSources.drown().getType())) {
                            player.setAir(player.getMaxAir());
                            return false;
                        }
                    }

                    if (armor.getItem() == MGItems.ENDERITE_BOOTS){
                        if (Objects.equals(damageSource.getType(), damageSources.fall().getType()) || Objects.equals(damageSource.getType(), damageSources.hotFloor().getType())){
                            return false;
                        }
                    }
                }
            }
            return true;
        });
    }
}
