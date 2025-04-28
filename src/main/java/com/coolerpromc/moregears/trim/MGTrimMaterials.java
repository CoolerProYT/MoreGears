package com.coolerpromc.moregears.trim;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class MGTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> TIN = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "tin"));
    public static final RegistryKey<ArmorTrimMaterial> BRONZE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "bronze"));
    public static final RegistryKey<ArmorTrimMaterial> STEEL = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "steel"));
    public static final RegistryKey<ArmorTrimMaterial> RUBY = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "ruby"));
    public static final RegistryKey<ArmorTrimMaterial> TITANIUM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "titanium"));
    public static final RegistryKey<ArmorTrimMaterial> ENDERITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "enderite"));

    public static final ArmorTrimAssets TIN_ASSET_GROUP = ArmorTrimAssets.of("tin");
    public static final ArmorTrimAssets BRONZE_ASSET_GROUP = ArmorTrimAssets.of("bronze");
    public static final ArmorTrimAssets STEEL_ASSET_GROUP = ArmorTrimAssets.of("steel");
    public static final ArmorTrimAssets RUBY_ASSET_GROUP = ArmorTrimAssets.of("ruby");
    public static final ArmorTrimAssets TITANIUM_ASSET_GROUP = ArmorTrimAssets.of("titanium");
    public static final ArmorTrimAssets ENDERITE_ASSET_GROUP = ArmorTrimAssets.of("enderite");

    public static final List<ArmorTrimAssets> TRIM_MATERIALS = List.of(
            TIN_ASSET_GROUP,
            BRONZE_ASSET_GROUP,
            STEEL_ASSET_GROUP,
            RUBY_ASSET_GROUP,
            TITANIUM_ASSET_GROUP,
            ENDERITE_ASSET_GROUP
    );

    public static void bootstrap(Registerable<ArmorTrimMaterial> context) {
        register(context, TIN, Style.EMPTY.withColor(TextColor.parse("#9dc6e0").getOrThrow()), TIN_ASSET_GROUP);
        register(context, BRONZE, Style.EMPTY.withColor(TextColor.parse("#f1c232").getOrThrow()), BRONZE_ASSET_GROUP);
        register(context, STEEL, Style.EMPTY.withColor(TextColor.parse("#6e6b6b").getOrThrow()), STEEL_ASSET_GROUP);
        register(context, RUBY, Style.EMPTY.withColor(TextColor.parse("#E0115F").getOrThrow()), RUBY_ASSET_GROUP);
        register(context, TITANIUM, Style.EMPTY.withColor(TextColor.parse("#9e6590").getOrThrow()), TITANIUM_ASSET_GROUP);
        register(context, ENDERITE, Style.EMPTY.withColor(TextColor.parse("#5D3391").getOrThrow()), ENDERITE_ASSET_GROUP);
    }

    private static void register(Registerable<ArmorTrimMaterial> context, RegistryKey<ArmorTrimMaterial> trimKey, Style style, ArmorTrimAssets armorTrimAssets) {
        Text text = Text.translatable(Util.createTranslationKey("trim_material", trimKey.getValue())).setStyle(style);
        context.register(trimKey, new ArmorTrimMaterial(armorTrimAssets, text));
    }
}