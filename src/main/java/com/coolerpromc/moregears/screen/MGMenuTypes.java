package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.MoreGears;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class MGMenuTypes {
    public static final ScreenHandlerType<AlloySmelterMenu> ALLOY_SMELTER_MENU = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreGears.MODID, "alloy_smelter_menu"), new ExtendedScreenHandlerType<>(AlloySmelterMenu::new, BlockPos.PACKET_CODEC));

    public static void init() {

    }
}
