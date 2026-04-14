package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MGLootTableProvider extends FabricBlockLootSubProvider {
    protected MGLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(MGBlocks.TIN_ORE, block -> createOreDrop(block, MGItems.RAW_TIN));
        add(MGBlocks.DEEPSLATE_TIN_ORE, block -> createOreDrop(block, MGItems.RAW_TIN));
        add(MGBlocks.RUBY_ORE, block -> createOreDrop(block, MGItems.RAW_RUBY));
        add(MGBlocks.DEEPSLATE_RUBY_ORE, block -> createOreDrop(block, MGItems.RAW_RUBY));
        add(MGBlocks.NETHER_TITANIUM_ORE, block -> createOreDrop(block, MGItems.RAW_TITANIUM));
        add(MGBlocks.END_ENDERITE_ORE, block -> createOreDrop(block, MGItems.RAW_ENDERITE));

        dropSelf(MGBlocks.ALLOY_SMELTER);
    }
}
