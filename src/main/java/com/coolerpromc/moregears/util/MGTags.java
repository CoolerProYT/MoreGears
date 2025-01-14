package com.coolerpromc.moregears.util;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MGTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_COPPER_TOOL = modTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = modTag("incorrect_for_copper_tool");

        public static final TagKey<Block> NEEDS_BRONZE_TOOL = modTag("needs_bronze_tool");
        public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = modTag("incorrect_for_bronze_tool");

        public static final TagKey<Block> NEEDS_STEEL_TOOL = modTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = modTag("incorrect_for_steel_tool");

        public static final TagKey<Block> NEEDS_RUBY_TOOL = modTag("needs_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = modTag("incorrect_for_ruby_tool");

        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = modTag("needs_titanium_tool");
        public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL = modTag("incorrect_for_titanium_tool");

        public static final TagKey<Block> NEEDS_ENDERITE_TOOL = modTag("needs_enderite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = modTag("incorrect_for_enderite_tool");

        public static final TagKey<Block> ORES_TIN = commonTag("ores/tin");
        public static final TagKey<Block> ORES_RUBY = commonTag("ores/ruby");
        public static final TagKey<Block> ORES_TITANIUM = commonTag("ores/titanium");
        public static final TagKey<Block> ORES_ENDERITE = commonTag("ores/enderite");

        private static TagKey<Block> commonTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Block> modTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> INGOTS_BRONZE = commonTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_STEEL = commonTag("ingots/steel");
        public static final TagKey<Item> INGOTS_TITANIUM = commonTag("ingots/titanium");
        public static final TagKey<Item> INGOTS_ENDERITE = commonTag("ingots/enderite");
        public static final TagKey<Item> GEMS_RUBY = commonTag("gems/ruby");

        private static TagKey<Item> commonTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Item> modTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name));
        }
    }
}
