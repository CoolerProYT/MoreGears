package com.coolerpromc.moregears.armor;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTags;
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
            12,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
            0,
            0
    );

    public static final Holder<ArmorMaterial> BRONZE_ARMOR_MATERIAL = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 7);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(MGTags.Items.INGOTS_BRONZE),
            0,
            0
    );

    public static final Holder<ArmorMaterial> STEEL_ARMOR_MATERIAL = register("steel", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(MGTags.Items.INGOTS_STEEL),
            1.5f,
            0
    );

    public static final Holder<ArmorMaterial> RUBY_ARMOR_MATERIAL = register("ruby", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 9);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(MGTags.Items.GEMS_RUBY),
            1f,
            0
    );

    public static final Holder<ArmorMaterial> TITANIUM_ARMOR_MATERIAL = register("titanium", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 12);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(MGTags.Items.INGOTS_TITANIUM),
            4f,
            0.5f
    );

    public static final Holder<ArmorMaterial> ENDERITE_ARMOR_MATERIAL = register("enderite", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 13);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(MGTags.Items.INGOTS_ENDERITE),
            5f,
            1f
    );

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> ingredient, float toughness, float knockbackResistance){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, name);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeMap, enchantmentValue, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
