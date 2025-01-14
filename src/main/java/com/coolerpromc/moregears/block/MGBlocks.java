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

import java.util.function.Supplier;

public class MGBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreGears.MODID);

    public static final DeferredBlock<Block> ALLOY_SMELTER = registerBlock("alloy_smelter", () -> new AlloySmelterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<MGOreBlock> TIN_ORE = registerBlock("tin_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE), MGColors.TIN_COLOR));
    public static final DeferredBlock<MGOreBlock> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE), MGColors.TIN_COLOR));
    public static final DeferredBlock<MGOreBlock> RUBY_ORE = registerBlock("ruby_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE), MGColors.RUBY_COLOR));
    public static final DeferredBlock<MGOreBlock> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE), MGColors.RUBY_COLOR));
    public static final DeferredBlock<MGOreBlock> NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS), MGColors.TITANIUM_COLOR));
    public static final DeferredBlock<MGOreBlock> END_ENDERITE_ORE = registerBlock("end_enderite_ore", () -> new MGOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS), MGColors.ENDERITE_COLOR));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block){
        return MGItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
