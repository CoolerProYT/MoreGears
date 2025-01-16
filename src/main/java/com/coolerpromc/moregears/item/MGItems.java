package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.custom.*;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import com.coolerpromc.moregears.tool.MGToolMaterials;
import com.coolerpromc.moregears.tool.bronze.BronzeAxe;
import com.coolerpromc.moregears.tool.bronze.BronzeHoe;
import com.coolerpromc.moregears.tool.bronze.BronzePickaxe;
import com.coolerpromc.moregears.tool.bronze.BronzeShovel;
import com.coolerpromc.moregears.tool.steel.*;
import com.coolerpromc.moregears.util.MGColors;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class MGItems {
    public static final MGRawOre RAW_TIN = registerItem("raw_tin", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_tin")), MGColors.TIN_COLOR));
    public static final MGRawOre RAW_RUBY = registerItem("raw_ruby", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_ruby")), MGColors.RUBY_COLOR));
    public static final MGRawOre RAW_TITANIUM = registerItem("raw_titanium", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_titanium")), MGColors.TITANIUM_COLOR));
    public static final MGRawOre RAW_ENDERITE = registerItem("raw_enderite", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_enderite")), MGColors.ENDERITE_COLOR));

    public static final MGIngot TIN_INGOT = registerItem("tin_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("tin_ingot")), MGColors.TIN_COLOR));
    public static final MGIngot BRONZE_INGOT = registerItem("bronze_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("bronze_ingot")), MGColors.BRONZE_COLOR));
    public static final MGIngot STEEL_INGOT = registerItem("steel_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("steel_ingot")), MGColors.STEEL_COLOR));
    public static final MGIngot RUBY_INGOT = registerItem("ruby", new MGIngot(new Item.Settings().registryKey(createItemKey("ruby")), MGColors.RUBY_COLOR));
    public static final MGIngot TITANIUM_INGOT = registerItem("titanium_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("titanium_ingot")), MGColors.TITANIUM_COLOR));
    public static final MGIngot ENDERITE_INGOT = registerItem("enderite_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("enderite_ingot")), MGColors.ENDERITE_COLOR));

    public static final MGArmorItem COPPER_HELMET = registerItem("copper_helmet", new CopperArmor(EquipmentType.HELMET, "copper_helmet"));
    public static final MGArmorItem COPPER_CHESTPLATE = registerItem("copper_chestplate", new CopperArmor(EquipmentType.CHESTPLATE, "copper_chestplate"));
    public static final MGArmorItem COPPER_LEGGINGS = registerItem("copper_leggings", new CopperArmor(EquipmentType.LEGGINGS, "copper_leggings"));
    public static final MGArmorItem COPPER_BOOTS = registerItem("copper_boots", new CopperArmor(EquipmentType.BOOTS, "copper_boots"));

    public static final SwordItem COPPER_SWORD = registerItem("copper_sword", new SwordItem(MGToolMaterials.COPPER_TIER, 3, -2.4F, new Item.Settings().registryKey(createItemKey("copper_sword"))));
    public static final PickaxeItem COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(MGToolMaterials.COPPER_TIER, 1, -2.8F, new Item.Settings().registryKey(createItemKey("copper_pickaxe"))));
    public static final ShovelItem COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(MGToolMaterials.COPPER_TIER, 1.5F, -3.0F, new Item.Settings().registryKey(createItemKey("copper_shovel"))));
    public static final AxeItem COPPER_AXE = registerItem("copper_axe", new AxeItem(MGToolMaterials.COPPER_TIER, 7.0F, -3.2F, new Item.Settings().registryKey(createItemKey("copper_axe"))));
    public static final HoeItem COPPER_HOE = registerItem("copper_hoe", new HoeItem(MGToolMaterials.COPPER_TIER, -1, -1.5F, new Item.Settings().registryKey(createItemKey("copper_hoe"))));

    public static final MGArmorItem BRONZE_HELMET = registerItem("bronze_helmet", new BronzeArmor(EquipmentType.HELMET, "bronze_helmet"));
    public static final MGArmorItem BRONZE_CHESTPLATE = registerItem("bronze_chestplate", new BronzeArmor(EquipmentType.CHESTPLATE, "bronze_chestplate"));
    public static final MGArmorItem BRONZE_LEGGINGS = registerItem("bronze_leggings", new BronzeArmor(EquipmentType.LEGGINGS, "bronze_leggings"));
    public static final MGArmorItem BRONZE_BOOTS = registerItem("bronze_boots", new BronzeArmor(EquipmentType.BOOTS, "bronze_boots"));

    public static final SwordItem BRONZE_SWORD = registerItem("bronze_sword", new SwordItem(MGToolMaterials.BRONZE_TIER, 3, -2.4F, new Item.Settings().registryKey(createItemKey("bronze_sword"))));
    public static final PickaxeItem BRONZE_PICKAXE = registerItem("bronze_pickaxe", new BronzePickaxe(MGToolMaterials.BRONZE_TIER, 1, -2.8F, new Item.Settings().registryKey(createItemKey("bronze_pickaxe"))));
    public static final ShovelItem BRONZE_SHOVEL = registerItem("bronze_shovel", new BronzeShovel(MGToolMaterials.BRONZE_TIER, 1.5F, -3.0F, new Item.Settings().registryKey(createItemKey("bronze_shovel"))));
    public static final AxeItem BRONZE_AXE = registerItem("bronze_axe", new BronzeAxe(MGToolMaterials.BRONZE_TIER, 5.5F, -3.0F, new Item.Settings().registryKey(createItemKey("bronze_axe"))));
    public static final HoeItem BRONZE_HOE = registerItem("bronze_hoe", new BronzeHoe(MGToolMaterials.BRONZE_TIER, -2.5F, -0.5F, new Item.Settings().registryKey(createItemKey("bronze_hoe"))));


    public static final MGArmorItem STEEL_HELMET = registerItem("steel_helmet", new SteelArmor(EquipmentType.HELMET, "steel_helmet"));
    public static final MGArmorItem STEEL_CHESTPLATE = registerItem("steel_chestplate", new SteelArmor(EquipmentType.CHESTPLATE, "steel_chestplate"));
    public static final MGArmorItem STEEL_LEGGINGS = registerItem("steel_leggings", new SteelArmor(EquipmentType.LEGGINGS, "steel_leggings"));
    public static final MGArmorItem STEEL_BOOTS = registerItem("steel_boots", new SteelArmor(EquipmentType.BOOTS, "steel_boots"));

    public static final SwordItem STEEL_SWORD = registerItem("steel_sword", new SteelSword(MGToolMaterials.STEEL_TIER, 3, -1.4F, new Item.Settings().registryKey(createItemKey("steel_sword"))));
    public static final PickaxeItem STEEL_PICKAXE = registerItem("steel_pickaxe", new SteelPickaxe(MGToolMaterials.STEEL_TIER, 1, -1.8F, new Item.Settings().registryKey(createItemKey("steel_pickaxe"))));
    public static final ShovelItem STEEL_SHOVEL = registerItem("steel_shovel", new SteelShovel(MGToolMaterials.STEEL_TIER, 1.5F, -2.0F, new Item.Settings().registryKey(createItemKey("steel_shovel"))));
    public static final AxeItem STEEL_AXE = registerItem("steel_axe", new SteelAxe(MGToolMaterials.STEEL_TIER, 6.0F, -2.0F, new Item.Settings().registryKey(createItemKey("steel_axe"))));
    public static final HoeItem STEEL_HOE = registerItem("steel_hoe", new SteelHoe(MGToolMaterials.STEEL_TIER, -2.0F, 0.0F, new Item.Settings().registryKey(createItemKey("steel_hoe"))));


    public static final MGArmorItem RUBY_HELMET = registerItem("ruby_helmet", new RubyArmor(EquipmentType.HELMET, "ruby_helmet"));
    public static final MGArmorItem RUBY_CHESTPLATE = registerItem("ruby_chestplate", new RubyArmor(EquipmentType.CHESTPLATE, "ruby_chestplate"));
    public static final MGArmorItem RUBY_LEGGINGS = registerItem("ruby_leggings", new RubyArmor(EquipmentType.LEGGINGS, "ruby_leggings"));
    public static final MGArmorItem RUBY_BOOTS = registerItem("ruby_boots", new RubyArmor(EquipmentType.BOOTS, "ruby_boots"));

    public static final SwordItem RUBY_SWORD = registerItem("ruby_sword", new SwordItem(MGToolMaterials.RUBY_TIER, 3, -2.4F, new Item.Settings().registryKey(createItemKey("ruby_sword"))));
    public static final PickaxeItem RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(MGToolMaterials.RUBY_TIER, 1.0F, -2.8F, new Item.Settings().registryKey(createItemKey("ruby_pickaxe"))));
    public static final ShovelItem RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(MGToolMaterials.RUBY_TIER, 1.5F, -3.0F, new Item.Settings().registryKey(createItemKey("ruby_shovel"))));
    public static final AxeItem RUBY_AXE = registerItem("ruby_axe", new AxeItem(MGToolMaterials.RUBY_TIER, 4.0F, -3.2F, new Item.Settings().registryKey(createItemKey("ruby_axe"))));
    public static final HoeItem RUBY_HOE = registerItem("ruby_hoe", new HoeItem(MGToolMaterials.RUBY_TIER, -3.0F, 0.0F, new Item.Settings().registryKey(createItemKey("ruby_hoe"))));


    public static final MGArmorItem TITANIUM_HELMET = registerItem("titanium_helmet", new TitaniumArmor(EquipmentType.HELMET, "titanium_helmet"));
    public static final MGArmorItem TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", new TitaniumArmor(EquipmentType.CHESTPLATE, "titanium_chestplate"));
    public static final MGArmorItem TITANIUM_LEGGINGS = registerItem("titanium_leggings", new TitaniumArmor(EquipmentType.LEGGINGS, "titanium_leggings"));
    public static final MGArmorItem TITANIUM_BOOTS = registerItem("titanium_boots", new TitaniumArmor(EquipmentType.BOOTS, "titanium_boots"));

    public static final SwordItem TITANIUM_SWORD = registerItem("titanium_sword", new SwordItem(MGToolMaterials.TITANIUM_TIER, 5, -1.5F, new Item.Settings().registryKey(createItemKey("titanium_sword"))));
    public static final PickaxeItem TITANIUM_PICKAXE = registerItem("titanium_pickaxe", new PickaxeItem(MGToolMaterials.TITANIUM_TIER, 2, -2.0F, new Item.Settings().registryKey(createItemKey("titanium_pickaxe"))));
    public static final ShovelItem TITANIUM_SHOVEL = registerItem("titanium_shovel", new ShovelItem(MGToolMaterials.TITANIUM_TIER, 2.0F, -2.0F, new Item.Settings().registryKey(createItemKey("titanium_shovel"))));
    public static final AxeItem TITANIUM_AXE = registerItem("titanium_axe", new AxeItem(MGToolMaterials.TITANIUM_TIER, 6.0F, -2.2F, new Item.Settings().registryKey(createItemKey("titanium_axe"))));
    public static final HoeItem TITANIUM_HOE = registerItem("titanium_hoe", new HoeItem(MGToolMaterials.TITANIUM_TIER, -2.0F, 0.0F, new Item.Settings().registryKey(createItemKey("titanium_hoe"))));


    public static final MGArmorItem ENDERITE_HELMET = registerItem("enderite_helmet", new EnderiteArmor(EquipmentType.HELMET, "enderite_helmet"));
    public static final MGArmorItem ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", new EnderiteArmor(EquipmentType.CHESTPLATE, "enderite_chestplate"));
    public static final MGArmorItem ENDERITE_LEGGINGS = registerItem("enderite_leggings", new EnderiteArmor(EquipmentType.LEGGINGS, "enderite_leggings"));
    public static final MGArmorItem ENDERITE_BOOTS = registerItem("enderite_boots", new EnderiteArmor(EquipmentType.BOOTS, "enderite_boots"));

    public static final SwordItem ENDERITE_SWORD = registerItem("enderite_sword", new SwordItem(MGToolMaterials.ENDERITE_TIER, 8, -1.0F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).registryKey(createItemKey("enderite_sword"))));
    public static final PickaxeItem ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new PickaxeItem(MGToolMaterials.ENDERITE_TIER, 4, -1.3F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).registryKey(createItemKey("enderite_pickaxe"))));
    public static final ShovelItem ENDERITE_SHOVEL = registerItem("enderite_shovel", new ShovelItem(MGToolMaterials.ENDERITE_TIER, 3.5F, -1.8F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).registryKey(createItemKey("enderite_shovel"))));
    public static final AxeItem ENDERITE_AXE = registerItem("enderite_axe", new AxeItem(MGToolMaterials.ENDERITE_TIER, 9, -1.5F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).registryKey(createItemKey("enderite_axe"))));
    public static final HoeItem ENDERITE_HOE = registerItem("enderite_hoe", new HoeItem(MGToolMaterials.ENDERITE_TIER, -1.0F, 0.0F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).registryKey(createItemKey("enderite_hoe"))));

    public static final SmithingTemplateItem TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template", new SmithingTemplateItem(
            Text.literal("Netherite Equipment").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Titanium Ingot").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Titanium Upgrade").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.literal("Add Titanium Ingot"),
            List.of(
                    Identifier.ofVanilla("item/empty_armor_slot_helmet"),
                    Identifier.ofVanilla("item/empty_armor_slot_chestplate"),
                    Identifier.ofVanilla("item/empty_armor_slot_leggings"),
                    Identifier.ofVanilla("item/empty_armor_slot_boots"),
                    Identifier.ofVanilla("item/empty_slot_hoe"),
                    Identifier.ofVanilla("item/empty_slot_axe"),
                    Identifier.ofVanilla("item/empty_slot_sword"),
                    Identifier.ofVanilla("item/empty_slot_shovel"),
                    Identifier.ofVanilla("item/empty_slot_pickaxe")
            ),
            List.of(Identifier.ofVanilla("item/empty_slot_ingot")),
            new Item.Settings().registryKey(createItemKey("titanium_upgrade_smithing_template"))
    ));

    public static final SmithingTemplateItem ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", new SmithingTemplateItem(
            Text.literal("Titanium Equipment").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Enderite Ingot").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Enderite Upgrade").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.literal("Add Enderite Ingot"),
            List.of(
                    Identifier.ofVanilla("item/empty_armor_slot_helmet"),
                    Identifier.ofVanilla("item/empty_armor_slot_chestplate"),
                    Identifier.ofVanilla("item/empty_armor_slot_leggings"),
                    Identifier.ofVanilla("item/empty_armor_slot_boots"),
                    Identifier.ofVanilla("item/empty_slot_hoe"),
                    Identifier.ofVanilla("item/empty_slot_axe"),
                    Identifier.ofVanilla("item/empty_slot_sword"),
                    Identifier.ofVanilla("item/empty_slot_shovel"),
                    Identifier.ofVanilla("item/empty_slot_pickaxe")
            ),
            List.of(Identifier.ofVanilla("item/empty_slot_ingot")),
            new Item.Settings().registryKey(createItemKey("enderite_upgrade_smithing_template")).useBlockPrefixedTranslationKey()
    ));

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreGears.MODID, name), item);
    }

    private static RegistryKey<Item> createItemKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name));
    }

    public static void init() {

    }
}
