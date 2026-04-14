package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.CommonClientClass;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;

@EventBusSubscriber(modid = MoreGears.MODID, value = Dist.CLIENT)
public class ModRecipeReceived {
    @SubscribeEvent
    public static void onRecipesReceived(RecipesReceivedEvent event) {
        CommonClientClass.recipeMap = event.getRecipeMap();
    }

}