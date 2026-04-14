package com.coolerpromc.moregears.block;

import com.coolerpromc.moregears.block.custom.AlloySmelterBlock;
import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.ItemLikeRegistryHandler;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MGBlocks {
    public static final ItemLikeRegistryHandler<Block> ALLOY_SMELTER = Services.REGISTRY.registerBlock("alloy_smelter",AlloySmelterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final ItemLikeRegistryHandler<Block> TIN_ORE = Services.REGISTRY.registerBlock("tin_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE));
    public static final ItemLikeRegistryHandler<Block> DEEPSLATE_TIN_ORE = Services.REGISTRY.registerBlock("deepslate_tin_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final ItemLikeRegistryHandler<Block> RUBY_ORE = Services.REGISTRY.registerBlock("ruby_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE));
    public static final ItemLikeRegistryHandler<Block> DEEPSLATE_RUBY_ORE = Services.REGISTRY.registerBlock("deepslate_ruby_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE));
    public static final ItemLikeRegistryHandler<Block> NETHER_TITANIUM_ORE = Services.REGISTRY.registerBlock("nether_titanium_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS));
    public static final ItemLikeRegistryHandler<Block> END_ENDERITE_ORE = Services.REGISTRY.registerBlock("end_enderite_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS));

    public static void load() {
    }
}
