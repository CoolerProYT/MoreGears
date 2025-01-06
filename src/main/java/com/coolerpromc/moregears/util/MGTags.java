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
        public static final TagKey<Block> NEED_COPPER_TOOL = modTag("need_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = modTag("incorrect_for_copper_tool");

        private static TagKey<Block> commonTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Block> modTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> commonTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Item> modTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name));
        }
    }
}
