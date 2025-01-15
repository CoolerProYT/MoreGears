package com.coolerpromc.moregears.compat.rei.AlloySmelting;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class AlloySmeltingRecipeDisplay extends BasicDisplay {
    public AlloySmeltingRecipeDisplay(RecipeEntry<AlloySmeltingRecipe> recipe) {
        super(
                List.of(
                        EntryIngredients.ofIngredient(Ingredient.ofItems(Items.COAL)),
                        EntryIngredients.ofIngredient(recipe.value().getInputItems().get(0)),
                        EntryIngredients.ofIngredient(recipe.value().getInputItems().get(1))
                ),
                List.of(EntryIngredients.of(recipe.value().getOutput().get(0)))
        );
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloySmeltingCategory.ALLOY_SMELTING;
    }
}