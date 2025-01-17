package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.builder.AlloySmeltingRecipeBuilder;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MGRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public MGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeOutput) {
        alloySmeltingRecipe(recipeOutput, Ingredient.of(Items.COPPER_INGOT), Ingredient.of(MGItems.TIN_INGOT.get()), MGItems.BRONZE_INGOT.get(), 2);
        alloySmeltingRecipe(recipeOutput, Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.COAL), MGItems.STEEL_INGOT.get(), 2);

        oreCooking(recipeOutput, List.of(MGBlocks.TIN_ORE.get(), MGBlocks.DEEPSLATE_TIN_ORE.get(), MGItems.RAW_TIN.get()), RecipeCategory.TOOLS, MGItems.TIN_INGOT.get(), 0.7F, 200, "tin_ingot");
        oreCooking(recipeOutput, List.of(MGBlocks.RUBY_ORE.get(), MGBlocks.DEEPSLATE_RUBY_ORE.get(), MGItems.RAW_RUBY.get()), RecipeCategory.TOOLS, MGItems.RUBY_INGOT.get(), 0.7F, 200, "ruby");
        oreCooking(recipeOutput, List.of(MGBlocks.NETHER_TITANIUM_ORE.get(), MGItems.RAW_TITANIUM.get()), RecipeCategory.TOOLS, MGItems.TITANIUM_INGOT.get(), 1.0F, 200, "titanium_ingot");
        oreCooking(recipeOutput, List.of(MGBlocks.END_ENDERITE_ORE.get(), MGItems.RAW_ENDERITE.get()), RecipeCategory.TOOLS, MGItems.ENDERITE_INGOT.get(), 1.0F, 200, "enderite_ingot");

        armorSetRecipe(recipeOutput, Items.COPPER_INGOT, MGItems.COPPER_HELMET.get(), MGItems.COPPER_CHESTPLATE.get(), MGItems.COPPER_LEGGINGS.get(), MGItems.COPPER_BOOTS.get());
        toolSetRecipe(recipeOutput, Items.COPPER_INGOT, MGItems.COPPER_SWORD.get(), MGItems.COPPER_PICKAXE.get(), MGItems.COPPER_AXE.get(), MGItems.COPPER_SHOVEL.get(), MGItems.COPPER_HOE.get());
        armorSetRecipe(recipeOutput, MGItems.BRONZE_INGOT.get(), MGItems.BRONZE_HELMET.get(), MGItems.BRONZE_CHESTPLATE.get(), MGItems.BRONZE_LEGGINGS.get(), MGItems.BRONZE_BOOTS.get());
        toolSetRecipe(recipeOutput, MGItems.BRONZE_INGOT.get(), MGItems.BRONZE_SWORD.get(), MGItems.BRONZE_PICKAXE.get(), MGItems.BRONZE_AXE.get(), MGItems.BRONZE_SHOVEL.get(), MGItems.BRONZE_HOE.get());
        armorSetRecipe(recipeOutput, MGItems.STEEL_INGOT.get(), MGItems.STEEL_HELMET.get(), MGItems.STEEL_CHESTPLATE.get(), MGItems.STEEL_LEGGINGS.get(), MGItems.STEEL_BOOTS.get());
        toolSetRecipe(recipeOutput, MGItems.STEEL_INGOT.get(), MGItems.STEEL_SWORD.get(), MGItems.STEEL_PICKAXE.get(), MGItems.STEEL_AXE.get(), MGItems.STEEL_SHOVEL.get(), MGItems.STEEL_HOE.get());
        armorSetRecipe(recipeOutput, MGItems.RUBY_INGOT.get(), MGItems.RUBY_HELMET.get(), MGItems.RUBY_CHESTPLATE.get(), MGItems.RUBY_LEGGINGS.get(), MGItems.RUBY_BOOTS.get());
        toolSetRecipe(recipeOutput, MGItems.RUBY_INGOT.get(), MGItems.RUBY_SWORD.get(), MGItems.RUBY_PICKAXE.get(), MGItems.RUBY_AXE.get(), MGItems.RUBY_SHOVEL.get(), MGItems.RUBY_HOE.get());

        titaniumSmithing(recipeOutput, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MGItems.TITANIUM_HELMET.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MGItems.TITANIUM_CHESTPLATE.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MGItems.TITANIUM_LEGGINGS.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MGItems.TITANIUM_BOOTS.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_SWORD, RecipeCategory.TOOLS, MGItems.TITANIUM_SWORD.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, MGItems.TITANIUM_PICKAXE.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_AXE, RecipeCategory.TOOLS, MGItems.TITANIUM_AXE.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, MGItems.TITANIUM_SHOVEL.get());
        titaniumSmithing(recipeOutput, Items.NETHERITE_HOE, RecipeCategory.TOOLS, MGItems.TITANIUM_HOE.get());

        enderiteSmithing(recipeOutput, MGItems.TITANIUM_HELMET.get(), RecipeCategory.COMBAT, MGItems.ENDERITE_HELMET.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_CHESTPLATE.get(), RecipeCategory.COMBAT, MGItems.ENDERITE_CHESTPLATE.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_LEGGINGS.get(), RecipeCategory.COMBAT, MGItems.ENDERITE_LEGGINGS.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_BOOTS.get(), RecipeCategory.COMBAT, MGItems.ENDERITE_BOOTS.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_SWORD.get(), RecipeCategory.TOOLS, MGItems.ENDERITE_SWORD.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_PICKAXE.get(), RecipeCategory.TOOLS, MGItems.ENDERITE_PICKAXE.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_AXE.get(), RecipeCategory.TOOLS, MGItems.ENDERITE_AXE.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_SHOVEL.get(), RecipeCategory.TOOLS, MGItems.ENDERITE_SHOVEL.get());
        enderiteSmithing(recipeOutput, MGItems.TITANIUM_HOE.get(), RecipeCategory.TOOLS, MGItems.ENDERITE_HOE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('X', Items.NETHERITE_INGOT)
                .define('S', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('N', MGItems.TITANIUM_INGOT.get())
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.TITANIUM_INGOT.get()), has(MGItems.TITANIUM_INGOT.get()))
                .save(recipeOutput, getItemName(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get()) + "_from_netherite_smithing_template");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .define('X', Items.NETHERITE_INGOT)
                .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('N', Items.BLACKSTONE)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.TITANIUM_INGOT.get()), has(MGItems.TITANIUM_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('X', MGItems.TITANIUM_INGOT.get())
                .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('N', MGItems.ENDERITE_INGOT.get())
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.ENDERITE_INGOT.get()), has(MGItems.ENDERITE_INGOT.get()))
                .save(recipeOutput, getItemName(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()) + "_from_titanium_smithing_template");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .define('X', MGItems.TITANIUM_INGOT.get())
                .define('S', MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('N', Items.END_STONE)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.ENDERITE_INGOT.get()), has(MGItems.ENDERITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MGBlocks.ALLOY_SMELTER.get())
                .define('X', Items.FURNACE)
                .define('A', Items.DEEPSLATE)
                .define('N', Items.GUNPOWDER)
                .pattern("XAX")
                .pattern("ANA")
                .pattern("AAA")
                .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                .save(recipeOutput);
    }

    protected static void armorSetRecipe(Consumer<FinishedRecipe> recipeOutput, ItemLike material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .define('X', material)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void toolSetRecipe(Consumer<FinishedRecipe> recipeOutput, ItemLike material, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XX")
                .pattern(" s")
                .pattern(" s")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("X")
                .pattern("s")
                .pattern("s")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XX")
                .pattern("Xs")
                .pattern(" s")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XXX")
                .pattern(" s ")
                .pattern(" s ")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, sword)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("X")
                .pattern("X")
                .pattern("s")
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void titaniumSmithing(Consumer<FinishedRecipe> recipeOutput, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(ingredientItem), Ingredient.of(MGItems.TITANIUM_INGOT.get()),
                category,
                resultItem.asItem()
        ).unlocks("has_titanium_ingot", has(MGItems.TITANIUM_INGOT.get())).save(recipeOutput, getItemName(resultItem) + "_smithing");
    }

    protected static void enderiteSmithing(Consumer<FinishedRecipe> recipeOutput, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(ingredientItem), Ingredient.of(MGItems.ENDERITE_INGOT.get()),
                category,
                resultItem.asItem()
        ).unlocks("has_enderite_ingot", has(MGItems.ENDERITE_INGOT.get())).save(recipeOutput, getItemName(resultItem) + "_smithing");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static void alloySmeltingRecipe(Consumer<FinishedRecipe> recipeOutput, Ingredient ingredients1, Ingredient ingredients2, ItemLike result, int outputCount){
        AlloySmeltingRecipeBuilder.alloySmeltingRecipe()
                .addIngredient(ingredients1)
                .addIngredient(ingredients2)
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(ingredients1.getItems()[0].getItem()), has(ingredients1.getItems()[0].getItem()))
                .save(recipeOutput, new ResourceLocation(MoreGears.MODID, "alloy_smelting/" + getItemName(result) + "_from_alloy_smelting"));
    }
}
