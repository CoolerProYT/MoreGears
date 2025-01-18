package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MGToolMaterials {
    public static final ToolMaterial COPPER_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 200, 5f, 1.5f, 20, ConventionalItemTags.COPPER_INGOTS);
    public static final ToolMaterial BRONZE_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL, 700, 7f, 2.5f, 13, MGTags.Items.INGOTS_BRONZE);
    public static final ToolMaterial STEEL_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 1300, 8f, 3f, 12, MGTags.Items.INGOTS_STEEL);
    public static final ToolMaterial RUBY_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL, 1000, 7.5f, 2.75f, 11, MGTags.Items.GEMS_RUBY);
    public static final ToolMaterial TITANIUM_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL, 3000, 12.0f, 6f, 18, MGTags.Items.INGOTS_TITANIUM);
    public static final ToolMaterial ENDERITE_TIER = new ToolMaterial(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL, Integer.MAX_VALUE, 18.0f, 9f, 24, MGTags.Items.INGOTS_ENDERITE);
}
