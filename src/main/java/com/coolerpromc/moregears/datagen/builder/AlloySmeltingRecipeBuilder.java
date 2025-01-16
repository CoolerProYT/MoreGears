package com.coolerpromc.moregears.datagen.builder;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlloySmeltingRecipeBuilder implements RecipeBuilder {
    private final List<SizedIngredient> ingredients = new ArrayList<>();
    private final List<ItemStack> outputs = new ArrayList<>();
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

    public AlloySmeltingRecipeBuilder addOutput(ItemStack output) {
        this.outputs.add(output);
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        this.criteria.put(s, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        this.group = s;
        return this;
    }

    @Override
    public Item getResult() {
        return this.outputs.isEmpty() ? Items.AIR : this.outputs.get(0).getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        Advancement.Builder advancement = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);

        // Create the recipe instance
        AlloySmeltingRecipe recipe = new AlloySmeltingRecipe(
                this.ingredients,
                this.outputs
        );

        // Pass the recipe and advancement to the output
        recipeOutput.accept(resourceKey, recipe, advancement.build(ResourceLocation.fromNamespaceAndPath(resourceKey.location().getNamespace(), "recipes/" + resourceKey.location().getPath())));
    }
}
