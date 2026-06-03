package com.coolerpromc.moregears.platform.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public interface ItemLikeRegistryHandler<T> extends RegistryHandler<T>, ItemLike {
    default ItemStack toStack(){
        return asItem().getDefaultInstance();
    }
    default ItemStack toStack(int count){
        ItemStack stack = asItem().getDefaultInstance();
        stack.setCount(count);
        return stack;
    }
    default ResourceKey<Item> key(){
        return asItem().builtInRegistryHolder().key();
    }
    default ResourceKey<Block> blockKey(){
        if (get() instanceof Block){
            return (ResourceKey<Block>) holder().unwrapKey().orElse(null);
        }
        return null;
    }
}