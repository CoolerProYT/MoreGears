package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.MoreGears;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlloySmeltingRecipe implements Recipe<SimpleContainer> {
    private final List<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;

    public AlloySmeltingRecipe(List<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer multipleRecipeInput, Level level) {
        List<ItemStack> inputItems = List.of(multipleRecipeInput.getItem(0), multipleRecipeInput.getItem(1));

        List<Ingredient> remainingIngredients  = new ArrayList<>(this.inputItems);

        for (ItemStack itemStack : inputItems) {
            if (itemStack.isEmpty()) {
                continue;
            }

            boolean ingredientFound = false;
            Iterator<Ingredient> iterator = remainingIngredients.iterator();

            while (iterator.hasNext()) {
                Ingredient ingredient = iterator.next();
                if (ingredient.test(itemStack)) {
                    iterator.remove();
                    ingredientFound = true;
                    break;
                }
            }

            if (!ingredientFound) {
                return false;
            }
        }

        return remainingIngredients.isEmpty();
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.isEmpty() ? ItemStack.EMPTY : output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.isEmpty() ? ItemStack.EMPTY : output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MGRecipes.ALLOY_SMELTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public List<Ingredient> getInputItems() {
        return inputItems;
    }

    public ItemStack getOutput() {
        return output;
    }

    public static class Type implements RecipeType<AlloySmeltingRecipe>{
        public static final AlloySmeltingRecipe.Type INSTANCE = new AlloySmeltingRecipe.Type();
        public static final String ID = "alloy_smelting";
    }

    public static class Serializer implements RecipeSerializer<AlloySmeltingRecipe>{
        public static final AlloySmeltingRecipe.Serializer INSTANCE = new AlloySmeltingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MoreGears.MODID, "alloy_smelting");

        @Override
        public AlloySmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputItems = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                inputItems.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new AlloySmeltingRecipe(inputItems, output, resourceLocation);
        }

        @Override
        public AlloySmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf buffer) {
            NonNullList<Ingredient> inputItems = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputItems.size(); i++) {
                inputItems.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();

            return new AlloySmeltingRecipe(inputItems, output, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, AlloySmeltingRecipe recipe) {
            buffer.writeInt(recipe.inputItems.size());

            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
