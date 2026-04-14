package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;

public class RegisterMenuEvent {
    public static void registerMenu() {
        MenuScreens.register(MGMenuTypes.ALLOY_SMELTER_MENU, AlloySmelterScreen::new);
    }
}
