package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.util.FabricMGEnergyStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ContainerStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.core.Direction;
import team.reborn.energy.api.EnergyStorage;

public class MGCapabilities {
    public static void register() {
        EnergyStorage.SIDED.registerForBlockEntity(
                (be, direction) -> new FabricMGEnergyStorage(be.getEnergyStorage()),
                MGBlockEntities.ALLOY_SMELTER_BE.get()
        );

        ItemStorage.SIDED.registerForBlockEntity(
                (be, side) -> {
                    if (side == Direction.UP) {
                        return ContainerStorage.of(be.getFuelHandler(), null);
                    } else if (side == Direction.DOWN) {
                        return ContainerStorage.of(be.getOutputHandler(), null);
                    } else {
                        return ContainerStorage.of(be.getInputHandler(), null);
                    }
                },
                MGBlockEntities.ALLOY_SMELTER_BE.get()
        );
    }
}

