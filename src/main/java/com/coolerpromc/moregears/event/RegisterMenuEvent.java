package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class RegisterMenuEvent {
    public static void registerMenu() {
        HandledScreens.register(MGMenuTypes.ALLOY_SMELTER_MENU, AlloySmelterScreen::new);
    }
}
