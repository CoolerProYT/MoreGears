package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;

import java.util.List;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGCopperArmorEvent {
    @SubscribeEvent
    public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        if (event.getEntity() instanceof Player player){
            if (isCopperArmor(player)){
                event.setCanceled(true);
            }
        }
    }

    private static boolean isCopperArmor(Player player){
        List<ItemStack> armor = List.of(
                player.getItemBySlot(EquipmentSlot.FEET),
                player.getItemBySlot(EquipmentSlot.LEGS),
                player.getItemBySlot(EquipmentSlot.CHEST),
                player.getItemBySlot(EquipmentSlot.HEAD));

        return armor.get(0).getItem() == MGItems.COPPER_BOOTS.get() &&
                armor.get(1).getItem() == MGItems.COPPER_LEGGINGS.get() &&
                armor.get(2).getItem() == MGItems.COPPER_CHESTPLATE.get() &&
                armor.get(3).getItem() == MGItems.COPPER_HELMET.get();
    }
}
