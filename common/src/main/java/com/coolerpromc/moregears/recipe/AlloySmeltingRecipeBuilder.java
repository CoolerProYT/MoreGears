package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.recipe.custom.SizedIngredient;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlloySmeltingRecipeBuilder implements RecipeBuilder {
    private final List<SizedIngredient> ingredients = new ArrayList<>();
    private final List<ItemStackTemplate> outputs = new ArrayList<>();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public static AlloySmeltingRecipeBuilder alloySmeltingRecipe() {
        return new AlloySmeltingRecipeBuilder();
    }

    private AlloySmeltingRecipeBuilder() {
        // Private constructor to enforce the use of the static factory method
    }

    public AlloySmeltingRecipeBuilder addIngredient(SizedIngredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public AlloySmeltingRecipeBuilder addOutput(ItemStackTemplate output) {
        this.outputs.add(output);
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(this.outputs.getFirst());
    }

    @Override
    public void save(RecipeOutput exporter, ResourceKey<Recipe<?>> recipeKey) {
        Advancement.Builder advancement = exporter.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);

        AlloySmeltingRecipe recipe = new AlloySmeltingRecipe(this.ingredients, this.outputs);

        exporter.accept(recipeKey, recipe, advancement.build(Constants.id("recipes/" + recipeKey.identifier().getPath())));
    }
}
