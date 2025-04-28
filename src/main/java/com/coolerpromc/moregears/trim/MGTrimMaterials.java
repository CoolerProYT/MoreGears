package com.coolerpromc.moregears.trim;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.item.Item;
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
import java.util.Map;

public class MGTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> TIN = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "tin"));
    public static final RegistryKey<ArmorTrimMaterial> BRONZE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "bronze"));
    public static final RegistryKey<ArmorTrimMaterial> STEEL = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "steel"));
    public static final RegistryKey<ArmorTrimMaterial> RUBY = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "ruby"));
    public static final RegistryKey<ArmorTrimMaterial> TITANIUM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "titanium"));
    public static final RegistryKey<ArmorTrimMaterial> ENDERITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(MoreGears.MODID, "enderite"));

    public static final List<String> TRIM_MATERIALS = List.of(
            TIN.getValue().getPath(),
            BRONZE.getValue().getPath(),
            STEEL.getValue().getPath(),
            RUBY.getValue().getPath(),
            TITANIUM.getValue().getPath(),
            ENDERITE.getValue().getPath()
    );

    public static void bootstrap(Registerable<ArmorTrimMaterial> context) {
        register(context, TIN, MGItems.TIN_INGOT, Style.EMPTY.withColor(TextColor.parse("#9dc6e0").getOrThrow()));
        register(context, BRONZE, MGItems.BRONZE_INGOT, Style.EMPTY.withColor(TextColor.parse("#f1c232").getOrThrow()));
        register(context, STEEL, MGItems.STEEL_INGOT, Style.EMPTY.withColor(TextColor.parse("#6e6b6b").getOrThrow()));
        register(context, RUBY, MGItems.RUBY_INGOT, Style.EMPTY.withColor(TextColor.parse("#E0115F").getOrThrow()));
        register(context, TITANIUM, MGItems.TITANIUM_INGOT, Style.EMPTY.withColor(TextColor.parse("#9e6590").getOrThrow()));
        register(context, ENDERITE, MGItems.ENDERITE_INGOT, Style.EMPTY.withColor(TextColor.parse("#5D3391").getOrThrow()));
    }

    private static void register(Registerable<ArmorTrimMaterial> context, RegistryKey<ArmorTrimMaterial> trimKey, Item item, Style style) {
        ArmorTrimMaterial trimmaterial = ArmorTrimMaterial.of(trimKey.getValue().getPath(), item, Text.translatable(Util.createTranslationKey("trim_material", trimKey.getValue())).setStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}