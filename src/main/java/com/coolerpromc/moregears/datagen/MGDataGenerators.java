package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MoreGears.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MGDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new MGRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new MGLootTableProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new MGBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new MGItemModelProvider(packOutput, existingFileHelper));

        MGBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new MGBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new MGItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new MGWorldGenProvider(packOutput, lookupProvider));
    }
}
