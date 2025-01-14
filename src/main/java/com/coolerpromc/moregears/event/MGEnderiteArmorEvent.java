package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

import java.util.Iterator;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGEnderiteArmorEvent {
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();

        for (ItemStack armor : armorlist) {
            if (armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        DamageSource damageSource = event.getSource();
        Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();

        for (ItemStack armor : armorlist) {
            if (armor.getItem() == MGItems.ENDERITE_HELMET.get() || armor.getItem() == MGItems.ENDERITE_CHESTPLATE.get() || armor.getItem() == MGItems.ENDERITE_LEGGINGS.get() || armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                if (damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.LAVA) || damageSource.is(DamageTypes.HOT_FLOOR)) {
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
        }
    }
}
