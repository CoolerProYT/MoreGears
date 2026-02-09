package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.custom.*;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.item.custom.*;
import com.coolerpromc.moregears.tool.MGToolMaterials;
import com.coolerpromc.moregears.tool.bronze.BronzeAxe;
import com.coolerpromc.moregears.tool.bronze.BronzeHoe;
import com.coolerpromc.moregears.tool.bronze.BronzePickaxe;
import com.coolerpromc.moregears.tool.bronze.BronzeShovel;
import com.coolerpromc.moregears.tool.steel.*;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.util.MGColors;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WeaponComponent;
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
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;

import java.util.List;
import java.util.function.Function;

public class MGItems {
    public static final MGRawOre RAW_TIN = registerItem("raw_tin", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_tin")), MGColors.TIN_COLOR));
    public static final MGRawOre RAW_RUBY = registerItem("raw_ruby", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_ruby")), MGColors.RUBY_COLOR));
    public static final MGRawOre RAW_TITANIUM = registerItem("raw_titanium", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_titanium")), MGColors.TITANIUM_COLOR));
    public static final MGRawOre RAW_ENDERITE = registerItem("raw_enderite", new MGRawOre(new Item.Settings().registryKey(createItemKey("raw_enderite")), MGColors.ENDERITE_COLOR));

    public static final MGNugget TITANIUM_NUGGET = registerItem("titanium_nugget", new MGNugget(new Item.Settings().registryKey(createItemKey("titanium_nugget")), MGColors.TITANIUM_COLOR));

    public static final MGIngot TIN_INGOT = registerItem("tin_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("tin_ingot")).trimMaterial(MGTrimMaterials.TIN), MGColors.TIN_COLOR));
    public static final MGIngot BRONZE_INGOT = registerItem("bronze_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("bronze_ingot")).trimMaterial(MGTrimMaterials.BRONZE), MGColors.BRONZE_COLOR));
    public static final MGIngot STEEL_INGOT = registerItem("steel_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("steel_ingot")).trimMaterial(MGTrimMaterials.STEEL), MGColors.STEEL_COLOR));
    public static final MGIngot RUBY_INGOT = registerItem("ruby", new MGIngot(new Item.Settings().registryKey(createItemKey("ruby")).trimMaterial(MGTrimMaterials.RUBY), MGColors.RUBY_COLOR));
    public static final MGIngot TITANIUM_INGOT = registerItem("titanium_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("titanium_ingot")).trimMaterial(MGTrimMaterials.TITANIUM), MGColors.TITANIUM_COLOR));
    public static final MGIngot ENDERITE_INGOT = registerItem("enderite_ingot", new MGIngot(new Item.Settings().registryKey(createItemKey("enderite_ingot")).trimMaterial(MGTrimMaterials.ENDERITE), MGColors.ENDERITE_COLOR));

    public static final MGArmorItem BRONZE_HELMET = registerItem("bronze_helmet", new BronzeArmor(EquipmentType.HELMET, "bronze_helmet"));
    public static final MGArmorItem BRONZE_CHESTPLATE = registerItem("bronze_chestplate", new BronzeArmor(EquipmentType.CHESTPLATE, "bronze_chestplate"));
    public static final MGArmorItem BRONZE_LEGGINGS = registerItem("bronze_leggings", new BronzeArmor(EquipmentType.LEGGINGS, "bronze_leggings"));
    public static final MGArmorItem BRONZE_BOOTS = registerItem("bronze_boots", new BronzeArmor(EquipmentType.BOOTS, "bronze_boots"));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword", new Item(new Item.Settings().sword(MGToolMaterials.BRONZE_TIER, 3, -2.4F).registryKey(createItemKey("bronze_sword"))));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe", new BronzePickaxe(MGToolMaterials.BRONZE_TIER, 1, -2.8F, new Item.Settings().registryKey(createItemKey("bronze_pickaxe"))));
    public static final ShovelItem BRONZE_SHOVEL = registerItem("bronze_shovel", new BronzeShovel(MGToolMaterials.BRONZE_TIER, 1.5F, -3.0F, new Item.Settings().registryKey(createItemKey("bronze_shovel"))));
    public static final AxeItem BRONZE_AXE = registerItem("bronze_axe", new BronzeAxe(MGToolMaterials.BRONZE_TIER, 5.5F, -3.0F, new Item.Settings().registryKey(createItemKey("bronze_axe"))));
    public static final HoeItem BRONZE_HOE = registerItem("bronze_hoe", new BronzeHoe(MGToolMaterials.BRONZE_TIER, -2.5F, -0.5F, new Item.Settings().registryKey(createItemKey("bronze_hoe"))));
    public static final Item BRONZE_SPEAR = registerItemWithKey("bronze_spear", properties -> new Item(properties
            .spear(MGToolMaterials.BRONZE_TIER, 0.9F, 0.89F, 0.625F, 3.5F, 8.5F, 7.5F, 5.1F, 11.875F, 4.6F))
    );

    public static final MGArmorItem STEEL_HELMET = registerItem("steel_helmet", new SteelArmor(EquipmentType.HELMET, "steel_helmet"));
    public static final MGArmorItem STEEL_CHESTPLATE = registerItem("steel_chestplate", new SteelArmor(EquipmentType.CHESTPLATE, "steel_chestplate"));
    public static final MGArmorItem STEEL_LEGGINGS = registerItem("steel_leggings", new SteelArmor(EquipmentType.LEGGINGS, "steel_leggings"));
    public static final MGArmorItem STEEL_BOOTS = registerItem("steel_boots", new SteelArmor(EquipmentType.BOOTS, "steel_boots"));

    public static final Item STEEL_SWORD = registerItem("steel_sword", new SteelSword(MGToolMaterials.STEEL_TIER, 3, -1.4F, new Item.Settings().registryKey(createItemKey("steel_sword"))));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new SteelPickaxe(MGToolMaterials.STEEL_TIER, 1, -1.8F, new Item.Settings().registryKey(createItemKey("steel_pickaxe"))));
    public static final ShovelItem STEEL_SHOVEL = registerItem("steel_shovel", new SteelShovel(MGToolMaterials.STEEL_TIER, 1.5F, -2.0F, new Item.Settings().registryKey(createItemKey("steel_shovel"))));
    public static final AxeItem STEEL_AXE = registerItem("steel_axe", new SteelAxe(MGToolMaterials.STEEL_TIER, 6.0F, -2.0F, new Item.Settings().registryKey(createItemKey("steel_axe"))));
    public static final HoeItem STEEL_HOE = registerItem("steel_hoe", new SteelHoe(MGToolMaterials.STEEL_TIER, -2.0F, 0.0F, new Item.Settings().registryKey(createItemKey("steel_hoe"))));
    public static final Item STEEL_SPEAR = registerItemWithKey("steel_spear", properties -> new Item(properties
            .spear(MGToolMaterials.STEEL_TIER, 0.98F, 1F, 0.57F, 2.65F, 7.85F, 6.67F, 5.1F, 10.8F, 4.6F))
    );

    public static final MGArmorItem RUBY_HELMET = registerItem("ruby_helmet", new RubyArmor(EquipmentType.HELMET, "ruby_helmet"));
    public static final MGArmorItem RUBY_CHESTPLATE = registerItem("ruby_chestplate", new RubyArmor(EquipmentType.CHESTPLATE, "ruby_chestplate"));
    public static final MGArmorItem RUBY_LEGGINGS = registerItem("ruby_leggings", new RubyArmor(EquipmentType.LEGGINGS, "ruby_leggings"));
    public static final MGArmorItem RUBY_BOOTS = registerItem("ruby_boots", new RubyArmor(EquipmentType.BOOTS, "ruby_boots"));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new Item(new Item.Settings().sword(MGToolMaterials.RUBY_TIER, 3, -2.4F).registryKey(createItemKey("ruby_sword"))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new Item(new Item.Settings().pickaxe(MGToolMaterials.RUBY_TIER, 1.0F, -2.8F).registryKey(createItemKey("ruby_pickaxe"))));
    public static final ShovelItem RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(MGToolMaterials.RUBY_TIER, 1.5F, -3.0F, new Item.Settings().registryKey(createItemKey("ruby_shovel"))));
    public static final AxeItem RUBY_AXE = registerItem("ruby_axe", new AxeItem(MGToolMaterials.RUBY_TIER, 4.0F, -3.2F, new Item.Settings().registryKey(createItemKey("ruby_axe"))));
    public static final HoeItem RUBY_HOE = registerItem("ruby_hoe", new HoeItem(MGToolMaterials.RUBY_TIER, -3.0F, 0.0F, new Item.Settings().registryKey(createItemKey("ruby_hoe"))));
    public static final Item RUBY_SPEAR = registerItemWithKey("ruby_spear", properties -> new Item(properties
            .spear(MGToolMaterials.RUBY_TIER, 1.02F, 1.04F, 0.53F, 2.75F, 7.65F, 6.58F, 5.1F, 10.4F, 4.6F))
    );

    public static final MGArmorItem TITANIUM_HELMET = registerItem("titanium_helmet", new TitaniumArmor(EquipmentType.HELMET, "titanium_helmet"));
    public static final MGArmorItem TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", new TitaniumArmor(EquipmentType.CHESTPLATE, "titanium_chestplate"));
    public static final MGArmorItem TITANIUM_LEGGINGS = registerItem("titanium_leggings", new TitaniumArmor(EquipmentType.LEGGINGS, "titanium_leggings"));
    public static final MGArmorItem TITANIUM_BOOTS = registerItem("titanium_boots", new TitaniumArmor(EquipmentType.BOOTS, "titanium_boots"));

    public static final Item TITANIUM_SWORD = registerItem("titanium_sword", new Item(new Item.Settings().sword(MGToolMaterials.TITANIUM_TIER, 5, -1.5F).registryKey(createItemKey("titanium_sword"))));
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe", new Item(new Item.Settings().pickaxe(MGToolMaterials.TITANIUM_TIER, 2, -2.0F).registryKey(createItemKey("titanium_pickaxe"))));
    public static final ShovelItem TITANIUM_SHOVEL = registerItem("titanium_shovel", new ShovelItem(MGToolMaterials.TITANIUM_TIER, 2.0F, -2.0F, new Item.Settings().registryKey(createItemKey("titanium_shovel"))));
    public static final AxeItem TITANIUM_AXE = registerItem("titanium_axe", new AxeItem(MGToolMaterials.TITANIUM_TIER, 6.0F, -2.2F, new Item.Settings().registryKey(createItemKey("titanium_axe"))));
    public static final HoeItem TITANIUM_HOE = registerItem("titanium_hoe", new HoeItem(MGToolMaterials.TITANIUM_TIER, -2.0F, 0.0F, new Item.Settings().registryKey(createItemKey("titanium_hoe"))));
    public static final Item TITANIUM_SPEAR = registerItemWithKey("titanium_spear", properties -> new Item(properties
            .spear(MGToolMaterials.TITANIUM_TIER, 1.25F, 1.325F, 0.3F, 2F, 6.5F, 4.5F, 5.1F, 7.5F, 4.6F).fireproof())
    );
    public static final MGMaceItem TITANIUM_MACE = registerItemWithKey("titanium_mace", properties -> new MGMaceItem(properties
            .fireproof()
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.TOOL, MGMaceItem.createToolProperties(MGToolMaterials.TITANIUM_TIER))
            .attributeModifiers(MGMaceItem.createAttributes(MGToolMaterials.TITANIUM_TIER, -2.4f))
            .enchantable(MGToolMaterials.TITANIUM_TIER.enchantmentValue())
            .component(DataComponentTypes.WEAPON, new WeaponComponent(2))
    ));

    public static final MGArmorItem ENDERITE_HELMET = registerItem("enderite_helmet", new EnderiteArmor(EquipmentType.HELMET, "enderite_helmet"));
    public static final MGArmorItem ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", new EnderiteArmor(EquipmentType.CHESTPLATE, "enderite_chestplate"));
    public static final MGArmorItem ENDERITE_LEGGINGS = registerItem("enderite_leggings", new EnderiteArmor(EquipmentType.LEGGINGS, "enderite_leggings"));
    public static final MGArmorItem ENDERITE_BOOTS = registerItem("enderite_boots", new EnderiteArmor(EquipmentType.BOOTS, "enderite_boots"));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", new Item(new Item.Settings().fireproof().sword(MGToolMaterials.ENDERITE_TIER, 8, -1.0F).component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(createItemKey("enderite_sword"))));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new Item(new Item.Settings().fireproof().pickaxe(MGToolMaterials.ENDERITE_TIER, 4, -1.3F).component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(createItemKey("enderite_pickaxe"))));
    public static final ShovelItem ENDERITE_SHOVEL = registerItem("enderite_shovel", new ShovelItem(MGToolMaterials.ENDERITE_TIER, 3.5F, -1.8F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(createItemKey("enderite_shovel"))));
    public static final AxeItem ENDERITE_AXE = registerItem("enderite_axe", new AxeItem(MGToolMaterials.ENDERITE_TIER, 9, -1.5F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(createItemKey("enderite_axe"))));
    public static final HoeItem ENDERITE_HOE = registerItem("enderite_hoe", new HoeItem(MGToolMaterials.ENDERITE_TIER, -1.0F, 0.0F, new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(createItemKey("enderite_hoe"))));
    public static final Item ENDERITE_SPEAR = registerItemWithKey("enderite_spear", properties -> new Item(properties
            .spear(MGToolMaterials.ENDERITE_TIER, 1.35F, 1.45F, 0.2F, 1.5F, 6F, 3.5F, 5.1F, 6.25F, 4.6F).fireproof().component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE))
    );
    public static final MGMaceItem ENDERITE_MACE = registerItemWithKey("enderite_mace", properties -> new MGMaceItem(properties
            .fireproof()
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.TOOL, MGMaceItem.createToolProperties(MGToolMaterials.ENDERITE_TIER))
            .attributeModifiers(MGMaceItem.createAttributes(MGToolMaterials.ENDERITE_TIER, -1.4f))
            .enchantable(MGToolMaterials.ENDERITE_TIER.enchantmentValue())
            .component(DataComponentTypes.WEAPON, new WeaponComponent(3))
    ));

    public static final SmithingTemplateItem TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template", new SmithingTemplateItem(
            Text.translatable("item.moregears.titanium_upgrade_smithing_template.equipment_info").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.translatable("item.moregears.titanium_upgrade_smithing_template.ingredient").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.translatable("item.moregears.titanium_upgrade_smithing_template.upgrade_description").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.translatable("item.moregears.titanium_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    Identifier.ofVanilla("container/slot/helmet"),
                    Identifier.ofVanilla("container/slot/chestplate"),
                    Identifier.ofVanilla("container/slot/leggings"),
                    Identifier.ofVanilla("container/slot/boots"),
                    Identifier.ofVanilla("container/slot/hoe"),
                    Identifier.ofVanilla("container/slot/axe"),
                    Identifier.ofVanilla("container/slot/sword"),
                    Identifier.ofVanilla("container/slot/shovel"),
                    Identifier.ofVanilla("container/slot/pickaxe"),
                    Identifier.of(MoreGears.MODID, "container/slot/mace")
            ),
            List.of(Identifier.ofVanilla("container/slot/ingot")),
            new Item.Settings().registryKey(createItemKey("titanium_upgrade_smithing_template"))
    ));

    public static final SmithingTemplateItem ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", new SmithingTemplateItem(
            Text.translatable("item.moregears.enderite_upgrade_smithing_template.equipment_info").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.translatable("item.moregears.enderite_upgrade_smithing_template.ingredient").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
            Text.translatable("item.moregears.enderite_upgrade_smithing_template.upgrade_description").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)),
            Text.translatable("item.moregears.enderite_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    Identifier.ofVanilla("container/slot/helmet"),
                    Identifier.ofVanilla("container/slot/chestplate"),
                    Identifier.ofVanilla("container/slot/leggings"),
                    Identifier.ofVanilla("container/slot/boots"),
                    Identifier.ofVanilla("container/slot/hoe"),
                    Identifier.ofVanilla("container/slot/axe"),
                    Identifier.ofVanilla("container/slot/sword"),
                    Identifier.ofVanilla("container/slot/shovel"),
                    Identifier.ofVanilla("container/slot/pickaxe"),
                    Identifier.of(MoreGears.MODID, "container/slot/mace")
            ),
            List.of(Identifier.ofVanilla("container/slot/ingot")),
            new Item.Settings().registryKey(createItemKey("enderite_upgrade_smithing_template"))
    ));

    public static final MGArrowItem COPPER_ARROW = registerItem("copper_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("copper_arrow")), 1.75D, MGEntities.COPPER_ARROW));
    public static final MGArrowItem BRONZE_ARROW = registerItem("bronze_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("bronze_arrow")), 2.5D, MGEntities.BRONZE_ARROW));
    public static final MGArrowItem STEEL_ARROW = registerItem("steel_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("steel_arrow")), 3.0D, MGEntities.STEEL_ARROW));
    public static final MGArrowItem RUBY_ARROW = registerItem("ruby_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("ruby_arrow")), 3.5D, MGEntities.RUBY_ARROW));
    public static final MGArrowItem TITANIUM_ARROW = registerItem("titanium_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("titanium_arrow")), 4.5D, MGEntities.TITANIUM_ARROW));
    public static final MGArrowItem ENDERITE_ARROW = registerItem("enderite_arrow", new MGArrowItem(new Item.Settings().registryKey(createItemKey("enderite_arrow")), 5.0D, MGEntities.ENDERITE_ARROW));

    public static final BowItem COPPER_BOW = registerItem("copper_bow", new BowItem(new Item.Settings().registryKey(createItemKey("copper_bow")).maxDamage(520).enchantable(1)));
    public static final BowItem BRONZE_BOW = registerItem("bronze_bow", new BowItem(new Item.Settings().registryKey(createItemKey("bronze_bow")).maxDamage(789).enchantable(1)));
    public static final BowItem STEEL_BOW = registerItem("steel_bow", new BowItem(new Item.Settings().registryKey(createItemKey("steel_bow")).maxDamage(1115).enchantable(1)));
    public static final BowItem RUBY_BOW = registerItem("ruby_bow", new BowItem(new Item.Settings().registryKey(createItemKey("ruby_bow")).maxDamage(1442).enchantable(1)));
    public static final BowItem TITANIUM_BOW = registerItem("titanium_bow", new BowItem(new Item.Settings().registryKey(createItemKey("titanium_bow")).maxDamage(1763).enchantable(1)));
    public static final BowItem ENDERITE_BOW = registerItem("enderite_bow", new BowItem(new Item.Settings().registryKey(createItemKey("enderite_bow")).fireproof().maxDamage(Integer.MAX_VALUE).enchantable(1).component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreGears.MODID, name), item);
    }

    private static RegistryKey<Item> createItemKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name));
    }

    private static <T extends Item> T registerItemWithKey(String name, Function<Item.Settings, T> item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreGears.MODID, name), item.apply(new Item.Settings().registryKey(createItemKey(name))));
    }

    public static void init() {

    }
}
