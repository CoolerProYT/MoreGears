package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;

public class MGMenuTypes {
    public static final RegistryHandler<MenuType<AlloySmelterMenu>> ALLOY_SMELTER = Services.REGISTRY.registerMenu("alloy_smelter_menu", AlloySmelterMenu::new, BlockPos.STREAM_CODEC);

    public static void load() {
    }
}
