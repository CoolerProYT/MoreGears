package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MoreGears.MODID, bus = EventBusSubscriber.Bus.MOD)
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

        MGBlockTagGenerator blockTagGenerator = event.addProvider(new MGBlockTagGenerator(packOutput, lookupProvider));
        event.addProvider(new MGItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));

        event.addProvider(new MGWorldGenProvider(packOutput, lookupProvider));
    }
}
