package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;

@Mod.EventBusSubscriber(modid = MoreGears.MODID)
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
    public static void onLivingDamage(LivingDamageEvent event) {
        DamageSource damageSource = event.getSource();
        Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();

        for (ItemStack armor : armorlist) {
            if (armor.getItem() == MGItems.ENDERITE_HELMET.get() || armor.getItem() == MGItems.ENDERITE_CHESTPLATE.get() || armor.getItem() == MGItems.ENDERITE_LEGGINGS.get() || armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                if (damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.LAVA)) {
                    event.getEntity().clearFire();
                    event.setAmount(0);
                    event.setCanceled(true);
                }
            }

            if (armor.getItem() == MGItems.ENDERITE_HELMET.get()){
                if (damageSource.is(DamageTypes.FLY_INTO_WALL)){
                    event.setAmount(0);
                    event.setCanceled(true);
                }
                if (damageSource.is(DamageTypes.DROWN)){
                    event.getEntity().setAirSupply(event.getEntity().getMaxAirSupply());
                    event.setAmount(0);
                    event.setCanceled(true);
                }
            }

            if (armor.getItem() == MGItems.ENDERITE_BOOTS.get()) {
                if (damageSource.is(DamageTypes.HOT_FLOOR)){
                    event.setAmount(0);
                    event.setCanceled(true);
                }
            }
        }
    }
}
