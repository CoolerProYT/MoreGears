package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.recipe.custom.MultipleRecipeInput;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlloySmeltingRecipe implements Recipe<MultipleRecipeInput>{
    private final List<Ingredient> inputItems;
    private final List<ItemStack> output;

    public AlloySmeltingRecipe(List<Ingredient> inputItems, List<ItemStack> output) {
        this.inputItems = inputItems;
        this.output = output;
    }

    @Override
    public boolean matches(MultipleRecipeInput input, World world) {
        List<ItemStack> inputItems = input.inputItems();
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
    public ItemStack craft(MultipleRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MGRecipes.ALLOY_SMELTING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return MGRecipes.ALLOY_SMELTING_TYPE;
    }

    public List<Ingredient> getInputItems() {
        return inputItems;
    }

    public List<ItemStack> getOutput() {
        return output;
    }

    public static class Serializer implements RecipeSerializer<AlloySmeltingRecipe>{
        public static final AlloySmeltingRecipe.Serializer INSTANCE = new AlloySmeltingRecipe.Serializer();
        public static final Identifier ID = Identifier.of(MoreGears.MODID, "alloy_smelting");

        private final MapCodec<AlloySmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(alloySmeltingRecipeInstance -> alloySmeltingRecipeInstance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(AlloySmeltingRecipe::getInputItems),
                ItemStack.CODEC.listOf().fieldOf("output").forGetter(AlloySmeltingRecipe::getOutput)
        ).apply(alloySmeltingRecipeInstance, AlloySmeltingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, AlloySmeltingRecipe> STREAM_CODEC = PacketCodec.ofStatic(
                AlloySmeltingRecipe.Serializer::toNetwork, AlloySmeltingRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<AlloySmeltingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, AlloySmeltingRecipe> packetCodec() {
            return STREAM_CODEC;
        }

        private static AlloySmeltingRecipe fromNetwork(RegistryByteBuf buffer) {
            int ingredientCount = buffer.readVarInt();
            List<Ingredient> inputItems = new ArrayList<>(ingredientCount);
            for (int i = 0; i < ingredientCount; i++) {
                inputItems.add(Ingredient.PACKET_CODEC.decode(buffer));
            }

            int outputCount = buffer.readVarInt();
            List<ItemStack> result = new ArrayList<>(outputCount);
            for (int i = 0; i < outputCount; i++) {
                result.add(ItemStack.PACKET_CODEC.decode(buffer));
            }

            return new AlloySmeltingRecipe(inputItems, result);
        }

        private static void toNetwork(RegistryByteBuf buffer, AlloySmeltingRecipe recipe) {
            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                Ingredient.PACKET_CODEC.encode(buffer, ingredient);
            }

            buffer.writeVarInt(recipe.output.size());
            for (ItemStack itemStack : recipe.output) {
                ItemStack.PACKET_CODEC.encode(buffer, itemStack);
            }

        }
    }
}
