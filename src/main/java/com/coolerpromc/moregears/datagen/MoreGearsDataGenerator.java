package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.worldgen.MGConfiguredFeatures;
import com.coolerpromc.moregears.worldgen.MGPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MoreGearsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MGModelProvider::new);
		pack.addProvider(MGLootTableProvider::new);
		pack.addProvider(MGBlockTagGenerator::new);
		pack.addProvider(MGItemTagProvider::new);
		pack.addProvider(MGRecipeProvider::new);
		pack.addProvider(MGWorldGenProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, MGConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, MGPlacedFeatures::bootstrap);
	}
}
