
package com.coolerpromc.moregears.trim;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.List;
import java.util.Map;

public class MGTrimMaterials {
    public static final ResourceKey<TrimMaterial> TIN = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "tin"));
    public static final ResourceKey<TrimMaterial> BRONZE = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "bronze"));
    public static final ResourceKey<TrimMaterial> STEEL = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "steel"));
    public static final ResourceKey<TrimMaterial> RUBY = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "ruby"));
    public static final ResourceKey<TrimMaterial> TITANIUM = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "titanium"));
    public static final ResourceKey<TrimMaterial> ENDERITE = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "enderite"));

    public static final List<String> TRIM_MATERIALS = List.of(
            TIN.location().getPath(),
            BRONZE.location().getPath(),
            STEEL.location().getPath(),
            RUBY.location().getPath(),
            TITANIUM.location().getPath(),
            ENDERITE.location().getPath()
    );

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, TIN, MGItems.TIN_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#9dc6e0").getOrThrow()));
        register(context, BRONZE, MGItems.BRONZE_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#f1c232").getOrThrow()));
        register(context, STEEL, MGItems.STEEL_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#6e6b6b").getOrThrow()));
        register(context, RUBY, MGItems.RUBY_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#E0115F").getOrThrow()));
        register(context, TITANIUM, MGItems.TITANIUM_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#9e6590").getOrThrow()));
        register(context, ENDERITE, MGItems.ENDERITE_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#5D3391").getOrThrow()));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item, Style style) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}