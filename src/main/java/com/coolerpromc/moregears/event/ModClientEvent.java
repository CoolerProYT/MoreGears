package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BowItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

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
}
