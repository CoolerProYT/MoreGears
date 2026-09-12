package com.coolerpromc.moregears.worldgen;

import com.coolerpromc.moregears.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class MGPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_TITANIUM_ORE_PLACED_KEY = registerKey("nether_titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> END_ENDERITE_ORE_PLACED_KEY = registerKey("end_enderite_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.FEATURE);

        register(context, TIN_ORE_PLACED_KEY, features.getOrThrow(MGConfiguredFeatures.TIN_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64))));
        register(context, RUBY_ORE_PLACED_KEY, features.getOrThrow(MGConfiguredFeatures.RUBY_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64))));
        register(context, NETHER_TITANIUM_ORE_PLACED_KEY, features.getOrThrow(MGConfiguredFeatures.NETHER_TITANIUM_ORE_KEY), MGOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25))));
        register(context, END_ENDERITE_ORE_PLACED_KEY, features.getOrThrow(MGConfiguredFeatures.END_ENDERITE_ORE_KEY), MGOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(128))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Constants.id(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<Feature> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }
}
