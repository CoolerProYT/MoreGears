package com.coolerpromc.moregears.worldgen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class MGPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_TITANIUM_ORE_PLACED_KEY = registerKey("nether_titanium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ENDERITE_ORE_PLACED_KEY = registerKey("end_enderite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(MGConfiguredFeatures.TIN_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(64))));
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(MGConfiguredFeatures.RUBY_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(64))));
        register(context, NETHER_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(MGConfiguredFeatures.NETHER_TITANIUM_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(25))));
        register(context, END_ENDERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(MGConfiguredFeatures.END_ENDERITE_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(128))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MoreGears.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
