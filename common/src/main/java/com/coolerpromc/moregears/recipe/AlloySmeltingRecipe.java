package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.recipe.custom.MultipleRecipeInput;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public record AlloySmeltingRecipe(List<SizedIngredient> inputItems, List<ItemStackTemplate> output) implements Recipe<MultipleRecipeInput> {
    private static final MapCodec<AlloySmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(alloySmeltingRecipeInstance -> alloySmeltingRecipeInstance.group(
            SizedIngredient.NESTED_CODEC.listOf().fieldOf("ingredients").forGetter(AlloySmeltingRecipe::inputItems),
            ItemStackTemplate.CODEC.listOf().fieldOf("output").forGetter(AlloySmeltingRecipe::output)
    ).apply(alloySmeltingRecipeInstance, AlloySmeltingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, AlloySmeltingRecipe> STREAM_CODEC = StreamCodec.of(
            AlloySmeltingRecipe::toNetwork, AlloySmeltingRecipe::fromNetwork
    );
    public static final RecipeSerializer<AlloySmeltingRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    @Override
    public boolean matches(MultipleRecipeInput input, Level world) {
        List<ItemStack> inputItems = input.inputItems();
        List<SizedIngredient> remainingIngredients = new ArrayList<>(this.inputItems);

        for (ItemStack itemStack : inputItems) {
            if (itemStack.isEmpty()) {
                continue;
            }

            boolean ingredientFound = false;
            Iterator<SizedIngredient> iterator = remainingIngredients.iterator();

            while (iterator.hasNext()) {
                SizedIngredient ingredient = iterator.next();
                if (ingredient.ingredient().test(itemStack)) {
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
    public ItemStack assemble(MultipleRecipeInput input) {
        return output.isEmpty() ? ItemStack.EMPTY : output.getFirst().create();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "";
    }

    @Override
    public RecipeSerializer<? extends Recipe<MultipleRecipeInput>> getSerializer() {
        return MGRecipes.ALLOY_SMELTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<MultipleRecipeInput>> getType() {
        return MGRecipes.ALLOY_SMELTING_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        List<Ingredient> ingredients = new ArrayList<>();
        for (SizedIngredient ingredient : inputItems) {
            ingredients.add(ingredient.ingredient());
        }
        return PlacementInfo.create(ingredients);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    private static AlloySmeltingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
        int ingredientCount = buffer.readVarInt();
        List<SizedIngredient> inputItems = new ArrayList<>(ingredientCount);
        for (int i = 0; i < ingredientCount; i++) {
            inputItems.add(SizedIngredient.STREAM_CODEC.decode(buffer));
        }

        int outputCount = buffer.readVarInt();
        List<ItemStackTemplate> result = new ArrayList<>(outputCount);
        for (int i = 0; i < outputCount; i++) {
            result.add(ItemStackTemplate.STREAM_CODEC.decode(buffer));
        }

        return new AlloySmeltingRecipe(inputItems, result);
    }

    private static void toNetwork(RegistryFriendlyByteBuf buffer, AlloySmeltingRecipe recipe) {
        buffer.writeVarInt(recipe.inputItems.size());
        for (SizedIngredient ingredient : recipe.inputItems) {
            SizedIngredient.STREAM_CODEC.encode(buffer, ingredient);
        }

        buffer.writeVarInt(recipe.output.size());
        for (ItemStackTemplate itemStack : recipe.output) {
            ItemStackTemplate.STREAM_CODEC.encode(buffer, itemStack);
        }

    }
}