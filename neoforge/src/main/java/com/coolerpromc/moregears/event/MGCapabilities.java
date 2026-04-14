package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.util.NeoForgeMGEnergyStorage;
import net.minecraft.core.Direction;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.item.WorldlyContainerWrapper;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGCapabilities {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.Energy.BLOCK,
                MGBlockEntities.ALLOY_SMELTER_BE.get(),
                (be, side) -> new NeoForgeMGEnergyStorage(be.getEnergyStorage()));

        event.registerBlockEntity(Capabilities.Item.BLOCK,
                MGBlockEntities.ALLOY_SMELTER_BE.get(),
                (be, side) -> {
                    if (side == Direction.UP){
                        return new WorldlyContainerWrapper(be.getFuelHandler(), null);
                    }
                    else if (side == Direction.DOWN){
                        return new WorldlyContainerWrapper(be.getOutputHandler(), null);
                    }
                    else {
                        return new WorldlyContainerWrapper(be.getInputHandler(), null);
                    }
                });
    }
}
