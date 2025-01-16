/*
package com.coolerpromc.moregears.compat.jei;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.compat.jei.category.AlloySmeltingCategory;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public Identifier getPluginUid() {
        return Identifier.of(MoreGears.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloySmeltingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = MinecraftClient.getInstance().world.getRecipeManager();

        List<RecipeEntry<AlloySmeltingRecipe>> meltingRecipes = recipeManager.listAllOfType(MGRecipes.ALLOY_SMELTING_TYPE);
        List<AlloySmeltingRecipe> meltingRecipeList = meltingRecipes.stream().map(RecipeEntry::value).toList();

        registration.addRecipes(AlloySmeltingCategory.ALLOY_SMELTING_TYPE, meltingRecipeList);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloySmelterScreen.class, 100, 31, 18, 23, AlloySmeltingCategory.ALLOY_SMELTING_TYPE);
    }
}
*/
