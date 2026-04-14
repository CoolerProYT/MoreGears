package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.builder.AlloySmeltingRecipeBuilder;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.custom.SizedIngredient;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MGRecipeProvider extends FabricRecipeProvider {
    public MGRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeOutput) {
        return new RecipeProvider(wrapperLookup, recipeOutput) {
            private HolderGetter<Item> registryLookup = wrapperLookup.lookupOrThrow(Registries.ITEM);

            @Override
            public void buildRecipes() {
                alloySmeltingRecipe(recipeOutput, SizedIngredient.of(Items.COPPER_INGOT,1), SizedIngredient.of(MGItems.TIN_INGOT, 1), MGItems.BRONZE_INGOT, 2);
                alloySmeltingRecipe(recipeOutput, SizedIngredient.of(Items.IRON_INGOT,1), SizedIngredient.of(Items.COAL, 1), MGItems.STEEL_INGOT, 2);

                oreCooking(recipeOutput, List.of(MGBlocks.TIN_ORE, MGBlocks.DEEPSLATE_TIN_ORE, MGItems.RAW_TIN), RecipeCategory.TOOLS, MGItems.TIN_INGOT, 0.7F, 200, "tin_ingot");
                oreCooking(recipeOutput, List.of(MGBlocks.RUBY_ORE, MGBlocks.DEEPSLATE_RUBY_ORE, MGItems.RAW_RUBY), RecipeCategory.TOOLS, MGItems.RUBY_INGOT, 0.7F, 200, "ruby");
                oreCooking(recipeOutput, List.of(MGBlocks.NETHER_TITANIUM_ORE, MGItems.RAW_TITANIUM), RecipeCategory.TOOLS, MGItems.TITANIUM_INGOT, 1.0F, 200, "titanium_ingot");
                oreCooking(recipeOutput, List.of(MGBlocks.END_ENDERITE_ORE, MGItems.RAW_ENDERITE), RecipeCategory.TOOLS, MGItems.ENDERITE_INGOT, 1.0F, 200, "enderite_ingot");

                armorSetRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_HELMET, MGItems.BRONZE_CHESTPLATE, MGItems.BRONZE_LEGGINGS, MGItems.BRONZE_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.BRONZE_INGOT, MGItems.BRONZE_SWORD, MGItems.BRONZE_PICKAXE, MGItems.BRONZE_AXE, MGItems.BRONZE_SHOVEL, MGItems.BRONZE_HOE, MGItems.BRONZE_SPEAR);
                armorSetRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_HELMET, MGItems.STEEL_CHESTPLATE, MGItems.STEEL_LEGGINGS, MGItems.STEEL_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.STEEL_INGOT, MGItems.STEEL_SWORD, MGItems.STEEL_PICKAXE, MGItems.STEEL_AXE, MGItems.STEEL_SHOVEL, MGItems.STEEL_HOE, MGItems.STEEL_SPEAR);
                armorSetRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_HELMET, MGItems.RUBY_CHESTPLATE, MGItems.RUBY_LEGGINGS, MGItems.RUBY_BOOTS);
                toolSetRecipe(recipeOutput, MGItems.RUBY_INGOT, MGItems.RUBY_SWORD, MGItems.RUBY_PICKAXE, MGItems.RUBY_AXE, MGItems.RUBY_SHOVEL, MGItems.RUBY_HOE, MGItems.RUBY_SPEAR);

                titaniumSmithing(recipeOutput, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MGItems.TITANIUM_HELMET);
                titaniumSmithing(recipeOutput, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MGItems.TITANIUM_CHESTPLATE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MGItems.TITANIUM_LEGGINGS);
                titaniumSmithing(recipeOutput, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MGItems.TITANIUM_BOOTS);
                titaniumSmithing(recipeOutput, Items.NETHERITE_SWORD, RecipeCategory.TOOLS, MGItems.TITANIUM_SWORD);
                titaniumSmithing(recipeOutput, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, MGItems.TITANIUM_PICKAXE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_AXE, RecipeCategory.TOOLS, MGItems.TITANIUM_AXE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, MGItems.TITANIUM_SHOVEL);
                titaniumSmithing(recipeOutput, Items.NETHERITE_HOE, RecipeCategory.TOOLS, MGItems.TITANIUM_HOE);
                titaniumSmithing(recipeOutput, Items.NETHERITE_SPEAR, RecipeCategory.COMBAT, MGItems.TITANIUM_SPEAR);
                titaniumSmithing(recipeOutput, Items.MACE, RecipeCategory.COMBAT, MGItems.TITANIUM_MACE);

                enderiteSmithing(recipeOutput, MGItems.TITANIUM_HELMET, RecipeCategory.COMBAT, MGItems.ENDERITE_HELMET);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_CHESTPLATE, RecipeCategory.COMBAT, MGItems.ENDERITE_CHESTPLATE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_LEGGINGS, RecipeCategory.COMBAT, MGItems.ENDERITE_LEGGINGS);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_BOOTS, RecipeCategory.COMBAT, MGItems.ENDERITE_BOOTS);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_SWORD, RecipeCategory.TOOLS, MGItems.ENDERITE_SWORD);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_PICKAXE, RecipeCategory.TOOLS, MGItems.ENDERITE_PICKAXE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_AXE, RecipeCategory.TOOLS, MGItems.ENDERITE_AXE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_SHOVEL, RecipeCategory.TOOLS, MGItems.ENDERITE_SHOVEL);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_HOE, RecipeCategory.TOOLS, MGItems.ENDERITE_HOE);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_SPEAR, RecipeCategory.COMBAT, MGItems.ENDERITE_SPEAR);
                enderiteSmithing(recipeOutput, MGItems.TITANIUM_MACE, RecipeCategory.COMBAT, MGItems.ENDERITE_MACE);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_INGOT)
                        .define('N', MGItems.TITANIUM_NUGGET)
                        .pattern("NNN")
                        .pattern("NNN")
                        .pattern("NNN")
                        .unlockedBy(getHasName(MGItems.TITANIUM_NUGGET), has(MGItems.TITANIUM_NUGGET))
                        .save(recipeOutput, getItemName(MGItems.TITANIUM_INGOT) + "_from_titanium_nugget");

                ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_NUGGET, 9)
                        .requires(MGItems.TITANIUM_INGOT)
                        .unlockedBy(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT))
                        .save(recipeOutput, getItemName(MGItems.TITANIUM_NUGGET) + "_from_titanium_ingot");

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .define('X', Items.NETHERITE_SCRAP)
                        .define('S', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                        .define('N', MGItems.TITANIUM_INGOT)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .unlockedBy(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT))
                        .save(recipeOutput, getItemName(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE) + "_from_netherite_smithing_template");

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE, 2)
                        .define('X', Items.NETHERITE_SCRAP)
                        .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .define('N', Items.BLACKSTONE)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .unlockedBy(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                        .define('X', MGItems.TITANIUM_NUGGET)
                        .define('S', MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE)
                        .define('N', MGItems.ENDERITE_INGOT)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .unlockedBy(getHasName(MGItems.ENDERITE_INGOT), has(MGItems.ENDERITE_INGOT))
                        .save(recipeOutput, getItemName(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE) + "_from_titanium_smithing_template");

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .define('X', MGItems.TITANIUM_NUGGET)
                        .define('S', MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE)
                        .define('N', Items.END_STONE)
                        .pattern("XSX")
                        .pattern("XNX")
                        .pattern("XXX")
                        .unlockedBy(getHasName(MGItems.ENDERITE_INGOT), has(MGItems.ENDERITE_INGOT))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.MISC, MGBlocks.ALLOY_SMELTER)
                        .define('X', Items.FURNACE)
                        .define('A', Items.DEEPSLATE)
                        .define('N', Items.GUNPOWDER)
                        .pattern("XAX")
                        .pattern("ANA")
                        .pattern("AAA")
                        .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                        .save(recipeOutput);

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

            private void armorSetRecipe(RecipeOutput recipeOutput, ItemLike material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots){
                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, boots)
                        .define('X', material)
                        .pattern("X X")
                        .pattern("X X")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, leggings)
                        .define('X', material)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, chestplate)
                        .define('X', material)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, helmet)
                        .define('X', material)
                        .pattern("XXX")
                        .pattern("X X")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);
            }

            private void toolSetRecipe(RecipeOutput recipeOutput, ItemLike material, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe, ItemLike spear){
                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.TOOLS, hoe)
                        .define('X', material)
                        .define('s', Items.STICK)
                        .pattern("XX")
                        .pattern(" s")
                        .pattern(" s")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.TOOLS, shovel)
                        .define('X', material)
                        .define('s', Items.STICK)
                        .pattern("X")
                        .pattern("s")
                        .pattern("s")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.TOOLS, axe)
                        .define('X', material)
                        .define('s', Items.STICK)
                        .pattern("XX")
                        .pattern("Xs")
                        .pattern(" s")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.TOOLS, pickaxe)
                        .define('X', material)
                        .define('s', Items.STICK)
                        .pattern("XXX")
                        .pattern(" s ")
                        .pattern(" s ")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.TOOLS, sword)
                        .define('X', material)
                        .define('s', Items.STICK)
                        .pattern("X")
                        .pattern("X")
                        .pattern("s")
                        .unlockedBy(getHasName(material), has(material))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, spear)
                        .define('#', Items.STICK)
                        .define('X', material)
                        .pattern("  X")
                        .pattern(" # ")
                        .pattern("#  ")
                        .unlockedBy(getHasName(material), has(material))
                        .save(this.output);
            }

            private void titaniumSmithing(RecipeOutput recipeOutput, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
                SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ingredientItem), Ingredient.of(MGItems.TITANIUM_INGOT),
                        category,
                        resultItem.asItem()
                ).unlocks(getHasName(MGItems.TITANIUM_INGOT), has(MGItems.TITANIUM_INGOT)).save(recipeOutput, getItemName(resultItem) + "_smithing");
            }

            private void enderiteSmithing(RecipeOutput recipeOutput, ItemLike ingredientItem, RecipeCategory category, ItemLike resultItem) {
                SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ingredientItem), Ingredient.of(MGItems.ENDERITE_INGOT),
                        category,
                        resultItem.asItem()
                ).unlocks(getHasName(MGItems.ENDERITE_INGOT), has(MGItems.ENDERITE_INGOT)).save(recipeOutput, getItemName(resultItem) + "_smithing");
            }

            private void oreCooking(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
                oreSmelting(ingredients, category, CookingBookCategory.MISC, result, experience, cookingTime, group);
                oreBlasting(ingredients, category, CookingBookCategory.MISC, result, experience, cookingTime, group);
            }

            private void alloySmeltingRecipe(RecipeOutput recipeOutput, SizedIngredient ingredients1, SizedIngredient ingredients2, ItemLike result, int outputCount){
                AlloySmeltingRecipeBuilder.alloySmeltingRecipe()
                        .addIngredient(ingredients1)
                        .addIngredient(ingredients2)
                        .addOutput(new ItemStackTemplate(result.asItem(), outputCount))
                        .unlockedBy(getHasName(ingredients1.ingredient().items().toList().get(0).value()), has(ingredients1.ingredient().items().toList().get(0).value()))
                        .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MoreGears.MODID, "alloy_smelting/" + getItemName(result) + "_from_alloy_smelting")));
            }

            private void arrowRecipe(RecipeOutput output, ItemLike ingot, ItemLike outputItem) {
                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, outputItem, 6)
                        .define('#', Items.STICK)
                        .define('X', ingot)
                        .define('Y', Items.FEATHER)
                        .pattern("X")
                        .pattern("#")
                        .pattern("Y")
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(output);
            }

            private void bowRecipe(RecipeOutput output, ItemLike ingot, ItemLike outputItem){
                ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.COMBAT, outputItem)
                        .define('#', ingot)
                        .define('X', Items.STRING)
                        .pattern(" #X")
                        .pattern("# X")
                        .pattern(" #X")
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return null;
    }
}
