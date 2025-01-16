package com.coolerpromc.moregears.block;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.custom.AlloySmelterBlock;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.util.MGColors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MGBlocks {
    public static final Block ALLOY_SMELTER = registerBlock("alloy_smelter", new AlloySmelterBlock(AbstractBlock.Settings.copy(Blocks.STONE).registryKey(createKey("alloy_smelter"))));

    public static final MGOreBlock TIN_ORE = registerBlock("tin_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.IRON_ORE).registryKey(createKey("tin_ore")), MGColors.TIN_COLOR));
    public static final MGOreBlock DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).registryKey(createKey("deepslate_tin_ore")), MGColors.TIN_COLOR));
    public static final MGOreBlock RUBY_ORE = registerBlock("ruby_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE).registryKey(createKey("ruby_ore")), MGColors.RUBY_COLOR));
    public static final MGOreBlock DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE).registryKey(createKey("deepslate_ruby_ore")), MGColors.RUBY_COLOR));
    public static final MGOreBlock NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).registryKey(createKey("nether_titanium_ore")), MGColors.TITANIUM_COLOR));
    public static final MGOreBlock END_ENDERITE_ORE = registerBlock("end_enderite_ore",  new MGOreBlock(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).registryKey(createKey("end_enderite_ore")), MGColors.ENDERITE_COLOR));

    private static <T extends Block> T registerBlock(String name, T block){
        T toReturn = Registry.register(Registries.BLOCK, Identifier.of(MoreGears.MODID, name), block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> BlockItem registerBlockItem(String name, T block){
        return Registry.register(Registries.ITEM, Identifier.of(MoreGears.MODID, name), new BlockItem(block, new Item.Settings().registryKey(createItemKey(name)).useBlockPrefixedTranslationKey()));
    }

    private static RegistryKey<Block> createKey(String name){
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreGears.MODID, name));
    }

    private static RegistryKey<Item> createItemKey(String name){
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name));
    }

    public static void init(){

    }
}
