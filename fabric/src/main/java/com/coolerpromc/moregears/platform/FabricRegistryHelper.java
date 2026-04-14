package com.coolerpromc.moregears.platform;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.platform.services.IRegistryHelper;
import com.coolerpromc.moregears.platform.util.BlockEntityTypeFactory;
import com.coolerpromc.moregears.platform.util.ItemLikeRegistryHandler;
import com.coolerpromc.moregears.platform.util.MenuFactory;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <T extends Block> ItemLikeRegistryHandler<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties properties) {
        Identifier id = Constants.id(name);
        ResourceKey<Block> key = IRegistryHelper.blockKey(name);
        Holder<T> block = Registry.registerForHolder(BuiltInRegistries.BLOCK, id, func.apply(properties.setId(key)));
        ItemLikeRegistryHandler<BlockItem> item = registerItem(name, p -> new BlockItem(block.value(), p.useBlockDescriptionPrefix()));

        return new ItemLikeRegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<T> holder() {
                return block;
            }

            @Override
            public T get() {
                return block.value();
            }

            @Override
            public Item asItem() {
                return item.get();
            }
        };
    }

    @Override
    public <T extends Item> ItemLikeRegistryHandler<T> registerItem(String name, Function<Item.Properties, T> func) {
        Identifier id = Constants.id(name);
        ResourceKey<Item> key = IRegistryHelper.itemKey(name);
        Holder<T> item = Registry.registerForHolder(BuiltInRegistries.ITEM, id, func.apply(new Item.Properties().setId(key)));

        return new ItemLikeRegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<T> holder() {
                return item;
            }

            @Override
            public T get() {
                return item.value();
            }

            @Override
            public Item asItem() {
                return get();
            }
        };
    }

    @Override
    public <T extends BlockEntity> RegistryHandler<BlockEntityType<T>> registerBlockEntity(String name, BlockEntityTypeFactory<T> factory, Supplier<? extends Block>... blocks) {
        Identifier id = Constants.id(name);
        Holder<BlockEntityType<T>> holder = Registry.registerForHolder(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.create(factory::create, Arrays.stream(blocks).map(Supplier::get).toArray(Block[]::new)).build());

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<BlockEntityType<T>> holder() {
                return holder;
            }

            @Override
            public BlockEntityType<T> get() {
                return holder.value();
            }
        };
    }

    @Override
    public RegistryHandler<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, Function<CreativeModeTab.ItemDisplayParameters, ItemStack[]> func) {
        Identifier id = Constants.id(name);
        Holder<CreativeModeTab> holder = Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, id, FabricCreativeModeTab.builder().icon(icon).title(title).displayItems((parameters, output) -> Arrays.stream(func.apply(parameters)).forEach(output::accept)).build());

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<CreativeModeTab> holder() {
                return holder;
            }

            @Override
            public CreativeModeTab get() {
                return holder.value();
            }
        };
    }

    @Override
    public <T extends AbstractContainerMenu, D> RegistryHandler<MenuType<T>> registerMenu(String name, MenuFactory<T, D> factory, StreamCodec<? super RegistryFriendlyByteBuf, D> data) {
        Identifier id = Constants.id(name);
        Holder<MenuType<T>> holder = Registry.registerForHolder(BuiltInRegistries.MENU, id, new ExtendedMenuType<>(factory::create, data));

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<MenuType<T>> holder() {
                return holder;
            }

            @Override
            public MenuType<T> get() {
                return holder.value();
            }
        };
    }
}
