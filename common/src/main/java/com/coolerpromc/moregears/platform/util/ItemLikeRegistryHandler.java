package com.coolerpromc.moregears.platform.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

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
}