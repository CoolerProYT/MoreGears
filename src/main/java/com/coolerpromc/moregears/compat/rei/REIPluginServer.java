package com.coolerpromc.moregears.compat.rei;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.compat.rei.AlloySmelting.AlloySmeltingRecipeDisplay;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.forge.REIPluginCommon;
import net.minecraft.resources.ResourceLocation;

@REIPluginCommon
public class REIPluginServer implements REICommonPlugin {
    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "alloy_smelting"), AlloySmeltingRecipeDisplay.SERIALIZER);
    }

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(AlloySmeltingRecipe.class).filterType(MGRecipes.ALLOY_SMELTING_TYPE.get()).fill(AlloySmeltingRecipeDisplay::new);
    }
}