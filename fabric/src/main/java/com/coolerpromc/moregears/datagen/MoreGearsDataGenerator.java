package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.worldgen.MGConfiguredFeatures;
import com.coolerpromc.moregears.worldgen.MGPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class MoreGearsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		CompletableFuture<HolderLookup.Provider> registriesFuture = fabricDataGenerator.getRegistries();

		pack.addProvider(MGModelProvider::new);
		pack.addProvider(MGLootTableProvider::new);
		pack.addProvider(MGBlockTagGenerator::new);
		pack.addProvider(MGItemTagProvider::new);
		pack.addProvider(MGRecipeProvider::new);
		pack.addProvider(MGDatapackProvider::new);
		pack.addProvider(MGEquipmentInfoProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, MGConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, MGPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.TRIM_MATERIAL, MGTrimMaterials::bootstrap);
	}
}
