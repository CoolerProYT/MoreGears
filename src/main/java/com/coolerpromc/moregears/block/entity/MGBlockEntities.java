package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MGBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MoreGears.MODID);

    public static final Supplier<BlockEntityType<AlloySmelterBlockEntity>> ALLOY_SMELTER_BE = BLOCK_ENTITY_TYPE.register("alloy_smelter_be",
            () -> new BlockEntityType<>(AlloySmelterBlockEntity::new, MGBlocks.ALLOY_SMELTER.get()));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}
