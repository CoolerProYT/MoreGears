package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class MGItems {
    public static final MGRawOre RAW_TIN = registerItem("raw_tin",  new MGRawOre(new Item.Settings(), MGColors.TIN_COLOR));
    public static final MGRawOre RAW_RUBY = registerItem("raw_ruby",  new MGRawOre(new Item.Settings(), MGColors.RUBY_COLOR));
    public static final MGRawOre RAW_TITANIUM = registerItem("raw_titanium",  new MGRawOre(new Item.Settings(), MGColors.TITANIUM_COLOR));
    public static final MGRawOre RAW_ENDERITE = registerItem("raw_enderite",  new MGRawOre(new Item.Settings(), MGColors.ENDERITE_COLOR));

    public static final MGIngot TIN_INGOT = registerItem("tin_ingot",  new MGIngot(new Item.Settings(), MGColors.TIN_COLOR));
    public static final MGIngot BRONZE_INGOT = registerItem("bronze_ingot",  new MGIngot(new Item.Settings(), MGColors.BRONZE_COLOR));
    public static final MGIngot STEEL_INGOT = registerItem("steel_ingot",  new MGIngot(new Item.Settings(), MGColors.STEEL_COLOR));
    public static final MGIngot RUBY_INGOT = registerItem("ruby",  new MGIngot(new Item.Settings(), MGColors.RUBY_COLOR));
    public static final MGIngot TITANIUM_INGOT = registerItem("titanium_ingot",  new MGIngot(new Item.Settings(), MGColors.TITANIUM_COLOR));
    public static final MGIngot ENDERITE_INGOT = registerItem("enderite_ingot",  new MGIngot(new Item.Settings(), MGColors.ENDERITE_COLOR));

    public static final ArmorItem COPPER_HELMET = registerItem("copper_helmet",  new CopperArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem COPPER_CHESTPLATE = registerItem("copper_chestplate",  new CopperArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem COPPER_LEGGINGS = registerItem("copper_leggings",  new CopperArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem COPPER_BOOTS = registerItem("copper_boots",  new CopperArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem COPPER_SWORD = registerItem("copper_sword",  new SwordItem(MGToolMaterials.COPPER_TIER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.COPPER_TIER, 3, -2.4F))));
    public static final PickaxeItem COPPER_PICKAXE = registerItem("copper_pickaxe",  new PickaxeItem(MGToolMaterials.COPPER_TIER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.COPPER_TIER, 1, -2.8f))));
    public static final ShovelItem COPPER_SHOVEL = registerItem("copper_shovel",  new ShovelItem(MGToolMaterials.COPPER_TIER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.COPPER_TIER, 1.5f, -3f))));
    public static final AxeItem COPPER_AXE = registerItem("copper_axe",  new AxeItem(MGToolMaterials.COPPER_TIER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.COPPER_TIER, 7, -3.2f))));
    public static final HoeItem COPPER_HOE = registerItem("copper_hoe",  new HoeItem(MGToolMaterials.COPPER_TIER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.COPPER_TIER, -1f, -1.5f))));

    public static final ArmorItem BRONZE_HELMET = registerItem("bronze_helmet",  new BronzeArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem BRONZE_CHESTPLATE = registerItem("bronze_chestplate",  new BronzeArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem BRONZE_LEGGINGS = registerItem("bronze_leggings",  new BronzeArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem BRONZE_BOOTS = registerItem("bronze_boots",  new BronzeArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem BRONZE_SWORD = registerItem("bronze_sword",  new SwordItem(MGToolMaterials.BRONZE_TIER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.BRONZE_TIER, 3, -2.4F))));
    public static final PickaxeItem BRONZE_PICKAXE = registerItem("bronze_pickaxe",  new BronzePickaxe(MGToolMaterials.BRONZE_TIER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.BRONZE_TIER, 1, -2.8f))));
    public static final ShovelItem BRONZE_SHOVEL = registerItem("bronze_shovel",  new BronzeShovel(MGToolMaterials.BRONZE_TIER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.BRONZE_TIER, 1.5f, -3f))));
    public static final AxeItem BRONZE_AXE = registerItem("bronze_axe",  new BronzeAxe(MGToolMaterials.BRONZE_TIER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.BRONZE_TIER, 5.5f, -3.0f))));
    public static final HoeItem BRONZE_HOE = registerItem("bronze_hoe",  new BronzeHoe(MGToolMaterials.BRONZE_TIER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.BRONZE_TIER, -2.5f, -0.5f))));

    public static final ArmorItem STEEL_HELMET = registerItem("steel_helmet",  new SteelArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem STEEL_CHESTPLATE = registerItem("steel_chestplate",  new SteelArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem STEEL_LEGGINGS = registerItem("steel_leggings",  new SteelArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem STEEL_BOOTS = registerItem("steel_boots",  new SteelArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem STEEL_SWORD = registerItem("steel_sword",  new SteelSword(MGToolMaterials.STEEL_TIER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.STEEL_TIER, 3, -1.4F))));
    public static final PickaxeItem STEEL_PICKAXE = registerItem("steel_pickaxe",  new SteelPickaxe(MGToolMaterials.STEEL_TIER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.STEEL_TIER, 1, -1.8f))));
    public static final ShovelItem STEEL_SHOVEL = registerItem("steel_shovel",  new SteelShovel(MGToolMaterials.STEEL_TIER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.STEEL_TIER, 1.5f, -2f))));
    public static final AxeItem STEEL_AXE = registerItem("steel_axe",  new SteelAxe(MGToolMaterials.STEEL_TIER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.STEEL_TIER, 6, -2f))));
    public static final HoeItem STEEL_HOE = registerItem("steel_hoe",  new SteelHoe(MGToolMaterials.STEEL_TIER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.STEEL_TIER, -2f, 0.0f))));

    public static final ArmorItem RUBY_HELMET = registerItem("ruby_helmet",  new RubyArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem RUBY_CHESTPLATE = registerItem("ruby_chestplate",  new RubyArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem RUBY_LEGGINGS = registerItem("ruby_leggings",  new RubyArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem RUBY_BOOTS = registerItem("ruby_boots",  new RubyArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem RUBY_SWORD = registerItem("ruby_sword",  new SwordItem(MGToolMaterials.RUBY_TIER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.RUBY_TIER, 3, -2.4F))));
    public static final PickaxeItem RUBY_PICKAXE = registerItem("ruby_pickaxe",  new PickaxeItem(MGToolMaterials.RUBY_TIER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.RUBY_TIER, 1f, -2.8f))));
    public static final ShovelItem RUBY_SHOVEL = registerItem("ruby_shovel",  new ShovelItem(MGToolMaterials.RUBY_TIER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.RUBY_TIER, 1.5f, -3f))));
    public static final AxeItem RUBY_AXE = registerItem("ruby_axe",  new AxeItem(MGToolMaterials.RUBY_TIER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.RUBY_TIER, 4, -3.2f))));
    public static final HoeItem RUBY_HOE = registerItem("ruby_hoe",  new HoeItem(MGToolMaterials.RUBY_TIER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.RUBY_TIER, -3f, 0f))));

    public static final ArmorItem TITANIUM_HELMET = registerItem("titanium_helmet",  new TitaniumArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem TITANIUM_CHESTPLATE = registerItem("titanium_chestplate",  new TitaniumArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem TITANIUM_LEGGINGS = registerItem("titanium_leggings",  new TitaniumArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem TITANIUM_BOOTS = registerItem("titanium_boots",  new TitaniumArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem TITANIUM_SWORD = registerItem("titanium_sword",  new SwordItem(MGToolMaterials.TITANIUM_TIER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.TITANIUM_TIER, 5, -1.5F))));
    public static final PickaxeItem TITANIUM_PICKAXE = registerItem("titanium_pickaxe",  new PickaxeItem(MGToolMaterials.TITANIUM_TIER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.TITANIUM_TIER, 2, -2f))));
    public static final ShovelItem TITANIUM_SHOVEL = registerItem("titanium_shovel",  new ShovelItem(MGToolMaterials.TITANIUM_TIER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.TITANIUM_TIER, 2f, -2f))));
    public static final AxeItem TITANIUM_AXE = registerItem("titanium_axe",  new AxeItem(MGToolMaterials.TITANIUM_TIER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.TITANIUM_TIER, 6, -2.2f))));
    public static final HoeItem TITANIUM_HOE = registerItem("titanium_hoe",  new HoeItem(MGToolMaterials.TITANIUM_TIER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.TITANIUM_TIER, -2f, 0.0f))));

    public static final ArmorItem ENDERITE_HELMET = registerItem("enderite_helmet",  new EnderiteArmor(ArmorItem.Type.HELMET));
    public static final ArmorItem ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",  new EnderiteArmor(ArmorItem.Type.CHESTPLATE));
    public static final ArmorItem ENDERITE_LEGGINGS = registerItem("enderite_leggings",  new EnderiteArmor(ArmorItem.Type.LEGGINGS));
    public static final ArmorItem ENDERITE_BOOTS = registerItem("enderite_boots",  new EnderiteArmor(ArmorItem.Type.BOOTS));

    public static final SwordItem ENDERITE_SWORD = registerItem("enderite_sword",
             new SwordItem(MGToolMaterials.ENDERITE_TIER, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).attributeModifiers(SwordItem.createAttributeModifiers(MGToolMaterials.ENDERITE_TIER, 8, -1F))));
    public static final PickaxeItem ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
             new PickaxeItem(MGToolMaterials.ENDERITE_TIER, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).attributeModifiers(PickaxeItem.createAttributeModifiers(MGToolMaterials.ENDERITE_TIER, 4, -1.3f))));
    public static final ShovelItem ENDERITE_SHOVEL = registerItem("enderite_shovel",
             new ShovelItem(MGToolMaterials.ENDERITE_TIER, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).attributeModifiers(ShovelItem.createAttributeModifiers(MGToolMaterials.ENDERITE_TIER, 3.5f, -1.8f))));
    public static final AxeItem ENDERITE_AXE = registerItem("enderite_axe",
             new AxeItem(MGToolMaterials.ENDERITE_TIER, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).attributeModifiers(AxeItem.createAttributeModifiers(MGToolMaterials.ENDERITE_TIER, 9, -1.5f))));
    public static final HoeItem ENDERITE_HOE = registerItem("enderite_hoe",
             new HoeItem(MGToolMaterials.ENDERITE_TIER, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).attributeModifiers(HoeItem.createAttributeModifiers(MGToolMaterials.ENDERITE_TIER, -1f, 0.0f))));

    public static final SmithingTemplateItem TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template",  new SmithingTemplateItem(
            Text.literal("Netherite Equipment").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Titanium Ingot").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Titanium Upgrade").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.literal("Add Netherite Armor, Weapon, or Tool"),
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
            List.of(Identifier.ofVanilla("item/empty_slot_ingot"))
    ));

    public static final SmithingTemplateItem ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template",  new SmithingTemplateItem(
            Text.literal("Titanium Equipment").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Enderite Ingot").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.literal("Enderite Upgrade").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.literal("Add Titanium Armor, Weapon, or Tool"),
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
            List.of(Identifier.ofVanilla("item/empty_slot_ingot"))
    ));

    private static <T extends Item> T registerItem(String name, T item){
        return Registry.register(Registries.ITEM, Identifier.of(MoreGears.MODID, name), item);
    }

    public static void init() {

    }
}
