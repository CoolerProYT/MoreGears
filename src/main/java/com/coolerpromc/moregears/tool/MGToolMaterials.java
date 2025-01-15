package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MGToolMaterials {
    public static final ToolMaterial COPPER_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 200, 5f, 1.5f, 20, () -> Ingredient.fromTag(MGTags.Items.INGOTS_COPPER));
    public static final ToolMaterial BRONZE_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL, 700, 7f, 2.5f, 13, () -> Ingredient.fromTag(MGTags.Items.INGOTS_BRONZE));
    public static final ToolMaterial STEEL_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 1300, 8f, 3f, 12, () -> Ingredient.fromTag(MGTags.Items.INGOTS_STEEL));
    public static final ToolMaterial RUBY_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL, 1000, 7.5f, 2.75f, 11, () -> Ingredient.fromTag(MGTags.Items.GEMS_RUBY));
    public static final ToolMaterial TITANIUM_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL, 3000, 12.0f, 6f, 18, () -> Ingredient.fromTag(MGTags.Items.INGOTS_TITANIUM));
    public static final ToolMaterial ENDERITE_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL, Integer.MAX_VALUE, 18.0f, 9f, 24, () -> Ingredient.fromTag(MGTags.Items.INGOTS_ENDERITE));
}
