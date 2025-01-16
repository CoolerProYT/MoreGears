package com.coolerpromc.moregears.armor;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.common.Tags;

import java.util.EnumMap;

public class MGArmorMaterials {
    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = register("copper",
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 4);
            }),
            12,
            SoundEvents.ARMOR_EQUIP_IRON,
            Tags.Items.INGOTS_COPPER,
            0,
            0
    );

    public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = register("bronze",
            22,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 7);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_IRON,
            MGTags.Items.INGOTS_BRONZE,
            0,
            0
    );

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = register("steel",
            30,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 10);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            MGTags.Items.INGOTS_STEEL,
            1.5f,
            0
    );

    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = register("ruby",
            28,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 9);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            MGTags.Items.GEMS_RUBY,
            1f,
            0
    );

    public static final ArmorMaterial TITANIUM_ARMOR_MATERIAL = register("titanium",
            45,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 4);
                map.put(ArmorType.LEGGINGS, 7);
                map.put(ArmorType.CHESTPLATE, 9);
                map.put(ArmorType.HELMET, 4);
                map.put(ArmorType.BODY, 12);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            MGTags.Items.INGOTS_TITANIUM,
            4f,
            0.5f
    );

    public static final ArmorMaterial ENDERITE_ARMOR_MATERIAL = register("enderite",
            Integer.MAX_VALUE,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 5);
                map.put(ArmorType.LEGGINGS, 8);
                map.put(ArmorType.CHESTPLATE, 10);
                map.put(ArmorType.HELMET, 5);
                map.put(ArmorType.BODY, 13);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            MGTags.Items.INGOTS_ENDERITE,
            5f,
            1f
    );

    private static ArmorMaterial register(String name, int durability, EnumMap<ArmorType, Integer> typeProtection, int enchantmentValue, Holder<SoundEvent> equipSound, TagKey<Item> ingredient, float toughness, float knockbackResistance){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name);
        ResourceKey<EquipmentAsset> layers = ResourceKey.create(EquipmentAssets.ROOT_ID, location);

        EnumMap<ArmorType, Integer> typeMap = new EnumMap<>(ArmorType.class);
        for (ArmorType type : ArmorType.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return new ArmorMaterial(durability, typeMap, enchantmentValue, equipSound, toughness, knockbackResistance, ingredient, layers);
    }
}
