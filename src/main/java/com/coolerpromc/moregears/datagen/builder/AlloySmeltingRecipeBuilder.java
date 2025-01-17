package com.coolerpromc.moregears.datagen.builder;

import com.coolerpromc.moregears.recipe.MGRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AlloySmeltingRecipeBuilder implements RecipeBuilder {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private ItemStack outputs = ItemStack.EMPTY;
    private final Map<String, CriterionTriggerInstance> criteria = new LinkedHashMap<>();
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
    public AlloySmeltingRecipeBuilder unlockedBy(String name, CriterionTriggerInstance criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        this.group = s;
        return this;
    }

    @Override
    public Item getResult() {
        return this.outputs.isEmpty() ? Items.AIR : this.outputs.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        consumer.accept(new Result(resourceLocation, ingredients, outputs));
    }

    public static class Result implements FinishedRecipe{
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final ItemStack outputs;

        public Result(ResourceLocation id, List<Ingredient> ingredients, ItemStack outputs) {
            this.id = id;
            this.ingredients = ingredients;
            this.outputs = outputs;
        }

        @Override
        public void serializeRecipeData(JsonObject jsonObject) {
            jsonObject.addProperty("type", "moregears:alloy_smelting");

            JsonArray ingredientArray = new JsonArray();
            for (Ingredient ingredient : ingredients) {
                ingredientArray.add(ingredient.toJson());
            }
            jsonObject.add("ingredients", ingredientArray);

            JsonObject outputJson = new JsonObject();
            outputJson.addProperty("item", outputs.getDescriptionId().substring(outputs.getDescriptionId().indexOf(".") + 1).replace('.', ':'));
            outputJson.addProperty("count", outputs.getCount());
            jsonObject.add("output", outputJson);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return MGRecipes.ALLOY_SMELTING_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
