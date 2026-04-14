package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

import java.util.List;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGEnderiteArmorEvent {
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player){
            List<ItemStack> armorlist = List.of(
                    player.getItemBySlot(EquipmentSlot.FEET),
                    player.getItemBySlot(EquipmentSlot.LEGS),
                    player.getItemBySlot(EquipmentSlot.CHEST),
                    player.getItemBySlot(EquipmentSlot.HEAD));

            for (ItemStack armor : armorlist) {
                if (armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Player player){
            DamageSource damageSource = event.getSource();
            List<ItemStack> armorlist = List.of(
                    player.getItemBySlot(EquipmentSlot.FEET),
                    player.getItemBySlot(EquipmentSlot.LEGS),
                    player.getItemBySlot(EquipmentSlot.CHEST),
                    player.getItemBySlot(EquipmentSlot.HEAD));

            for (ItemStack armor : armorlist) {
                if (armor.getItem() == MGItems.ENDERITE_HELMET.get() || armor.getItem() == MGItems.ENDERITE_CHESTPLATE.get() || armor.getItem() == MGItems.ENDERITE_LEGGINGS.get() || armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                    if (damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.LAVA)) {
                        event.getEntity().clearFire();
                        event.setNewDamage(0);
                    }
                }

                if (armor.getItem() == MGItems.ENDERITE_HELMET.get()){
                    if (damageSource.is(DamageTypes.FLY_INTO_WALL)){
                        event.setNewDamage(0);
                    }
                    if (damageSource.is(DamageTypes.DROWN)){
                        event.getEntity().setAirSupply(event.getEntity().getMaxAirSupply());
                        event.setNewDamage(0);
                    }
                }

                if (armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                    if (damageSource.is(DamageTypes.HOT_FLOOR)){
                        event.setNewDamage(0);
                    }
                }
            }
        }
    }
}
