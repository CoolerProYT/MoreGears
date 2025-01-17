package com.coolerpromc.moregears.datagen.builder;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AlloySmeltingRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private ItemStack outputs = ItemStack.EMPTY;
    private final Map<String, CriterionConditions> criteria = new LinkedHashMap<>();
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
        this.outputs = output;
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, CriterionConditions conditions) {
        this.criteria.put(name, conditions);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.outputs.isEmpty() ? Items.AIR : this.outputs.getItem();
    }

    @Override
    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipePath) {
        exporter.accept(new Result(recipePath, this.ingredients, this.outputs));
    }

    public static class Result implements RecipeJsonProvider{
        private final Identifier id;
        private final List<Ingredient> ingredients;
        private final ItemStack outputs;

        public Result(Identifier id, List<Ingredient> ingredients, ItemStack outputs) {
            this.id = id;
            this.ingredients = ingredients;
            this.outputs = outputs;
        }

        @Override
        public void serialize(JsonObject jsonObject) {
            jsonObject.addProperty("type", "moregears:alloy_smelting");

            JsonArray ingredientArray = new JsonArray();
            for (Ingredient ingredient : ingredients) {
                ingredientArray.add(ingredient.toJson());
            }
            jsonObject.add("ingredients", ingredientArray);

            JsonObject outputJson = new JsonObject();
            outputJson.addProperty("item", outputs.getTranslationKey().substring(outputs.getTranslationKey().indexOf(".") + 1).replace('.', ':'));
            outputJson.addProperty("count", outputs.getCount());
            jsonObject.add("output", outputJson);
        }

        @Override
        public Identifier getRecipeId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return AlloySmeltingRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject toAdvancementJson() {
            return null;
        }

        @Nullable
        @Override
        public Identifier getAdvancementId() {
            return null;
        }
    }
}
