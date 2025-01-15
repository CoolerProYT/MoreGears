package com.coolerpromc.moregears;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.event.MGCopperArmorEvent;
import com.coolerpromc.moregears.event.MGEnderiteArmorEvent;
import com.coolerpromc.moregears.item.MGCreativeTab;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import com.coolerpromc.moregears.worldgen.MGWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreGears implements ModInitializer {
	public static final String MODID = "moregears";

	@Override
	public void onInitialize() {
		MGCopperArmorEvent.preventLightningBolt();
		MGEnderiteArmorEvent.onPlayerHurt();

		MGItems.init();
		MGBlocks.init();
		MGBlockEntities.init();
		MGCreativeTab.init();
		MGRecipes.init();
		MGMenuTypes.init();
		MGWorldGeneration.generateModWorldGen();
	}
}