package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MGRecipes {
    public static void init() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MoreGears.MODID, AlloySmeltingRecipe.Serializer.ID), AlloySmeltingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, AlloySmeltingRecipe.Type.ID, AlloySmeltingRecipe.Type.INSTANCE);
    }

}
