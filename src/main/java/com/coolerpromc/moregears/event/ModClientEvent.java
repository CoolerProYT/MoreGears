package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.LinkedList;

@EventBusSubscriber(modid = MoreGears.MODID, value = Dist.CLIENT)
public class ModClientEvent {
    @SubscribeEvent
    public static void onComputeFovModifier(ComputeFovModifierEvent event) {
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() instanceof BowItem){
            float f = 1f;
            float f3 = Math.min((float)event.getPlayer().getTicksUsingItem() / 20.0F, 1.0F);
            f *= 1.0F - Mth.square(f3) * 0.15F;
            event.setNewFovModifier(f);
        }
    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().is(Items.COPPER_HELMET) || event.getItemStack().is(Items.COPPER_CHESTPLATE) || event.getItemStack().is(Items.COPPER_LEGGINGS) || event.getItemStack().is(Items.COPPER_BOOTS)){
            LinkedList<Component> tooltips = new LinkedList<>(event.getToolTip());
            tooltips.add(1, MGTooltip.itemSpecialEffect("special_effect.moregears.copper_armor"));
            event.getToolTip().clear();
            event.getToolTip().addAll(tooltips);
        }
    }
}
