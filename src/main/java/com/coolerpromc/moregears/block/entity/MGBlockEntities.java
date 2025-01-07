package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MGBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MoreGears.MODID);

    public static void register(IEventBus eventBus){
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}
