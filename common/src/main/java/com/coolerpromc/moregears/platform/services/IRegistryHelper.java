package com.coolerpromc.moregears.platform.services;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.platform.util.BlockEntityTypeFactory;
import com.coolerpromc.moregears.platform.util.ItemLikeRegistryHandler;
import com.coolerpromc.moregears.platform.util.MenuFactory;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistryHelper {
    default <T extends Block> ItemLikeRegistryHandler<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func){
        return registerBlock(name, func, BlockBehaviour.Properties.of());
    }
    <T extends Block> ItemLikeRegistryHandler<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties properties);
    <T extends Item> ItemLikeRegistryHandler<T> registerItem(String name, Function<Item.Properties, T> func);
    <T extends BlockEntity> RegistryHandler<BlockEntityType<T>> registerBlockEntity(String name, BlockEntityTypeFactory<T> factory, Supplier<? extends Block>... blocks);
    RegistryHandler<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, Function<CreativeModeTab.ItemDisplayParameters, ItemStack[]> func);
    <T extends AbstractContainerMenu, D> RegistryHandler<MenuType<T>> registerMenu(String name, MenuFactory<T, D> factory, StreamCodec<? super RegistryFriendlyByteBuf, D> data);

    static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, Constants.id(name));
    }
    static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM, Constants.id(name));
    }
}