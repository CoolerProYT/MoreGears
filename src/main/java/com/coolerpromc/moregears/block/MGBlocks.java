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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MGBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreGears.MODID);

    public static final RegistryObject<Block> ALLOY_SMELTER = registerBlock("alloy_smelter", () -> new AlloySmelterBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<MGOreBlock> TIN_ORE = registerBlock("tin_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE), MGColors.TIN_COLOR));
    public static final RegistryObject<MGOreBlock> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE), MGColors.TIN_COLOR));
    public static final RegistryObject<MGOreBlock> RUBY_ORE = registerBlock("ruby_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE), MGColors.RUBY_COLOR));
    public static final RegistryObject<MGOreBlock> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE), MGColors.RUBY_COLOR));
    public static final RegistryObject<MGOreBlock> NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS), MGColors.TITANIUM_COLOR));
    public static final RegistryObject<MGOreBlock> END_ENDERITE_ORE = registerBlock("end_enderite_ore", () -> new MGOreBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS), MGColors.ENDERITE_COLOR));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block){
        return MGItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
