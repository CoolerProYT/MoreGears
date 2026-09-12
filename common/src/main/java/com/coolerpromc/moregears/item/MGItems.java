package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.custom.*;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.item.custom.MGMaceItem;
import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.ItemLikeRegistryHandler;
import com.coolerpromc.moregears.tool.MGToolMaterials;
import com.coolerpromc.moregears.tool.bronze.BronzeAxe;
import com.coolerpromc.moregears.tool.bronze.BronzeHoe;
import com.coolerpromc.moregears.tool.bronze.BronzePickaxe;
import com.coolerpromc.moregears.tool.bronze.BronzeShovel;
import com.coolerpromc.moregears.tool.steel.*;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.List;

public class MGItems {
    public static final ItemLikeRegistryHandler<Item> RAW_TIN = Services.REGISTRY.registerItem("raw_tin", Item::new);
    public static final ItemLikeRegistryHandler<Item> RAW_RUBY = Services.REGISTRY.registerItem("raw_ruby", Item::new);
    public static final ItemLikeRegistryHandler<Item> RAW_TITANIUM = Services.REGISTRY.registerItem("raw_titanium", Item::new);
    public static final ItemLikeRegistryHandler<Item> RAW_ENDERITE = Services.REGISTRY.registerItem("raw_enderite", Item::new);

    public static final ItemLikeRegistryHandler<Item> TITANIUM_NUGGET = Services.REGISTRY.registerItem("titanium_nugget", Item::new);

