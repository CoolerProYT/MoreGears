package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.datagen.loot.MGBlockLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MGLootTableProvider extends LootTableProvider {
    public MGLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(new SubProviderEntry(MGBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
