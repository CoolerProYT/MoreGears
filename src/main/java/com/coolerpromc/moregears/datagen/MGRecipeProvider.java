package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.builder.AlloySmeltingRecipeBuilder;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MGRecipeProvider extends RecipeProvider {
    private final HolderGetter<Item> items;

    public MGRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
        this.items = lookupProvider.lookupOrThrow(Registries.ITEM);
    }

    @Override
    protected void buildRecipes() {
        alloySmeltingRecipe(output, SizedIngredient.of(Items.COPPER_INGOT, 1), SizedIngredient.of(MGItems.TIN_INGOT.get(), 1), MGItems.BRONZE_INGOT, 2);
        alloySmeltingRecipe(output, SizedIngredient.of(Items.IRON_INGOT, 1), SizedIngredient.of(Items.COAL, 1), MGItems.STEEL_INGOT, 2);

        oreCooking(List.of(MGBlocks.TIN_ORE, MGBlocks.DEEPSLATE_TIN_ORE, MGItems.RAW_TIN), RecipeCategory.TOOLS, MGItems.TIN_INGOT, 0.7F, 200, "tin_ingot");
        oreCooking(List.of(MGBlocks.RUBY_ORE, MGBlocks.DEEPSLATE_RUBY_ORE, MGItems.RAW_RUBY), RecipeCategory.TOOLS, MGItems.RUBY_INGOT, 0.7F, 200, "ruby");
        oreCooking(List.of(MGBlocks.NETHER_TITANIUM_ORE, MGItems.RAW_TITANIUM), RecipeCategory.TOOLS, MGItems.TITANIUM_INGOT, 1.0F, 200, "titanium_ingot");
        oreCooking(List.of(MGBlocks.END_ENDERITE_ORE, MGItems.RAW_ENDERITE), RecipeCategory.TOOLS, MGItems.ENDERITE_INGOT, 1.0F, 200, "enderite_ingot");

        armorSetRecipe(output, items, Items.COPPER_INGOT, MGItems.COPPER_HELMET, MGItems.COPPER_CHESTPLATE, MGItems.COPPER_LEGGINGS, MGItems.COPPER_BOOTS);
        toolSetRecipe(output, items, Items.COPPER_INGOT, MGItems.COPPER_SWORD, MGItems.COPPER_PICKAXE, MGItems.COPPER_AXE, MGItems.COPPER_SHOVEL, MGItems.COPPER_HOE);
        armorSetRecipe(output, items, MGItems.BRONZE_INGOT, MGItems.BRONZE_HELMET, MGItems.BRONZE_CHESTPLATE, MGItems.BRONZE_LEGGINGS, MGItems.BRONZE_BOOTS);
        toolSetRecipe(output, items, MGItems.BRONZE_INGOT, MGItems.BRONZE_SWORD, MGItems.BRONZE_PICKAXE, MGItems.BRONZE_AXE, MGItems.BRONZE_SHOVEL, MGItems.BRONZE_HOE);
        armorSetRecipe(output, items, MGItems.STEEL_INGOT, MGItems.STEEL_HELMET, MGItems.STEEL_CHESTPLATE, MGItems.STEEL_LEGGINGS, MGItems.STEEL_BOOTS);
        toolSetRecipe(output, items, MGItems.STEEL_INGOT, MGItems.STEEL_SWORD, MGItems.STEEL_PICKAXE, MGItems.STEEL_AXE, MGItems.STEEL_SHOVEL, MGItems.STEEL_HOE);
        armorSetRecipe(output, items, MGItems.RUBY_INGOT, MGItems.RUBY_HELMET, MGItems.RUBY_CHESTPLATE, MGItems.RUBY_LEGGINGS, MGItems.RUBY_BOOTS);
        toolSetRecipe(output, items, MGItems.RUBY_INGOT, MGItems.RUBY_SWORD, MGItems.RUBY_PICKAXE, MGItems.RUBY_AXE, MGItems.RUBY_SHOVEL, MGItems.RUBY_HOE);

        titaniumSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MGItems.TITANIUM_HELMET);
        titaniumSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MGItems.TITANIUM_CHESTPLATE);
        titaniumSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MGItems.TITANIUM_LEGGINGS);
        titaniumSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MGItems.TITANIUM_BOOTS);
        titaniumSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.TOOLS, MGItems.TITANIUM_SWORD);
        titaniumSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, MGItems.TITANIUM_PICKAXE);
        titaniumSmithing(output, Items.NETHERITE_AXE, RecipeCategory.TOOLS, MGItems.TITANIUM_AXE);
        titaniumSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, MGItems.TITANIUM_SHOVEL);
        titaniumSmithing(output, Items.NETHERITE_HOE, RecipeCategory.TOOLS, MGItems.TITANIUM_HOE);

        enderiteSmithing(output, MGItems.TITANIUM_HELMET, RecipeCategory.COMBAT, MGItems.ENDERITE_HELMET);
        enderiteSmithing(output, MGItems.TITANIUM_CHESTPLATE, RecipeCategory.COMBAT, MGItems.ENDERITE_CHESTPLATE);
        enderiteSmithing(output, MGItems.TITANIUM_LEGGINGS, RecipeCategory.COMBAT, MGItems.ENDERITE_LEGGINGS);
        enderiteSmithing(output, MGItems.TITANIUM_BOOTS, RecipeCategory.COMBAT, MGItems.ENDERITE_BOOTS);
        enderiteSmithing(output, MGItems.TITANIUM_SWORD, RecipeCategory.TOOLS, MGItems.ENDERITE_SWORD);
        enderiteSmithing(output, MGItems.TITANIUM_PICKAXE, RecipeCategory.TOOLS, MGItems.ENDERITE_PICKAXE);
        enderiteSmithing(output, MGItems.TITANIUM_AXE, RecipeCategory.TOOLS, MGItems.ENDERITE_AXE);
        enderiteSmithing(output, MGItems.TITANIUM_SHOVEL, RecipeCategory.TOOLS, MGItems.ENDERITE_SHOVEL);
        enderiteSmithing(output, MGItems.TITANIUM_HOE, RecipeCategory.TOOLS, MGItems.ENDERITE_HOE);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                .define('X', Items.NETHERITE_INGOT)
                .define('S', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('N', MGItems.TITANIUM_INGOT)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT))
                .save(output, getItemName(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE) + "_from_netherite_smithing_template");

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE, 2)
                .define('X', Items.NETHERITE_INGOT)
                .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                .define('N', Items.BLACKSTONE)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('X', MGItems.TITANIUM_INGOT)
                .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                .define('N', MGItems.ENDERITE_INGOT)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.ENDERITE_INGOT), has(MGItems.ENDERITE_INGOT))
                .save(output, getItemName(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE) + "_from_titanium_smithing_template");

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                .define('X', MGItems.TITANIUM_INGOT)
                .define('S', MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('N', Items.END_STONE)
                .pattern("XSX")
                .pattern("XNX")
                .pattern("XXX")
                .unlockedBy(getHasName(MGItems.ENDERITE_INGOT), has(MGItems.ENDERITE_INGOT))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MGBlocks.ALLOY_SMELTER)
                .define('X', Items.FURNACE)
                .define('A', Items.DEEPSLATE)
                .define('N', Items.GUNPOWDER)
                .pattern("XAX")
                .pattern("ANA")
                .pattern("AAA")
                .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                .save(output);
    }

    protected void armorSetRecipe(RecipeOutput output, HolderGetter<Item> items, ItemLike material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots){
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, boots)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, leggings)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, chestplate)
                .define('X', material)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, helmet)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(getHasName(material), has(material))
                .save(output);
    }

    protected void toolSetRecipe(RecipeOutput output, HolderGetter<Item> items, ItemLike material, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe){
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, hoe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XX")
                .pattern(" s")
                .pattern(" s")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, shovel)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("X")
                .pattern("s")
                .pattern("s")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, axe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XX")
                .pattern("Xs")
                .pattern(" s")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, pickaxe)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("XXX")
                .pattern(" s ")
                .pattern(" s ")
                .unlockedBy(getHasName(material), has(material))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, sword)
                .define('X', material)
                .define('s', Items.STICK)
                .pattern("X")
                .pattern("X")
                .pattern("s")
                .unlockedBy(getHasName(material), has(material))
                .save(output);
    }

    protected void titaniumSmithing(RecipeOutput output, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ingredientItem), Ingredient.of(MGItems.TITANIUM_INGOT),
                category,
                resultItem.asItem()
        ).unlocks("has_titanium_ingot", has(MGItems.TITANIUM_INGOT)).save(output, getItemName(resultItem) + "_smithing");
    }

    protected void enderiteSmithing(RecipeOutput output, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ingredientItem), Ingredient.of(MGItems.ENDERITE_INGOT),
                category,
                resultItem.asItem()
        ).unlocks("has_enderite_ingot", has(MGItems.ENDERITE_INGOT)).save(output, getItemName(resultItem) + "_smithing");
    }

    protected void oreCooking(List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
        oreCooking(RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected void alloySmeltingRecipe(RecipeOutput output, SizedIngredient ingredients1, SizedIngredient ingredients2, ItemLike result, int outputCount){
        AlloySmeltingRecipeBuilder.alloySmeltingRecipe()
                .addIngredient(ingredients1)
                .addIngredient(ingredients2)
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(ingredients1.ingredient().getValues().get(0).value()), has(ingredients1.ingredient().getValues().get(0).value()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "alloy_smelting/" + getItemName(result) + "_from_alloy_smelting")));
    }

    public static final class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
            return new MGRecipeProvider(lookupProvider, output);
        }

        @Override
        public String getName() {
            return "ProductiveSlimes recipes";
        }
    }
}
