package com.coolerpromc.moregears.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

import java.util.List;

public record MultipleRecipeInput(List<ItemStack> inputItems) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return inputItems.get(slot);
    }

    @Override
    public int size() {
        return 2;
    }
}
