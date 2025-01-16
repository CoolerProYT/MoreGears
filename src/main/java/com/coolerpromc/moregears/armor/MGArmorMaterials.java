package com.coolerpromc.moregears.armor;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class MGArmorMaterials {
    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = register("copper",
            15,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 4);
            }),
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_COPPER,
            0,
            0
    );

    public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = register("bronze",
            22,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 7);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 7);
            }),
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_BRONZE,
            0,
            0
    );

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = register("steel",
            30,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 10);
            }),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_STEEL,
            1.5f,
            0
    );

    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = register("ruby",
            28,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 7);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 9);
            }),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.GEMS_RUBY,
            1f,
            0
    );

    public static final ArmorMaterial TITANIUM_ARMOR_MATERIAL = register("titanium",
            45,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 4);
                map.put(EquipmentType.BODY, 12);
            }),
            18,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_TITANIUM,
            4f,
            0.5f
    );

    public static final ArmorMaterial ENDERITE_ARMOR_MATERIAL = register("enderite",
            Integer.MAX_VALUE,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 5);
                map.put(EquipmentType.LEGGINGS, 8);
                map.put(EquipmentType.CHESTPLATE, 10);
                map.put(EquipmentType.HELMET, 5);
                map.put(EquipmentType.BODY, 13);
            }),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_ENDERITE,
            5f,
            1f
    );

    private static ArmorMaterial register(String name, int durability, EnumMap<EquipmentType, Integer> typeProtection, int enchantmentValue, RegistryEntry<SoundEvent> equipSound, TagKey<Item> ingredient, float toughness, float knockbackResistance){
        Identifier location = Identifier.of(MoreGears.MODID, name);
        RegistryKey<EquipmentAsset> layers = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, location);

        EnumMap<EquipmentType, Integer> typeMap = new EnumMap<>(EquipmentType.class);
        for (EquipmentType type : EquipmentType.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return new ArmorMaterial(durability, typeMap, enchantmentValue, equipSound, toughness, knockbackResistance, ingredient, layers);
    }
}
