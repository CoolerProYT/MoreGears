package com.coolerpromc.moregears;

import com.coolerpromc.moregears.event.MGCapabilities;
import com.coolerpromc.moregears.event.MGCopperArmorEvent;
import com.coolerpromc.moregears.event.MGEnderiteArmorEvent;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.worldgen.MGPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MoreGears implements ModInitializer {
	@Override
	public void onInitialize() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> MGCopperArmorEvent.preventLightningBolt(livingEntity, damageSource));
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> MGEnderiteArmorEvent.onPlayerHurt(livingEntity, damageSource));

		CommonClass.init();

		MGCapabilities.register();

		DispenserBlock.registerProjectileBehavior(MGItems.COPPER_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.BRONZE_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.STEEL_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.RUBY_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.TITANIUM_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.ENDERITE_ARROW);

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, MGPlacedFeatures.TIN_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, MGPlacedFeatures.RUBY_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, MGPlacedFeatures.NETHER_TITANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Decoration.UNDERGROUND_ORES, MGPlacedFeatures.END_ENDERITE_ORE_PLACED_KEY);

        RecipeSynchronization.synchronizeRecipeSerializer(MGRecipes.ALLOY_SMELTING_SERIALIZER.get());
	}
}