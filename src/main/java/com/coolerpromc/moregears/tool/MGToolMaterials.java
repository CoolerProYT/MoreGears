package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class MGToolMaterials {
    public static final Tier COPPER_TIER = new SimpleTier(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 200, 5f, 1.5f, 20, () -> Ingredient.of(Tags.Items.INGOTS_COPPER));
}
