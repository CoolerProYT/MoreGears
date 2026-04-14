package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class MGBlockEntities {
    public static final RegistryHandler<BlockEntityType<AlloySmelterBlockEntity>> ALLOY_SMELTER_BE = Services.REGISTRY.registerBlockEntity("alloy_smelter_be", AlloySmelterBlockEntity::new, MGBlocks.ALLOY_SMELTER);

    public static void load(){
    }
}