    public static final ItemLikeRegistryHandler<Item> TIN_INGOT = Services.REGISTRY.registerItem("tin_ingot", properties -> new Item(properties.trimMaterial(MGTrimMaterials.TIN)));
    public static final ItemLikeRegistryHandler<Item> BRONZE_INGOT = Services.REGISTRY.registerItem("bronze_ingot", properties -> new Item(properties.trimMaterial(MGTrimMaterials.BRONZE)));
    public static final ItemLikeRegistryHandler<Item> STEEL_INGOT = Services.REGISTRY.registerItem("steel_ingot", properties -> new Item(properties.trimMaterial(MGTrimMaterials.STEEL)));
    public static final ItemLikeRegistryHandler<Item> RUBY_INGOT = Services.REGISTRY.registerItem("ruby", properties -> new Item(properties.trimMaterial(MGTrimMaterials.RUBY)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_INGOT = Services.REGISTRY.registerItem("titanium_ingot", properties -> new Item(properties.trimMaterial(MGTrimMaterials.TITANIUM)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_INGOT = Services.REGISTRY.registerItem("enderite_ingot", properties -> new Item(properties.trimMaterial(MGTrimMaterials.ENDERITE)));

    public static final ItemLikeRegistryHandler<MGArmorItem> BRONZE_HELMET = Services.REGISTRY.registerItem("bronze_helmet", properties -> new BronzeArmor(ArmorType.HELMET, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> BRONZE_CHESTPLATE = Services.REGISTRY.registerItem("bronze_chestplate", properties -> new BronzeArmor(ArmorType.CHESTPLATE, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> BRONZE_LEGGINGS = Services.REGISTRY.registerItem("bronze_leggings", properties -> new BronzeArmor(ArmorType.LEGGINGS, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> BRONZE_BOOTS = Services.REGISTRY.registerItem("bronze_boots", properties -> new BronzeArmor(ArmorType.BOOTS, properties));

    public static final ItemLikeRegistryHandler<Item> BRONZE_SWORD = Services.REGISTRY.registerItem("bronze_sword", properties -> new Item(properties.sword(MGToolMaterials.BRONZE_TIER, 3, -2.4F)));
    public static final ItemLikeRegistryHandler<Item> BRONZE_PICKAXE = Services.REGISTRY.registerItem("bronze_pickaxe", properties -> new BronzePickaxe(MGToolMaterials.BRONZE_TIER, 1, -2.8f, properties));
    public static final ItemLikeRegistryHandler<Item> BRONZE_SHOVEL = Services.REGISTRY.registerItem("bronze_shovel", properties -> new BronzeShovel(MGToolMaterials.BRONZE_TIER, 1.5f, -3f, properties));
    public static final ItemLikeRegistryHandler<Item> BRONZE_AXE = Services.REGISTRY.registerItem("bronze_axe", properties -> new BronzeAxe(MGToolMaterials.BRONZE_TIER,  5.5f, -3.0f, properties));
    public static final ItemLikeRegistryHandler<Item> BRONZE_HOE = Services.REGISTRY.registerItem("bronze_hoe", properties -> new BronzeHoe(MGToolMaterials.BRONZE_TIER,  -2.5f, -0.5f, properties));
    public static final ItemLikeRegistryHandler<Item> BRONZE_SPEAR = Services.REGISTRY.registerItem("bronze_spear", properties -> new Item(properties
            .spear(MGToolMaterials.BRONZE_TIER, 0.9F, 0.89F, 0.625F, 3.5F, 8.5F, 7.5F, 5.1F, 11.875F, 4.6F))
    );

    public static final ItemLikeRegistryHandler<MGArmorItem> STEEL_HELMET = Services.REGISTRY.registerItem("steel_helmet", properties -> new SteelArmor(ArmorType.HELMET, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> STEEL_CHESTPLATE = Services.REGISTRY.registerItem("steel_chestplate", properties -> new SteelArmor(ArmorType.CHESTPLATE, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> STEEL_LEGGINGS = Services.REGISTRY.registerItem("steel_leggings", properties -> new SteelArmor(ArmorType.LEGGINGS, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> STEEL_BOOTS = Services.REGISTRY.registerItem("steel_boots", properties -> new SteelArmor(ArmorType.BOOTS, properties));

    public static final ItemLikeRegistryHandler<Item> STEEL_SWORD = Services.REGISTRY.registerItem("steel_sword", properties -> new SteelSword(MGToolMaterials.STEEL_TIER, 3, -1.4F, properties));
    public static final ItemLikeRegistryHandler<Item> STEEL_PICKAXE = Services.REGISTRY.registerItem("steel_pickaxe", properties -> new SteelPickaxe(MGToolMaterials.STEEL_TIER, 1, -1.8f, properties));
    public static final ItemLikeRegistryHandler<Item> STEEL_SHOVEL = Services.REGISTRY.registerItem("steel_shovel", properties -> new SteelShovel(MGToolMaterials.STEEL_TIER, 1.5f, -2f, properties));
    public static final ItemLikeRegistryHandler<Item> STEEL_AXE = Services.REGISTRY.registerItem("steel_axe", properties -> new SteelAxe(MGToolMaterials.STEEL_TIER, 6, -2f, properties));
    public static final ItemLikeRegistryHandler<Item> STEEL_HOE = Services.REGISTRY.registerItem("steel_hoe", properties -> new SteelHoe(MGToolMaterials.STEEL_TIER, -2f, 0.0f, properties));
    public static final ItemLikeRegistryHandler<Item> STEEL_SPEAR = Services.REGISTRY.registerItem("steel_spear", properties -> new Item(properties
            .spear(MGToolMaterials.STEEL_TIER, 0.98F, 1F, 0.57F, 2.65F, 7.85F, 6.67F, 5.1F, 10.8F, 4.6F))
    );

    public static final ItemLikeRegistryHandler<MGArmorItem> RUBY_HELMET = Services.REGISTRY.registerItem("ruby_helmet", properties -> new RubyArmor(ArmorType.HELMET, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> RUBY_CHESTPLATE = Services.REGISTRY.registerItem("ruby_chestplate", properties -> new RubyArmor(ArmorType.CHESTPLATE, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> RUBY_LEGGINGS = Services.REGISTRY.registerItem("ruby_leggings", properties -> new RubyArmor(ArmorType.LEGGINGS, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> RUBY_BOOTS = Services.REGISTRY.registerItem("ruby_boots", properties -> new RubyArmor(ArmorType.BOOTS, properties));

    public static final ItemLikeRegistryHandler<Item> RUBY_SWORD = Services.REGISTRY.registerItem("ruby_sword", properties -> new Item(properties.sword(MGToolMaterials.RUBY_TIER, 3, -2.4F)));
    public static final ItemLikeRegistryHandler<Item> RUBY_PICKAXE = Services.REGISTRY.registerItem("ruby_pickaxe", properties -> new Item(properties.pickaxe(MGToolMaterials.RUBY_TIER, 1f, -2.8f)));
    public static final ItemLikeRegistryHandler<Item> RUBY_SHOVEL = Services.REGISTRY.registerItem("ruby_shovel", properties -> new Item(properties.shovel(MGToolMaterials.RUBY_TIER, 1.5f, -3f)));
    public static final ItemLikeRegistryHandler<Item> RUBY_AXE = Services.REGISTRY.registerItem("ruby_axe", properties -> new Item(properties.axe(MGToolMaterials.RUBY_TIER, 4, -3.2f)));
    public static final ItemLikeRegistryHandler<Item> RUBY_HOE = Services.REGISTRY.registerItem("ruby_hoe", properties -> new Item(properties.hoe(MGToolMaterials.RUBY_TIER, -3f, 0f)));
    public static final ItemLikeRegistryHandler<Item> RUBY_SPEAR = Services.REGISTRY.registerItem("ruby_spear", properties -> new Item(properties
            .spear(MGToolMaterials.RUBY_TIER, 1.02F, 1.04F, 0.53F, 2.75F, 7.65F, 6.58F, 5.1F, 10.4F, 4.6F))
    );

    public static final ItemLikeRegistryHandler<MGArmorItem> TITANIUM_HELMET = Services.REGISTRY.registerItem("titanium_helmet", properties -> new TitaniumArmor(ArmorType.HELMET, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> TITANIUM_CHESTPLATE = Services.REGISTRY.registerItem("titanium_chestplate", properties -> new TitaniumArmor(ArmorType.CHESTPLATE, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> TITANIUM_LEGGINGS = Services.REGISTRY.registerItem("titanium_leggings", properties -> new TitaniumArmor(ArmorType.LEGGINGS, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> TITANIUM_BOOTS = Services.REGISTRY.registerItem("titanium_boots", properties -> new TitaniumArmor(ArmorType.BOOTS, properties));

    public static final ItemLikeRegistryHandler<Item> TITANIUM_SWORD = Services.REGISTRY.registerItem("titanium_sword", properties -> new Item(properties.sword(MGToolMaterials.TITANIUM_TIER, 5, -1.5F)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_PICKAXE = Services.REGISTRY.registerItem("titanium_pickaxe", properties -> new Item(properties.pickaxe(MGToolMaterials.TITANIUM_TIER, 2, -2f)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_SHOVEL = Services.REGISTRY.registerItem("titanium_shovel", properties -> new Item(properties.shovel(MGToolMaterials.TITANIUM_TIER, 2f, -2f)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_AXE = Services.REGISTRY.registerItem("titanium_axe", properties -> new Item(properties.axe(MGToolMaterials.TITANIUM_TIER, 6, -2.2f)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_HOE = Services.REGISTRY.registerItem("titanium_hoe", properties -> new Item(properties.hoe(MGToolMaterials.TITANIUM_TIER, -2f, 0.0f)));
    public static final ItemLikeRegistryHandler<Item> TITANIUM_SPEAR = Services.REGISTRY.registerItem("titanium_spear", properties -> new Item(properties
            .spear(MGToolMaterials.TITANIUM_TIER, 1.25F, 1.325F, 0.3F, 2F, 6.5F, 4.5F, 5.1F, 7.5F, 4.6F).fireResistant())
    );
    public static final ItemLikeRegistryHandler<MGMaceItem> TITANIUM_MACE = Services.REGISTRY.registerItem("titanium_mace", properties -> new MGMaceItem(properties
            .fireResistant()
            .rarity(Rarity.EPIC)
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponents.TOOL, MGMaceItem.createToolProperties(MGToolMaterials.TITANIUM_TIER))
            .attributes(MGMaceItem.createAttributes(MGToolMaterials.TITANIUM_TIER, -2.4f))
            .enchantable(MGToolMaterials.TITANIUM_TIER.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(2))
    ));

    public static final ItemLikeRegistryHandler<MGArmorItem> ENDERITE_HELMET = Services.REGISTRY.registerItem("enderite_helmet", properties -> new EnderiteArmor(ArmorType.HELMET, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> ENDERITE_CHESTPLATE = Services.REGISTRY.registerItem("enderite_chestplate", properties -> new EnderiteArmor(ArmorType.CHESTPLATE, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> ENDERITE_LEGGINGS = Services.REGISTRY.registerItem("enderite_leggings", properties -> new EnderiteArmor(ArmorType.LEGGINGS, properties));
    public static final ItemLikeRegistryHandler<MGArmorItem> ENDERITE_BOOTS = Services.REGISTRY.registerItem("enderite_boots", properties -> new EnderiteArmor(ArmorType.BOOTS, properties));

    public static final ItemLikeRegistryHandler<Item> ENDERITE_SWORD = Services.REGISTRY.registerItem("enderite_sword",
            properties -> new Item(properties.sword(MGToolMaterials.ENDERITE_TIER, 8, -1F).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_PICKAXE = Services.REGISTRY.registerItem("enderite_pickaxe",
            properties -> new Item(properties.pickaxe(MGToolMaterials.ENDERITE_TIER, 4, -1.3f).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_SHOVEL = Services.REGISTRY.registerItem("enderite_shovel",
            properties -> new Item(properties.shovel(MGToolMaterials.ENDERITE_TIER, 3.5f, -1.8f).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_AXE = Services.REGISTRY.registerItem("enderite_axe",
            properties -> new Item(properties.axe(MGToolMaterials.ENDERITE_TIER, 9, -1.5f).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_HOE = Services.REGISTRY.registerItem("enderite_hoe",
            properties -> new Item(properties.hoe(MGToolMaterials.ENDERITE_TIER, -1f, 0.0f).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final ItemLikeRegistryHandler<Item> ENDERITE_SPEAR = Services.REGISTRY.registerItem("enderite_spear", properties -> new Item(properties
            .spear(MGToolMaterials.ENDERITE_TIER, 1.35F, 1.45F, 0.2F, 1.5F, 6F, 3.5F, 5.1F, 6.25F, 4.6F).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE))
    );
    public static final ItemLikeRegistryHandler<MGMaceItem> ENDERITE_MACE = Services.REGISTRY.registerItem("enderite_mace", properties -> new MGMaceItem(properties
            .fireResistant()
            .rarity(Rarity.EPIC)
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponents.TOOL, MGMaceItem.createToolProperties(MGToolMaterials.ENDERITE_TIER))
            .attributes(MGMaceItem.createAttributes(MGToolMaterials.ENDERITE_TIER, -1.4f))
            .enchantable(MGToolMaterials.ENDERITE_TIER.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(3))
    ));

    public static final ItemLikeRegistryHandler<SmithingTemplateItem> TITANIUM_UPGRADE_SMITHING_TEMPLATE = Services.REGISTRY.registerItem("titanium_upgrade_smithing_template", properties -> new SmithingTemplateItem(
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.equipment_info").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.ingredient").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    Identifier.withDefaultNamespace("container/slot/helmet"),
                    Identifier.withDefaultNamespace("container/slot/chestplate"),
                    Identifier.withDefaultNamespace("container/slot/leggings"),
                    Identifier.withDefaultNamespace("container/slot/boots"),
                    Identifier.withDefaultNamespace("container/slot/hoe"),
                    Identifier.withDefaultNamespace("container/slot/axe"),
                    Identifier.withDefaultNamespace("container/slot/sword"),
                    Identifier.withDefaultNamespace("container/slot/shovel"),
                    Identifier.withDefaultNamespace("container/slot/pickaxe"),
                    Identifier.fromNamespaceAndPath(Constants.MODID, "container/slot/mace")
            ),
            List.of(Identifier.withDefaultNamespace("container/slot/ingot")),
            properties
    ));

    public static final ItemLikeRegistryHandler<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = Services.REGISTRY.registerItem("enderite_upgrade_smithing_template", properties -> new SmithingTemplateItem(
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.equipment_info").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.ingredient").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    Identifier.withDefaultNamespace("container/slot/helmet"),
                    Identifier.withDefaultNamespace("container/slot/chestplate"),
                    Identifier.withDefaultNamespace("container/slot/leggings"),
                    Identifier.withDefaultNamespace("container/slot/boots"),
                    Identifier.withDefaultNamespace("container/slot/hoe"),
                    Identifier.withDefaultNamespace("container/slot/axe"),
                    Identifier.withDefaultNamespace("container/slot/sword"),
                    Identifier.withDefaultNamespace("container/slot/shovel"),
                    Identifier.withDefaultNamespace("container/slot/pickaxe"),
                    Identifier.fromNamespaceAndPath(Constants.MODID, "container/slot/mace")
            ),
            List.of(Identifier.withDefaultNamespace("container/slot/ingot")),
            properties
    ));

    public static final ItemLikeRegistryHandler<MGArrowItem> COPPER_ARROW = Services.REGISTRY.registerItem("copper_arrow", properties -> new MGArrowItem(properties, 1.75D, MGEntities.COPPER_ARROW.get()));
    public static final ItemLikeRegistryHandler<MGArrowItem> BRONZE_ARROW = Services.REGISTRY.registerItem("bronze_arrow", properties -> new MGArrowItem(properties, 2.5D, MGEntities.BRONZE_ARROW.get()));
    public static final ItemLikeRegistryHandler<MGArrowItem> STEEL_ARROW = Services.REGISTRY.registerItem("steel_arrow", properties -> new MGArrowItem(properties, 3.0D, MGEntities.STEEL_ARROW.get()));
    public static final ItemLikeRegistryHandler<MGArrowItem> RUBY_ARROW = Services.REGISTRY.registerItem("ruby_arrow", properties -> new MGArrowItem(properties, 3.5D, MGEntities.RUBY_ARROW.get()));
    public static final ItemLikeRegistryHandler<MGArrowItem> TITANIUM_ARROW = Services.REGISTRY.registerItem("titanium_arrow", properties -> new MGArrowItem(properties, 4.5D, MGEntities.TITANIUM_ARROW.get()));
    public static final ItemLikeRegistryHandler<MGArrowItem> ENDERITE_ARROW = Services.REGISTRY.registerItem("enderite_arrow", properties -> new MGArrowItem(properties, 5.0D, MGEntities.ENDERITE_ARROW.get()));

    public static final ItemLikeRegistryHandler<BowItem> COPPER_BOW = Services.REGISTRY.registerItem("copper_bow", properties -> new BowItem(properties.durability(520).enchantable(1)));
    public static final ItemLikeRegistryHandler<BowItem> BRONZE_BOW = Services.REGISTRY.registerItem("bronze_bow", properties -> new BowItem(properties.durability(789).enchantable(1)));
    public static final ItemLikeRegistryHandler<BowItem> STEEL_BOW = Services.REGISTRY.registerItem("steel_bow", properties -> new BowItem(properties.durability(1115).enchantable(1)));
    public static final ItemLikeRegistryHandler<BowItem> RUBY_BOW = Services.REGISTRY.registerItem("ruby_bow", properties -> new BowItem(properties.durability(1442).enchantable(1)));
    public static final ItemLikeRegistryHandler<BowItem> TITANIUM_BOW = Services.REGISTRY.registerItem("titanium_bow", properties -> new BowItem(properties.durability(1763).enchantable(1)));
    public static final ItemLikeRegistryHandler<BowItem> ENDERITE_BOW = Services.REGISTRY.registerItem("enderite_bow", properties -> new BowItem(properties.fireResistant().durability(Integer.MAX_VALUE).enchantable(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    
    public static void load() {
    }
}
