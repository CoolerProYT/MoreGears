package com.coolerpromc.moregears.recipe.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import java.util.List;

public record MultipleRecipeInput(List<ItemStack> inputItems) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return inputItems.get(i);
    }

    @Override
    public int size() {
        return 2;
    }
}
