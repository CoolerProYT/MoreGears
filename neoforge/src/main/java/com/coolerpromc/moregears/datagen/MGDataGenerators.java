package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.datagen.bootstrap.MGBiomeModifiers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new MGRecipeProvider.Runner(packOutput, lookupProvider));
        event.addProvider(new MGLootTableProvider(packOutput, lookupProvider));

        event.addProvider(new MGModelProvider(packOutput));
        event.addProvider(new MGEquipmentInfoProvider(packOutput));
        event.addProvider(new MGDatapackProvider(packOutput, lookupProvider));
        event.addProvider(new MGBlockTagGenerator(packOutput, lookupProvider));
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new MGItemTagGenerator(packOutput, lookupProvider));
        event.addProvider(new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, new RegistrySetBuilder().add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MGBiomeModifiers::bootstrap), Set.of(Constants.MODID)));
    }
}
