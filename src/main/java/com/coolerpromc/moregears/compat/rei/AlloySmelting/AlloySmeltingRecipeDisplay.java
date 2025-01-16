package com.coolerpromc.moregears.compat.rei.AlloySmelting;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.Items;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AlloySmeltingRecipeDisplay extends BasicDisplay {
    public static final DisplaySerializer<AlloySmeltingRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    EntryIngredient.codec().listOf().fieldOf("ingredients").forGetter(AlloySmeltingRecipeDisplay::getInputEntries),
                    EntryIngredient.codec().listOf().fieldOf("output").forGetter(AlloySmeltingRecipeDisplay::getOutputEntries)
            ).apply(instance, AlloySmeltingRecipeDisplay::new)),
            PacketCodec.tuple(
                    EntryIngredient.streamCodec().collect(PacketCodecs.toList()),
                    AlloySmeltingRecipeDisplay::getInputEntries,
                    EntryIngredient.streamCodec().collect(PacketCodecs.toList()),
                    AlloySmeltingRecipeDisplay::getOutputEntries,
                    AlloySmeltingRecipeDisplay::new
            )
    );

    public AlloySmeltingRecipeDisplay(RecipeEntry<AlloySmeltingRecipe> recipe) {
        super(
                List.of(
                        EntryIngredients.ofIngredient(Ingredient.ofItems(Items.COAL)),
                        EntryIngredients.ofIngredient(recipe.value().getInputItems().get(0)),
                        EntryIngredients.ofIngredient(recipe.value().getInputItems().get(1))
                ),
                List.of(EntryIngredients.of(recipe.value().getOutput().get(0)))
        );
    }

    public AlloySmeltingRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloySmeltingCategory.ALLOY_SMELTING;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
}