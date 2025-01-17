package com.coolerpromc.moregears.compat.rei;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.compat.rei.AlloySmelting.AlloySmeltingCategory;
import com.coolerpromc.moregears.compat.rei.AlloySmelting.AlloySmeltingRecipeDisplay;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

import java.awt.*;

@me.shedaniel.rei.forge.REIPluginClient
public class REIPluginClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AlloySmeltingCategory(), configuration -> configuration.addWorkstations(EntryStacks.of(MGBlocks.ALLOY_SMELTER.get())));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(AlloySmeltingRecipe.class, AlloySmeltingRecipe.Type.INSTANCE, AlloySmeltingRecipeDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 100, ((screen.height - 166) / 2) + 31, 18, 23), AlloySmelterScreen.class, AlloySmeltingCategory.ALLOY_SMELTING);
    }
}
