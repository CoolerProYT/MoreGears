package com.coolerpromc.moregears.worldgen;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class MGOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, SquarePlacementModifier.of(), pHeightRange, BiomePlacementModifier.of());
    }
    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacementModifier.of(pCount), pHeightRange);
    }
    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilterPlacementModifier.of(pChance), pHeightRange);
    }
}
