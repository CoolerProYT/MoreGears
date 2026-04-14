package com.coolerpromc.moregears.platform.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public interface ItemLikeRegistryHandler<T> extends RegistryHandler<T>, ItemLike {
    default ItemStack toStack(){
        return asItem().getDefaultInstance();
    }
}