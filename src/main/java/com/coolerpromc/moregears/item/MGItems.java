package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.custom.*;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import com.coolerpromc.moregears.tool.MGToolMaterials;
import com.coolerpromc.moregears.tool.bronze.BronzeAxe;
import com.coolerpromc.moregears.tool.bronze.BronzeHoe;
import com.coolerpromc.moregears.tool.bronze.BronzePickaxe;
import com.coolerpromc.moregears.tool.bronze.BronzeShovel;
import com.coolerpromc.moregears.tool.steel.*;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.util.MGColors;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Function;

public class MGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreGears.MODID);

    public static final DeferredItem<MGRawOre> RAW_TIN = registerItem("raw_tin", properties -> new MGRawOre(properties, MGColors.TIN_COLOR));
    public static final DeferredItem<MGRawOre> RAW_RUBY = registerItem("raw_ruby", properties -> new MGRawOre(properties, MGColors.RUBY_COLOR));
    public static final DeferredItem<MGRawOre> RAW_TITANIUM = registerItem("raw_titanium", properties -> new MGRawOre(properties, MGColors.TITANIUM_COLOR));
    public static final DeferredItem<MGRawOre> RAW_ENDERITE = registerItem("raw_enderite", properties -> new MGRawOre(properties, MGColors.ENDERITE_COLOR));

    public static final DeferredItem<MGIngot> TIN_INGOT = registerItem("tin_ingot", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.TIN), MGColors.TIN_COLOR));
    public static final DeferredItem<MGIngot> BRONZE_INGOT = registerItem("bronze_ingot", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.BRONZE), MGColors.BRONZE_COLOR));
    public static final DeferredItem<MGIngot> STEEL_INGOT = registerItem("steel_ingot", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.STEEL), MGColors.STEEL_COLOR));
    public static final DeferredItem<MGIngot> RUBY_INGOT = registerItem("ruby", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.RUBY), MGColors.RUBY_COLOR));
    public static final DeferredItem<MGIngot> TITANIUM_INGOT = registerItem("titanium_ingot", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.TITANIUM), MGColors.TITANIUM_COLOR));
    public static final DeferredItem<MGIngot> ENDERITE_INGOT = registerItem("enderite_ingot", properties -> new MGIngot(properties.trimMaterial(MGTrimMaterials.ENDERITE), MGColors.ENDERITE_COLOR));

    public static final DeferredItem<MGArmorItem> COPPER_HELMET = registerItem("copper_helmet", properties -> new CopperArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> COPPER_CHESTPLATE = registerItem("copper_chestplate", properties -> new CopperArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> COPPER_LEGGINGS = registerItem("copper_leggings", properties -> new CopperArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> COPPER_BOOTS = registerItem("copper_boots", properties -> new CopperArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> COPPER_SWORD = registerItem("copper_sword", properties -> new Item(properties.sword(MGToolMaterials.COPPER_TIER, 3, -2.4F)));
    public static final DeferredItem<Item> COPPER_PICKAXE = registerItem("copper_pickaxe", properties -> new Item(properties.pickaxe(MGToolMaterials.COPPER_TIER, 1, -2.8f)));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = registerItem("copper_shovel", properties -> new ShovelItem(MGToolMaterials.COPPER_TIER, 1.5f, -3f, properties));
    public static final DeferredItem<AxeItem> COPPER_AXE = registerItem("copper_axe", properties -> new AxeItem(MGToolMaterials.COPPER_TIER,  7, -3.2f, properties));
    public static final DeferredItem<HoeItem> COPPER_HOE = registerItem("copper_hoe", properties -> new HoeItem(MGToolMaterials.COPPER_TIER,  -1f, -1.5f, properties));

    public static final DeferredItem<MGArmorItem> BRONZE_HELMET = registerItem("bronze_helmet", properties -> new BronzeArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> BRONZE_CHESTPLATE = registerItem("bronze_chestplate", properties -> new BronzeArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> BRONZE_LEGGINGS = registerItem("bronze_leggings", properties -> new BronzeArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> BRONZE_BOOTS = registerItem("bronze_boots", properties -> new BronzeArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> BRONZE_SWORD = registerItem("bronze_sword", properties -> new Item(properties.sword(MGToolMaterials.BRONZE_TIER, 3, -2.4F)));
    public static final DeferredItem<Item> BRONZE_PICKAXE = registerItem("bronze_pickaxe", properties -> new BronzePickaxe(MGToolMaterials.BRONZE_TIER, 1, -2.8f, properties));
    public static final DeferredItem<ShovelItem> BRONZE_SHOVEL = registerItem("bronze_shovel", properties -> new BronzeShovel(MGToolMaterials.BRONZE_TIER, 1.5f, -3f, properties));
    public static final DeferredItem<AxeItem> BRONZE_AXE = registerItem("bronze_axe", properties -> new BronzeAxe(MGToolMaterials.BRONZE_TIER,  5.5f, -3.0f, properties));
    public static final DeferredItem<HoeItem> BRONZE_HOE = registerItem("bronze_hoe", properties -> new BronzeHoe(MGToolMaterials.BRONZE_TIER,  -2.5f, -0.5f, properties));

    public static final DeferredItem<MGArmorItem> STEEL_HELMET = registerItem("steel_helmet", properties -> new SteelArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> STEEL_CHESTPLATE = registerItem("steel_chestplate", properties -> new SteelArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> STEEL_LEGGINGS = registerItem("steel_leggings", properties -> new SteelArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> STEEL_BOOTS = registerItem("steel_boots", properties -> new SteelArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> STEEL_SWORD = registerItem("steel_sword", properties -> new SteelSword(MGToolMaterials.STEEL_TIER, 3, -1.4F, properties));
    public static final DeferredItem<Item> STEEL_PICKAXE = registerItem("steel_pickaxe", properties -> new SteelPickaxe(MGToolMaterials.STEEL_TIER, 1, -1.8f, properties));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = registerItem("steel_shovel", properties -> new SteelShovel(MGToolMaterials.STEEL_TIER, 1.5f, -2f, properties));
    public static final DeferredItem<AxeItem> STEEL_AXE = registerItem("steel_axe", properties -> new SteelAxe(MGToolMaterials.STEEL_TIER, 6, -2f, properties));
    public static final DeferredItem<HoeItem> STEEL_HOE = registerItem("steel_hoe", properties -> new SteelHoe(MGToolMaterials.STEEL_TIER, -2f, 0.0f, properties));

    public static final DeferredItem<MGArmorItem> RUBY_HELMET = registerItem("ruby_helmet", properties -> new RubyArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> RUBY_CHESTPLATE = registerItem("ruby_chestplate", properties -> new RubyArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> RUBY_LEGGINGS = registerItem("ruby_leggings", properties -> new RubyArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> RUBY_BOOTS = registerItem("ruby_boots", properties -> new RubyArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> RUBY_SWORD = registerItem("ruby_sword", properties -> new Item(properties.sword(MGToolMaterials.RUBY_TIER, 3, -2.4F)));
    public static final DeferredItem<Item> RUBY_PICKAXE = registerItem("ruby_pickaxe", properties -> new Item(properties.pickaxe(MGToolMaterials.RUBY_TIER, 1f, -2.8f)));
    public static final DeferredItem<ShovelItem> RUBY_SHOVEL = registerItem("ruby_shovel", properties -> new ShovelItem(MGToolMaterials.RUBY_TIER, 1.5f, -3f, properties));
    public static final DeferredItem<AxeItem> RUBY_AXE = registerItem("ruby_axe", properties -> new AxeItem(MGToolMaterials.RUBY_TIER, 4, -3.2f, properties));
    public static final DeferredItem<HoeItem> RUBY_HOE = registerItem("ruby_hoe", properties -> new HoeItem(MGToolMaterials.RUBY_TIER, -3f, 0f, properties));

    public static final DeferredItem<MGArmorItem> TITANIUM_HELMET = registerItem("titanium_helmet", properties -> new TitaniumArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", properties -> new TitaniumArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> TITANIUM_LEGGINGS = registerItem("titanium_leggings", properties -> new TitaniumArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> TITANIUM_BOOTS = registerItem("titanium_boots", properties -> new TitaniumArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> TITANIUM_SWORD = registerItem("titanium_sword", properties -> new Item(properties.sword(MGToolMaterials.TITANIUM_TIER, 5, -1.5F)));
    public static final DeferredItem<Item> TITANIUM_PICKAXE = registerItem("titanium_pickaxe", properties -> new Item(properties.pickaxe(MGToolMaterials.TITANIUM_TIER, 2, -2f)));
    public static final DeferredItem<ShovelItem> TITANIUM_SHOVEL = registerItem("titanium_shovel", properties -> new ShovelItem(MGToolMaterials.TITANIUM_TIER, 2f, -2f, properties));
    public static final DeferredItem<AxeItem> TITANIUM_AXE = registerItem("titanium_axe", properties -> new AxeItem(MGToolMaterials.TITANIUM_TIER, 6, -2.2f, properties));
    public static final DeferredItem<HoeItem> TITANIUM_HOE = registerItem("titanium_hoe", properties -> new HoeItem(MGToolMaterials.TITANIUM_TIER, -2f, 0.0f, properties));

    public static final DeferredItem<MGArmorItem> ENDERITE_HELMET = registerItem("enderite_helmet", properties -> new EnderiteArmor(ArmorType.HELMET, properties));
    public static final DeferredItem<MGArmorItem> ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", properties -> new EnderiteArmor(ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<MGArmorItem> ENDERITE_LEGGINGS = registerItem("enderite_leggings", properties -> new EnderiteArmor(ArmorType.LEGGINGS, properties));
    public static final DeferredItem<MGArmorItem> ENDERITE_BOOTS = registerItem("enderite_boots", properties -> new EnderiteArmor(ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> ENDERITE_SWORD = registerItem("enderite_sword",
            properties -> new Item(properties.sword(MGToolMaterials.ENDERITE_TIER, 8, -1F).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
            properties -> new Item(properties.pickaxe(MGToolMaterials.ENDERITE_TIER, 4, -1.3f).fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<ShovelItem> ENDERITE_SHOVEL = registerItem("enderite_shovel",
            properties -> new ShovelItem(MGToolMaterials.ENDERITE_TIER, 3.5f, -1.8f, properties.fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<AxeItem> ENDERITE_AXE = registerItem("enderite_axe",
            properties -> new AxeItem(MGToolMaterials.ENDERITE_TIER, 9, -1.5f, properties.fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<HoeItem> ENDERITE_HOE = registerItem("enderite_hoe",
            properties -> new HoeItem(MGToolMaterials.ENDERITE_TIER, -1f, 0.0f, properties.fireResistant().component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));

    public static final DeferredItem<SmithingTemplateItem> TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template", properties -> new SmithingTemplateItem(
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.equipment_info").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.ingredient").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            Component.translatable("item.moregears.titanium_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    ResourceLocation.withDefaultNamespace("container/slot/helmet"),
                    ResourceLocation.withDefaultNamespace("container/slot/chestplate"),
                    ResourceLocation.withDefaultNamespace("container/slot/leggings"),
                    ResourceLocation.withDefaultNamespace("container/slot/boots"),
                    ResourceLocation.withDefaultNamespace("container/slot/hoe"),
                    ResourceLocation.withDefaultNamespace("container/slot/axe"),
                    ResourceLocation.withDefaultNamespace("container/slot/sword"),
                    ResourceLocation.withDefaultNamespace("container/slot/shovel"),
                    ResourceLocation.withDefaultNamespace("container/slot/pickaxe")
            ),
            List.of(ResourceLocation.withDefaultNamespace("container/slot/ingot")),
            properties
    ));

    public static final DeferredItem<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", properties -> new SmithingTemplateItem(
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.equipment_info").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.ingredient").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            Component.translatable("item.moregears.enderite_upgrade_smithing_template.additions_slot_description"),
            List.of(
                    ResourceLocation.withDefaultNamespace("container/slot/helmet"),
                    ResourceLocation.withDefaultNamespace("container/slot/chestplate"),
                    ResourceLocation.withDefaultNamespace("container/slot/leggings"),
                    ResourceLocation.withDefaultNamespace("container/slot/boots"),
                    ResourceLocation.withDefaultNamespace("container/slot/hoe"),
                    ResourceLocation.withDefaultNamespace("container/slot/axe"),
                    ResourceLocation.withDefaultNamespace("container/slot/sword"),
                    ResourceLocation.withDefaultNamespace("container/slot/shovel"),
                    ResourceLocation.withDefaultNamespace("container/slot/pickaxe")
            ),
            List.of(ResourceLocation.withDefaultNamespace("container/slot/ingot")),
            properties
    ));

    public static final DeferredItem<MGArrowItem> COPPER_ARROW = registerItem("copper_arrow", properties -> new MGArrowItem(properties, 1.75D, MGEntities.COPPER_ARROW.get()));
    public static final DeferredItem<MGArrowItem> BRONZE_ARROW = registerItem("bronze_arrow", properties -> new MGArrowItem(properties, 2.5D, MGEntities.BRONZE_ARROW.get()));
    public static final DeferredItem<MGArrowItem> STEEL_ARROW = registerItem("steel_arrow", properties -> new MGArrowItem(properties, 3.0D, MGEntities.STEEL_ARROW.get()));
    public static final DeferredItem<MGArrowItem> RUBY_ARROW = registerItem("ruby_arrow", properties -> new MGArrowItem(properties, 3.5D, MGEntities.RUBY_ARROW.get()));
    public static final DeferredItem<MGArrowItem> TITANIUM_ARROW = registerItem("titanium_arrow", properties -> new MGArrowItem(properties, 4.5D, MGEntities.TITANIUM_ARROW.get()));
    public static final DeferredItem<MGArrowItem> ENDERITE_ARROW = registerItem("enderite_arrow", properties -> new MGArrowItem(properties, 5.0D, MGEntities.ENDERITE_ARROW.get()));

    public static final DeferredItem<BowItem> COPPER_BOW = registerItem("copper_bow", properties -> new BowItem(properties.durability(520).enchantable(1)));
    public static final DeferredItem<BowItem> BRONZE_BOW = registerItem("bronze_bow", properties -> new BowItem(properties.durability(789).enchantable(1)));
    public static final DeferredItem<BowItem> STEEL_BOW = registerItem("steel_bow", properties -> new BowItem(properties.durability(1115).enchantable(1)));
    public static final DeferredItem<BowItem> RUBY_BOW = registerItem("ruby_bow", properties -> new BowItem(properties.durability(1442).enchantable(1)));
    public static final DeferredItem<BowItem> TITANIUM_BOW = registerItem("titanium_bow", properties -> new BowItem(properties.durability(1763).enchantable(1)));
    public static final DeferredItem<BowItem> ENDERITE_BOW = registerItem("enderite_bow", properties -> new BowItem(properties.fireResistant().durability(Integer.MAX_VALUE).enchantable(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));

    private static <T extends Item> DeferredItem<T> registerItem(String name, Function<Item.Properties, ? extends T> item){
        return ITEMS.registerItem(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
