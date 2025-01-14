package com.coolerpromc.moregears.datagen.loot;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MGBlockLootTables extends BlockLootSubProvider {
    public MGBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(MGBlocks.TIN_ORE.get(), block -> createOreDrop(block, MGItems.RAW_TIN.get()));
        add(MGBlocks.DEEPSLATE_TIN_ORE.get(), block -> createOreDrop(block, MGItems.RAW_TIN.get()));
        add(MGBlocks.RUBY_ORE.get(), block -> createOreDrop(block, MGItems.RAW_RUBY.get()));
        add(MGBlocks.DEEPSLATE_RUBY_ORE.get(), block -> createOreDrop(block, MGItems.RAW_RUBY.get()));
        add(MGBlocks.NETHER_TITANIUM_ORE.get(), block -> createOreDrop(block, MGItems.RAW_TITANIUM.get()));
        add(MGBlocks.END_ENDERITE_ORE.get(), block -> createOreDrop(block, MGItems.RAW_ENDERITE.get()));

        dropSelf(MGBlocks.ALLOY_SMELTER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block)).filter(key -> key.getNamespace().equals(MoreGears.MODID)).isPresent()).collect(Collectors.toSet());
    }
}