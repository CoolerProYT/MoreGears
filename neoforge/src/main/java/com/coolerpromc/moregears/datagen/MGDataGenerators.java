package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.datagen.bootstrap.MGBiomeModifiers;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.worldgen.MGConfiguredFeatures;
import com.coolerpromc.moregears.worldgen.MGPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;

@EventBusSubscriber(modid = MoreGears.MODID)
public class MGDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createReloadableRegistryObjects(new RegistrySetBuilder()
                .add(RecipeProvider.asBootstrap(MGRecipeProvider::new))
                .add(Registries.LOOT_TABLE, new MGLootTableProvider()),
            Set.of("minecraft", Constants.MODID)
        );
        event.createProvider(MGModelProvider::new);
        event.createProvider(MGEquipmentInfoProvider::new);
        event.createWorldRegistryObjects(new RegistrySetBuilder()
                .add(Registries.FEATURE, MGConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, MGPlacedFeatures::bootstrap)
                .add(Registries.TRIM_MATERIAL, MGTrimMaterials::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MGBiomeModifiers::bootstrap),
            Set.of("minecraft", Constants.MODID)
        );
        event.createProvider(MGBlockTagGenerator::new);
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Server event) {
        event.createProvider(MGItemTagGenerator::new);
    }
}
