package com.coolerpromc.moregears.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class MGDatapackProvider extends FabricDynamicRegistryProvider {
    public MGDatapackProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider wrapperLookup, Entries entries) {
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.PLACED_FEATURE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.TRIM_MATERIAL));
    }

    @Override
    public String getName() {
        return "";
    }
}
