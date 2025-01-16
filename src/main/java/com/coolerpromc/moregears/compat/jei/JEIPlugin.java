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
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloySmeltingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<RecipeHolder<AlloySmeltingRecipe>> meltingRecipes = recipeManager.getAllRecipesFor(MGRecipes.ALLOY_SMELTING_TYPE.get());
        List<AlloySmeltingRecipe> meltingRecipeList = meltingRecipes.stream().map(RecipeHolder::value).toList();

        registration.addRecipes(AlloySmeltingCategory.ALLOY_SMELTING_TYPE, meltingRecipeList);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloySmelterScreen.class, 100, 31, 18, 23, AlloySmeltingCategory.ALLOY_SMELTING_TYPE);
    }
}
*/
