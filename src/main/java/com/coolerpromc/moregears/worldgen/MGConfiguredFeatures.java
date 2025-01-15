package com.coolerpromc.moregears.worldgen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class MGConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TITANIUM_ORE_KEY = registerKey("nether_titanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ENDERITE_ORE_KEY = registerKey("end_enderite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchRuleTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceable = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldTinOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceable, MGBlocks.TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceable, MGBlocks.DEEPSLATE_TIN_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> overworldRubyOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceable, MGBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceable, MGBlocks.DEEPSLATE_RUBY_ORE.getDefaultState())
        );

        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 8));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 4));
        register(context, NETHER_TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherrackReplaceable, MGBlocks.NETHER_TITANIUM_ORE.getDefaultState(), 3));
        register(context, END_ENDERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endstoneReplaceable, MGBlocks.END_ENDERITE_ORE.getDefaultState(), 3));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MoreGears.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
