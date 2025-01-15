package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MGLootTableProvider extends FabricBlockLootTableProvider {
    protected MGLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(MGBlocks.TIN_ORE, block -> oreDrops(block, MGItems.RAW_TIN));
        addDrop(MGBlocks.DEEPSLATE_TIN_ORE, block -> oreDrops(block, MGItems.RAW_TIN));
        addDrop(MGBlocks.RUBY_ORE, block -> oreDrops(block, MGItems.RAW_RUBY));
        addDrop(MGBlocks.DEEPSLATE_RUBY_ORE, block -> oreDrops(block, MGItems.RAW_RUBY));
        addDrop(MGBlocks.NETHER_TITANIUM_ORE, block -> oreDrops(block, MGItems.RAW_TITANIUM));
        addDrop(MGBlocks.END_ENDERITE_ORE, block -> oreDrops(block, MGItems.RAW_ENDERITE));

        addDrop(MGBlocks.ALLOY_SMELTER);
    }
}
