package com.coolerpromc.moregears.datagen.builder;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlloySmeltingRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<ItemStack> outputs = new ArrayList<>();
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public static AlloySmeltingRecipeBuilder alloySmeltingRecipe() {
        return new AlloySmeltingRecipeBuilder();
    }

    private AlloySmeltingRecipeBuilder() {
        // Private constructor to enforce the use of the static factory method
    }

    public AlloySmeltingRecipeBuilder addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public AlloySmeltingRecipeBuilder addOutput(ItemStack output) {
        this.outputs.add(output);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.outputs.isEmpty() ? Items.AIR : this.outputs.get(0).getItem();
    }

    @Override
    public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
        Advancement.Builder advancement = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(advancement::criterion);

        AlloySmeltingRecipe recipe = new AlloySmeltingRecipe(this.ingredients, this.outputs);

        exporter.accept(recipeKey, recipe, advancement.build(Identifier.of(MoreGears.MODID, "recipes/" + recipeKey.getValue().getPath())));
    }
}
