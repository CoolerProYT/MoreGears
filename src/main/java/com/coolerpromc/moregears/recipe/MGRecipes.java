package com.coolerpromc.moregears.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;

public class MGRecipes {
    public static final RecipeSerializer<?> ALLOY_SMELTING_SERIALIZER = registerSerializer("alloy_smelting", AlloySmeltingRecipe.Serializer.INSTANCE);
    public static final RecipeType<AlloySmeltingRecipe> ALLOY_SMELTING_TYPE = registerType("alloy_smelting");

    private static RecipeSerializer<?> registerSerializer(String name, RecipeSerializer<?> recipe) {
        return RecipeSerializer.register(name, recipe);
    }

    private static <T extends Recipe<?>> RecipeType<T> registerType(String name) {
        return RecipeType.register(name);
    }

    public static void init() {

    }

}
