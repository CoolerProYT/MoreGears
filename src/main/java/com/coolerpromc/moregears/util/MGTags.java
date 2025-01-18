package com.coolerpromc.moregears.util;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MGTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_0 = fabric("needs_tool_level_0");
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_1 = fabric("needs_tool_level_1");
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_2 = fabric("needs_tool_level_2");
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_3 = fabric("needs_tool_level_3");
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = fabric("needs_tool_level_4");
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_5 = fabric("needs_tool_level_5");

        public static final TagKey<Block> ORES_TIN = commonTag("ores/tin");
        public static final TagKey<Block> ORES_RUBY = commonTag("ores/ruby");
        public static final TagKey<Block> ORES_TITANIUM = commonTag("ores/titanium");
        public static final TagKey<Block> ORES_ENDERITE = commonTag("ores/enderite");

        private static TagKey<Block> commonTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }

        private static TagKey<Block> fabric(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> INGOTS_BRONZE = commonTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_STEEL = commonTag("ingots/steel");
        public static final TagKey<Item> INGOTS_TITANIUM = commonTag("ingots/titanium");
        public static final TagKey<Item> INGOTS_ENDERITE = commonTag("ingots/enderite");
        public static final TagKey<Item> GEMS_RUBY = commonTag("gems/ruby");

        private static TagKey<Item> commonTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
        }

        private static TagKey<Item> modTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name));
        }
    }
}
