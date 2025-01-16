package com.coolerpromc.moregears.block;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.custom.AlloySmelterBlock;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class MGBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreGears.MODID);

    public static final DeferredBlock<Block> ALLOY_SMELTER = registerBlock("alloy_smelter", AlloySmelterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final DeferredBlock<MGOreBlock> TIN_ORE = registerBlock("tin_ore", properties -> new MGOreBlock(properties, MGColors.TIN_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE));
    public static final DeferredBlock<MGOreBlock> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", properties -> new MGOreBlock(properties, MGColors.TIN_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final DeferredBlock<MGOreBlock> RUBY_ORE = registerBlock("ruby_ore", properties -> new MGOreBlock(properties, MGColors.RUBY_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE));
    public static final DeferredBlock<MGOreBlock> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", properties -> new MGOreBlock(properties, MGColors.RUBY_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE));
    public static final DeferredBlock<MGOreBlock> NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore", properties -> new MGOreBlock(properties, MGColors.TITANIUM_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS));
    public static final DeferredBlock<MGOreBlock> END_ENDERITE_ORE = registerBlock("end_enderite_ore", properties -> new MGOreBlock(properties, MGColors.ENDERITE_COLOR), BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends T> block, BlockBehaviour.Properties properties){
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, block, properties);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block){
        return MGItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
