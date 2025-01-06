package com.coolerpromc.moregears.armor;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class MGArmorMaterials {
    public static final Holder<ArmorMaterial> COPPER_ARMOR_MATERIAL = register("copper", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
            0,
            0
    );

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> ingredient, float toughness, float knockbackResistance){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name);
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(
                        ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "copper")
                )
        );

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeMap, enchantmentValue, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
