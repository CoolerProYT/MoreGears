package com.coolerpromc.moregears.compat.rei.AlloySmelting;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class AlloySmeltingRecipeDisplay extends BasicDisplay {
    public AlloySmeltingRecipeDisplay(AlloySmeltingRecipe recipe) {
        super(
                List.of(
                        EntryIngredients.ofIngredient(Ingredient.of(Items.COAL)),
                        EntryIngredients.ofIngredient(recipe.getInputItems().get(0)),
                        EntryIngredients.ofIngredient(recipe.getInputItems().get(1))
                ),
                List.of(EntryIngredients.of(recipe.getOutput()))
        );
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloySmeltingCategory.ALLOY_SMELTING;
    }
}
