package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class MGToolMaterials {
    public static final Tier COPPER_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 200, 5f, 1.5f, 20, () -> Ingredient.of(Tags.Items.INGOTS_COPPER));
    public static final Tier BRONZE_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL, 700, 7f, 2.5f, 13, () -> Ingredient.of(MGTags.Items.INGOTS_BRONZE));
    public static final Tier STEEL_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 1300, 8f, 3f, 12, () -> Ingredient.of(MGTags.Items.INGOTS_STEEL));
    public static final Tier RUBY_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL, 1000, 7.5f, 2.75f, 11, () -> Ingredient.of(MGTags.Items.GEMS_RUBY));
    public static final Tier TITANIUM_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL, 3000, 12.0f, 6f, 18, () -> Ingredient.of(MGTags.Items.INGOTS_TITANIUM));
    public static final Tier ENDERITE_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL, Integer.MAX_VALUE, 18.0f, 9f, 24, () -> Ingredient.of(MGTags.Items.INGOTS_ENDERITE));
}
