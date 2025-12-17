package com.coolerpromc.moregears.trim;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.util.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.List;

public class MGTrimMaterials {
    public static final ResourceKey<TrimMaterial> TIN = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "tin"));
    public static final ResourceKey<TrimMaterial> BRONZE = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "bronze"));
    public static final ResourceKey<TrimMaterial> STEEL = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "steel"));
    public static final ResourceKey<TrimMaterial> RUBY = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "ruby"));
    public static final ResourceKey<TrimMaterial> TITANIUM = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "titanium"));
    public static final ResourceKey<TrimMaterial> ENDERITE = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MoreGears.MODID, "enderite"));

    public static final MaterialAssetGroup TIN_ASSET_GROUP = MaterialAssetGroup.create("tin");
    public static final MaterialAssetGroup BRONZE_ASSET_GROUP = MaterialAssetGroup.create("bronze");
    public static final MaterialAssetGroup STEEL_ASSET_GROUP = MaterialAssetGroup.create("steel");
    public static final MaterialAssetGroup RUBY_ASSET_GROUP = MaterialAssetGroup.create("ruby");
    public static final MaterialAssetGroup TITANIUM_ASSET_GROUP = MaterialAssetGroup.create("titanium");
    public static final MaterialAssetGroup ENDERITE_ASSET_GROUP = MaterialAssetGroup.create("enderite");

    public static final List<MaterialAssetGroup> MATERIAL_ASSET_GROUPS = List.of(
            TIN_ASSET_GROUP,
            BRONZE_ASSET_GROUP,
            STEEL_ASSET_GROUP,
            RUBY_ASSET_GROUP,
            TITANIUM_ASSET_GROUP,
            ENDERITE_ASSET_GROUP
    );

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, TIN, Style.EMPTY.withColor(TextColor.parseColor("#9dc6e0").getOrThrow()), TIN_ASSET_GROUP);
        register(context, BRONZE, Style.EMPTY.withColor(TextColor.parseColor("#f1c232").getOrThrow()), BRONZE_ASSET_GROUP);
        register(context, STEEL, Style.EMPTY.withColor(TextColor.parseColor("#6e6b6b").getOrThrow()), STEEL_ASSET_GROUP);
        register(context, RUBY, Style.EMPTY.withColor(TextColor.parseColor("#E0115F").getOrThrow()), RUBY_ASSET_GROUP);
        register(context, TITANIUM, Style.EMPTY.withColor(TextColor.parseColor("#9e6590").getOrThrow()), TITANIUM_ASSET_GROUP);
        register(context, ENDERITE, Style.EMPTY.withColor(TextColor.parseColor("#5D3391").getOrThrow()), ENDERITE_ASSET_GROUP);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Style style, MaterialAssetGroup materialAssetGroup) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", trimKey.identifier())).withStyle(style);
        context.register(trimKey, new TrimMaterial(materialAssetGroup, component));
    }
}