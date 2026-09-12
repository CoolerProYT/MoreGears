package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.worldgen.MGConfiguredFeatures;
import com.coolerpromc.moregears.worldgen.MGPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MoreGearsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MGItemTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.FEATURE, MGConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, MGPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.TRIM_MATERIAL, MGTrimMaterials::bootstrap);
	}
}
