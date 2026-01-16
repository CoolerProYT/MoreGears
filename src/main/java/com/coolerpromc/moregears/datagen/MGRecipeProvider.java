package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.builder.AlloySmeltingRecipeBuilder;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.custom.SizedIngredient;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MGRecipeProvider extends FabricRecipeProvider {
    public MGRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeOutput) {
        return new RecipeGenerator(wrapperLookup, recipeOutput) {
            private RegistryEntryLookup<Item> registryLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

            @Override
            public void generate() {
                alloySmeltingRecipe(recipeOutput, SizedIngredient.of(Items.COPPER_INGOT,1), SizedIngredient.of(MGItems.TIN_INGOT, 1), MGItems.BRONZE_INGOT, 2);
                alloySmeltingRecipe(recipeOutput, SizedIngredient.of(Items.IRON_INGOT,1), SizedIngredient.of(Items.COAL, 1), MGItems.STEEL_INGOT, 2);

                oreCooking(recipeOutput, List.of(MGBlocks.TIN_ORE, MGBlocks.DEEPSLATE_TIN_ORE, MGItems.RAW_TIN), RecipeCategory.TOOLS, MGItems.TIN_INGOT, 0.7F, 200, "tin_ingot");
                oreCooking(recipeOutput, List.of(MGBlocks.RUBY_ORE, MGBlocks.DEEPSLATE_RUBY_ORE, MGItems.RAW_RUBY), RecipeCategory.TOOLS, MGItems.RUBY_INGOT, 0.7F, 200, "ruby");
                oreCooking(recipeOutput, List.of(MGBlocks.NETHER_TITANIUM_ORE, MGItems.RAW_TITANIUM), RecipeCategory.TOOLS, MGItems.TITANIUM_INGOT, 1.0F, 200, "titanium_ingot");
                oreCooking(recipeOutput, List.of(MGBlocks.END_ENDERITE_ORE, MGItems.RAW_ENDERITE), RecipeCategory.TOOLS, MGItems.ENDERITE_INGOT, 1.0F, 200, "enderite_ingot");

                armorSetRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_HELMET, MGItems.BRONZE_CHESTPLATE, MGItems.BRONZE_LEGGINGS, MGItems.BRONZE_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_SWORD, MGItems.BRONZE_PICKAXE, MGItems.BRONZE_AXE, MGItems.BRONZE_SHOVEL, MGItems.BRONZE_HOE);
                armorSetRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_HELMET, MGItems.STEEL_CHESTPLATE, MGItems.STEEL_LEGGINGS, MGItems.STEEL_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_SWORD, MGItems.STEEL_PICKAXE, MGItems.STEEL_AXE, MGItems.STEEL_SHOVEL, MGItems.STEEL_HOE);
                armorSetRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_HELMET, MGItems.RUBY_CHESTPLATE, MGItems.RUBY_LEGGINGS, MGItems.RUBY_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_SWORD, MGItems.RUBY_PICKAXE, MGItems.RUBY_AXE, MGItems.RUBY_SHOVEL, MGItems.RUBY_HOE);

                titaniumSmithing(recipeOutput, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MGItems.TITANIUM_HELMET);
                titaniumSmithing(recipeOutput, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MGItems.TITANIUM_CHESTPLATE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MGItems.TITANIUM_LEGGINGS);
                titaniumSmithing(recipeOutput, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MGItems.TITANIUM_BOOTS);
                titaniumSmithing(recipeOutput, Items.NETHERITE_SWORD, RecipeCategory.TOOLS, MGItems.TITANIUM_SWORD);
                titaniumSmithing(recipeOutput, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, MGItems.TITANIUM_PICKAXE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_AXE, RecipeCategory.TOOLS, MGItems.TITANIUM_AXE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, MGItems.TITANIUM_SHOVEL);
                titaniumSmithing(recipeOutput, Items.NETHERITE_HOE, RecipeCategory.TOOLS, MGItems.TITANIUM_HOE);

                enderiteSmithing(recipeOutput, MGItems.TITANIUM_HELMET, RecipeCategory.COMBAT, MGItems.ENDERITE_HELMET);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_CHESTPLATE, RecipeCategory.COMBAT, MGItems.ENDERITE_CHESTPLATE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_LEGGINGS, RecipeCategory.COMBAT, MGItems.ENDERITE_LEGGINGS);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_BOOTS, RecipeCategory.COMBAT, MGItems.ENDERITE_BOOTS);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_SWORD, RecipeCategory.TOOLS, MGItems.ENDERITE_SWORD);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_PICKAXE, RecipeCategory.TOOLS, MGItems.ENDERITE_PICKAXE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_AXE, RecipeCategory.TOOLS, MGItems.ENDERITE_AXE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_SHOVEL, RecipeCategory.TOOLS, MGItems.ENDERITE_SHOVEL);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_HOE, RecipeCategory.TOOLS, MGItems.ENDERITE_HOE);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_INGOT)
                        .input('N', MGItems.TITANIUM_NUGGET)
                        .pattern("NNN")
                        .pattern("NNN")
                        .pattern("NNN")
                        .criterion(hasItem(MGItems.TITANIUM_NUGGET), conditionsFromItem(MGItems.TITANIUM_NUGGET))
                        .offerTo(recipeOutput, getItemPath(MGItems.TITANIUM_INGOT) + "_from_titanium_nugget");

                ShapelessRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_NUGGET, 9)
                        .input(MGItems.TITANIUM_INGOT)
                        .criterion(hasItem(MGItems.TITANIUM_INGOT), conditionsFromItem(MGItems.TITANIUM_INGOT))
                        .offerTo(recipeOutput, getItemPath(MGItems.TITANIUM_NUGGET) + "_from_titanium_ingot");

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .input('X', Items.NETHERITE_SCRAP)
                        .input('S', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                        .input('N', MGItems.TITANIUM_INGOT)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .criterion(hasItem(MGItems.TITANIUM_INGOT), conditionsFromItem(MGItems.TITANIUM_INGOT))
                        .offerTo(recipeOutput, getItemPath(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE) + "_from_netherite_smithing_template");

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE, 2)
                        .input('X', Items.NETHERITE_SCRAP)
                        .input('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .input('N', Items.BLACKSTONE)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .criterion(hasItem(MGItems.TITANIUM_INGOT), conditionsFromItem(MGItems.TITANIUM_INGOT))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                        .input('X', MGItems.TITANIUM_NUGGET)
                        .input('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .input('N', MGItems.ENDERITE_INGOT)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .criterion(hasItem(MGItems.ENDERITE_INGOT), conditionsFromItem(MGItems.ENDERITE_INGOT))
                        .offerTo(recipeOutput, getItemPath(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE) + "_from_titanium_smithing_template");

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .input('X', MGItems.TITANIUM_NUGGET)
                        .input('S', MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                        .input('N', Items.END_STONE)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .criterion(hasItem(MGItems.ENDERITE_INGOT), conditionsFromItem(MGItems.ENDERITE_INGOT))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.MISC, MGBlocks.ALLOY_SMELTER)
                        .input('X', Items.FURNACE)
                        .input('A', Items.DEEPSLATE)
                        .input('N', Items.GUNPOWDER)
                        .pattern("XAX")
                        .pattern("ANA")
                        .pattern("AAA")
                        .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
                        .offerTo(recipeOutput);

                arrowRecipe(recipeOutput, Items.COPPER_INGOT, MGItems.COPPER_ARROW);
                arrowRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_ARROW);
                arrowRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_ARROW);
                arrowRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_ARROW);
                arrowRecipe(recipeOutput, MGItems.TITANIUM_INGOT, MGItems.TITANIUM_ARROW);
                arrowRecipe(recipeOutput, MGItems.ENDERITE_INGOT, MGItems.ENDERITE_ARROW);

                bowRecipe(recipeOutput, Items.COPPER_INGOT, MGItems.COPPER_BOW);
                bowRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_BOW);
                bowRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_BOW);
                bowRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_BOW);
                bowRecipe(recipeOutput, MGItems.TITANIUM_INGOT, MGItems.TITANIUM_BOW);
                bowRecipe(recipeOutput, MGItems.ENDERITE_INGOT, MGItems.ENDERITE_BOW);
            }

            private void armorSetRecipe(RecipeExporter recipeOutput, ItemConvertible material, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots){
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, boots)
                        .input('X', material)
                        .pattern("X X")
                        .pattern("X X")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, leggings)
                        .input('X', material)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, chestplate)
                        .input('X', material)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, helmet)
                        .input('X', material)
                        .pattern("XXX")
                        .pattern("X X")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);
            }

            private void toolSetRecipe(RecipeExporter recipeOutput, ItemConvertible material, ItemConvertible sword, ItemConvertible pickaxe, ItemConvertible axe, ItemConvertible shovel, ItemConvertible hoe){
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.TOOLS, hoe)
                        .input('X', material)
                        .input('s', Items.STICK)
                        .pattern("XX")
                        .pattern(" s")
                        .pattern(" s")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.TOOLS, shovel)
                        .input('X', material)
                        .input('s', Items.STICK)
                        .pattern("X")
                        .pattern("s")
                        .pattern("s")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.TOOLS, axe)
                        .input('X', material)
                        .input('s', Items.STICK)
                        .pattern("XX")
                        .pattern("Xs")
                        .pattern(" s")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.TOOLS, pickaxe)
                        .input('X', material)
                        .input('s', Items.STICK)
                        .pattern("XXX")
                        .pattern(" s ")
                        .pattern(" s ")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);

                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.TOOLS, sword)
                        .input('X', material)
                        .input('s', Items.STICK)
                        .pattern("X")
                        .pattern("X")
                        .pattern("s")
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(recipeOutput);
            }

            private void titaniumSmithing(RecipeExporter recipeOutput, ItemConvertible ingredientItem, RecipeCategory category, ItemConvertible resultItem) {
                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ingredientItem), Ingredient.ofItems(MGItems.TITANIUM_INGOT),
                        category,
                        resultItem.asItem()
                ).criterion(hasItem(MGItems.TITANIUM_INGOT), conditionsFromItem(MGItems.TITANIUM_INGOT)).offerTo(recipeOutput, getItemPath(resultItem) + "_smithing");
            }

            private void enderiteSmithing(RecipeExporter recipeOutput, ItemConvertible ingredientItem, RecipeCategory category, ItemConvertible resultItem) {
                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ingredientItem), Ingredient.ofItems(MGItems.ENDERITE_INGOT),
                        category,
                        resultItem.asItem()
                ).criterion(hasItem(MGItems.ENDERITE_INGOT), conditionsFromItem(MGItems.ENDERITE_INGOT)).offerTo(recipeOutput, getItemPath(resultItem) + "_smithing");
            }

            private void oreCooking(RecipeExporter recipeOutput, List<ItemConvertible> ingredients, RecipeCategory category, ItemConvertible result, float experience, int cookingTime, String group) {
                offerSmelting(ingredients, category, result, experience, cookingTime, group);
                offerBlasting(ingredients, category, result, experience, cookingTime, group);
            }

            private void alloySmeltingRecipe(RecipeExporter recipeOutput, SizedIngredient ingredients1, SizedIngredient ingredients2, ItemConvertible result, int outputCount){
                AlloySmeltingRecipeBuilder.alloySmeltingRecipe()
                        .addIngredient(ingredients1)
                        .addIngredient(ingredients2)
                        .addOutput(new ItemStack(result, outputCount))
                        .criterion(hasItem(ingredients1.ingredient().getMatchingItems().toList().get(0).value()), conditionsFromItem(ingredients1.ingredient().getMatchingItems().toList().get(0).value()))
                        .offerTo(recipeOutput, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MoreGears.MODID, "alloy_smelting/" + getItemPath(result) + "_from_alloy_smelting")));
            }

            private void arrowRecipe(RecipeExporter output, ItemConvertible ingot, ItemConvertible outputItem) {
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, outputItem, 6)
                        .input('#', Items.STICK)
                        .input('X', ingot)
                        .input('Y', Items.FEATHER)
                        .pattern("X")
                        .pattern("#")
                        .pattern("Y")
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(output);
            }

            private void bowRecipe(RecipeExporter output, ItemConvertible ingot, ItemConvertible outputItem){
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.COMBAT, outputItem)
                        .input('#', ingot)
                        .input('X', Items.STRING)
                        .pattern(" #X")
                        .pattern("# X")
                        .pattern(" #X")
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(output);
            }
        };
    }

    @Override
    public String getName() {
        return null;
    }
}
