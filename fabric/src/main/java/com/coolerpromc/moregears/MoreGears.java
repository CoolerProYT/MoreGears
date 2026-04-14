package com.coolerpromc.moregears;

import com.coolerpromc.moregears.event.MGCopperArmorEvent;
import com.coolerpromc.moregears.event.MGEnderiteArmorEvent;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.world.level.block.DispenserBlock;

public class MoreGears implements ModInitializer {
	@Override
	public void onInitialize() {
		MGCopperArmorEvent.preventLightningBolt();
		MGEnderiteArmorEvent.onPlayerHurt();

		CommonClass.init();

		DispenserBlock.registerProjectileBehavior(MGItems.COPPER_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.BRONZE_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.STEEL_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.RUBY_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.TITANIUM_ARROW);
		DispenserBlock.registerProjectileBehavior(MGItems.ENDERITE_ARROW);

        RecipeSynchronization.synchronizeRecipeSerializer(MGRecipes.ALLOY_SMELTING_SERIALIZER);
	}
}