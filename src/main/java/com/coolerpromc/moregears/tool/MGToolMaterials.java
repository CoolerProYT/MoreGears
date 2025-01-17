package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;
import java.util.function.Supplier;

public class MGToolMaterials {
    public static final Tier COPPER_TIER = registerTier("copper", 1, MGTags.Blocks.NEEDS_COPPER_TOOL, 200, 5f, 1.5f, 20, () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
            List.of(Tiers.STONE), List.of(Tiers.IRON));
    public static final Tier BRONZE_TIER = registerTier("bronze", 2, MGTags.Blocks.NEEDS_BRONZE_TOOL, 700, 7f, 2.5f, 13, () -> Ingredient.of(MGTags.Items.INGOTS_BRONZE),
            List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
    public static final Tier STEEL_TIER = registerTier("steel", 3, MGTags.Blocks.NEEDS_STEEL_TOOL, 1300, 8f, 3f, 12, () -> Ingredient.of(MGTags.Items.INGOTS_STEEL),
            List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    public static final Tier RUBY_TIER = registerTier("ruby", 3, MGTags.Blocks.NEEDS_RUBY_TOOL, 1000, 7.5f, 2.75f, 11, () -> Ingredient.of(MGTags.Items.GEMS_RUBY),
            List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    public static final Tier TITANIUM_TIER = registerTier("titanium", 5, MGTags.Blocks.NEEDS_TITANIUM_TOOL, 3000, 12.0f, 6f, 18, () -> Ingredient.of(MGTags.Items.INGOTS_TITANIUM),
            List.of(Tiers.NETHERITE), List.of());
    public static final Tier ENDERITE_TIER = registerTier("enderite", 6, MGTags.Blocks.NEEDS_ENDERITE_TOOL, Integer.MAX_VALUE, 18.0f, 9f, 24, () -> Ingredient.of(MGTags.Items.INGOTS_ENDERITE),
            List.of(TITANIUM_TIER), List.of());

    private static Tier registerTier(String name, int miningLevel, TagKey<Block> tagKey, int durability, float speed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient, List<Object> after, List<Object> before) {
        return TierSortingRegistry.registerTier(
                new ForgeTier(miningLevel, durability, speed, attackDamage, enchantability, tagKey, repairIngredient),
                new ResourceLocation(MoreGears.MODID, name),
                after,
                before
        );
    }
}
