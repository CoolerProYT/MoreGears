package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class MGRecipes {
    public static final RegistryHandler<RecipeSerializer<AlloySmeltingRecipe>> ALLOY_SMELTING_SERIALIZER = Services.REGISTRY.registerRecipeSerializer("alloy_smelting", AlloySmeltingRecipe.SERIALIZER);
    public static final RegistryHandler<RecipeType<AlloySmeltingRecipe>> ALLOY_SMELTING_TYPE = Services.REGISTRY.registerRecipeType("alloy_smelting");

    public static void load(){
    }
}
