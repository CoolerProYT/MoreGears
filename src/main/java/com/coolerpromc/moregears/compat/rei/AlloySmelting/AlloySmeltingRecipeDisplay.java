package com.coolerpromc.moregears.compat.rei.AlloySmelting;

import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AlloySmeltingRecipeDisplay extends BasicDisplay {
    public static final DisplaySerializer<AlloySmeltingRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    EntryIngredient.codec().listOf().fieldOf("ingredients").forGetter(AlloySmeltingRecipeDisplay::getInputEntries),
                    EntryIngredient.codec().listOf().fieldOf("output").forGetter(AlloySmeltingRecipeDisplay::getOutputEntries)
            ).apply(instance, AlloySmeltingRecipeDisplay::new)),
            StreamCodec.composite(
                    EntryIngredient.streamCodec().apply(ByteBufCodecs.list()),
                    AlloySmeltingRecipeDisplay::getInputEntries,
                    EntryIngredient.streamCodec().apply(ByteBufCodecs.list()),
                    AlloySmeltingRecipeDisplay::getOutputEntries,
                    AlloySmeltingRecipeDisplay::new
            )
    );

    public AlloySmeltingRecipeDisplay(RecipeHolder<AlloySmeltingRecipe> recipe) {
        super(
                List.of(
                        EntryIngredients.ofIngredient(Ingredient.of(Items.COAL)),
                        EntryIngredients.ofIngredient(recipe.value().inputItems().get(0).ingredient()),
                        EntryIngredients.ofIngredient(recipe.value().inputItems().get(1).ingredient())
                ),
                List.of(EntryIngredients.of(recipe.value().output().get(0)))
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
