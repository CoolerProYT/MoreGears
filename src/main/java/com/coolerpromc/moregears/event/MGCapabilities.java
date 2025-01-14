package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import net.minecraft.core.Direction;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = MoreGears.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MGCapabilities {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK,
                MGBlockEntities.ALLOY_SMELTER_BE.get(),
                (be, side) -> be.getEnergyStorage());

        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                MGBlockEntities.ALLOY_SMELTER_BE.get(),
                (be, side) -> {
                    if (side == Direction.UP){
                        return be.getFuelHandler();
                    }
                    else if (side == Direction.DOWN){
                        return be.getOutputHandler();
                    }
                    else {
                        return be.getInputHandler();
                    }
                });
    }
}
