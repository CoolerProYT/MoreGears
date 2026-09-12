package com.coolerpromc.moregears.trim;

import com.coolerpromc.moregears.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class MGTrimMaterials {
    public static final ResourceKey<TrimMaterial> TIN = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("tin"));
    public static final ResourceKey<TrimMaterial> BRONZE = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("bronze"));
    public static final ResourceKey<TrimMaterial> STEEL = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("steel"));
    public static final ResourceKey<TrimMaterial> RUBY = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("ruby"));
    public static final ResourceKey<TrimMaterial> TITANIUM = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("titanium"));
    public static final ResourceKey<TrimMaterial> ENDERITE = ResourceKey.create(Registries.TRIM_MATERIAL, Constants.id("enderite"));

    public static final Identifier TIN_PALETTE = Constants.id("trim/tin");
    public static final Identifier BRONZE_PALETTE = Constants.id("trim/bronze");
    public static final Identifier STEEL_PALETTE = Constants.id("trim/steel");
    public static final Identifier RUBY_PALETTE = Constants.id("trim/ruby");
    public static final Identifier TITANIUM_PALETTE = Constants.id("trim/titanium");
    public static final Identifier ENDERITE_PALETTE = Constants.id("trim/enderite");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, TIN, Style.EMPTY.withColor(TextColor.parseColor("#9dc6e0").getOrThrow()), TIN_PALETTE);
        register(context, BRONZE, Style.EMPTY.withColor(TextColor.parseColor("#f1c232").getOrThrow()), BRONZE_PALETTE);
        register(context, STEEL, Style.EMPTY.withColor(TextColor.parseColor("#6e6b6b").getOrThrow()), STEEL_PALETTE);
        register(context, RUBY, Style.EMPTY.withColor(TextColor.parseColor("#E0115F").getOrThrow()), RUBY_PALETTE);
        register(context, TITANIUM, Style.EMPTY.withColor(TextColor.parseColor("#9e6590").getOrThrow()), TITANIUM_PALETTE);
        register(context, ENDERITE, Style.EMPTY.withColor(TextColor.parseColor("#5D3391").getOrThrow()), ENDERITE_PALETTE);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Style style, Identifier paletteId) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", trimKey.identifier())).withStyle(style);
        context.register(trimKey, new TrimMaterial(paletteId, component));
    }
}
