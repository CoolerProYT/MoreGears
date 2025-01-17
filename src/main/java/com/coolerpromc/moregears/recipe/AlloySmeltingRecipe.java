package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.MoreGears;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlloySmeltingRecipe implements Recipe<SimpleInventory>{
    private final List<Ingredient> inputItems;
    private final ItemStack output;
    private final Identifier id;

    public AlloySmeltingRecipe(List<Ingredient> inputItems, ItemStack output, Identifier id) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleInventory input, World world) {
        List<ItemStack> inputItems = List.of(input.getStack(0), input.getStack(1));

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
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output.isEmpty() ? ItemStack.EMPTY : output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.isEmpty() ? ItemStack.EMPTY : output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
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

    public static class Type implements RecipeType<AlloySmeltingRecipe> {
        public static final AlloySmeltingRecipe.Type INSTANCE = new AlloySmeltingRecipe.Type();
        public static final Identifier ID = Identifier.of(MoreGears.MODID, "alloy_smelting");
    }

    public static class Serializer implements RecipeSerializer<AlloySmeltingRecipe>{
        public static final AlloySmeltingRecipe.Serializer INSTANCE = new AlloySmeltingRecipe.Serializer();
        public static final String ID = "alloy_smelting";

        @Override
        public AlloySmeltingRecipe read(Identifier id, JsonObject jsonObject) {
            JsonArray ingredients = JsonHelper.getArray(jsonObject, "ingredients");
            DefaultedList<Ingredient> inputItems = DefaultedList.ofSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                inputItems.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "output"));

            return new AlloySmeltingRecipe(inputItems, output, id);
        }

        @Override
        public AlloySmeltingRecipe read(Identifier id, PacketByteBuf buffer) {
            DefaultedList<Ingredient> inputItems = DefaultedList.ofSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputItems.size(); i++) {
                inputItems.set(i, Ingredient.fromPacket(buffer));
            }

            ItemStack output = buffer.readItemStack();

            return new AlloySmeltingRecipe(inputItems, output, id);
        }

        @Override
        public void write(PacketByteBuf buffer, AlloySmeltingRecipe recipe) {
            buffer.writeInt(recipe.inputItems.size());

            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.write(buffer);
            }

            buffer.writeItemStack(recipe.getOutput(null));
        }
    }
}
