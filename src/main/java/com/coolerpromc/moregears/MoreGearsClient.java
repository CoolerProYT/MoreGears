package com.coolerpromc.moregears;

import com.coolerpromc.moregears.event.RegisterColorEvent;
import com.coolerpromc.moregears.event.RegisterMenuEvent;
import net.fabricmc.api.ClientModInitializer;

public class MoreGearsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegisterColorEvent.registerColor();
        RegisterMenuEvent.registerMenu();
    }
}
