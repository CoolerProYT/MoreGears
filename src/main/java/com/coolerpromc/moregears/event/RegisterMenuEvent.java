package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = MoreGears.MODID, bus = EventBusSubscriber.Bus.MOD)
public class RegisterMenuEvent {
    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event)
    {
        event.register(MGMenuTypes.ALLOY_SMELTER.get(), AlloySmelterScreen::new);
    }
}
