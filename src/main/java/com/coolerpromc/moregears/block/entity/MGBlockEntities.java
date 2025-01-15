package com.coolerpromc.moregears.block.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class MGBlockEntities {
    public static final BlockEntityType<AlloySmelterBlockEntity> ALLOY_SMELTER_BE = register("alloy_smelter_be", BlockEntityType.Builder.create(AlloySmelterBlockEntity::new, MGBlocks.ALLOY_SMELTER).build());

    public static <T extends BlockEntityType<?>> T register(String name, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreGears.MODID, name), blockEntityType);
    }

    public static void init() {
        EnergyStorage.SIDED.registerForBlockEntities((blockEntity, direction) -> {
            if (blockEntity instanceof AlloySmelterBlockEntity alloySmelterBlockEntity) {
                return alloySmelterBlockEntity.getEnergyStorage();
            }
            return null;
        }, ALLOY_SMELTER_BE);
    }
}
