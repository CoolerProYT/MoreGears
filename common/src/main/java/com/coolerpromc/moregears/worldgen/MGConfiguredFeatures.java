package com.coolerpromc.moregears.worldgen;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class MGConfiguredFeatures {
    public static final ResourceKey<Feature> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<Feature> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<Feature> NETHER_TITANIUM_ORE_KEY = registerKey("nether_titanium_ore");
    public static final ResourceKey<Feature> END_ENDERITE_ORE_KEY = registerKey("end_enderite_ore");

    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceable = new BlockMatchTest(Blocks.END_STONE);

        List<BlockReplacement> overworldTinOres = List.of(
                BlockReplacement.replace(stoneReplaceable, MGBlocks.TIN_ORE.get().defaultBlockState()),
                BlockReplacement.replace(deepslateReplaceable, MGBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );

        List<BlockReplacement> overworldRubyOres = List.of(
                BlockReplacement.replace(stoneReplaceable, MGBlocks.RUBY_ORE.get().defaultBlockState()),
                BlockReplacement.replace(deepslateReplaceable, MGBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );

        context.register(TIN_ORE_KEY, new OreFeature(overworldTinOres, 8));
        context.register(RUBY_ORE_KEY, new OreFeature(overworldRubyOres, 4));
        context.register(NETHER_TITANIUM_ORE_KEY, new OreFeature(netherrackReplaceable, MGBlocks.NETHER_TITANIUM_ORE.get().defaultBlockState(), 4));
        context.register(END_ENDERITE_ORE_KEY, new OreFeature(endstoneReplaceable, MGBlocks.END_ENDERITE_ORE.get().defaultBlockState(), 3));
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Constants.id(name));
    }
}
