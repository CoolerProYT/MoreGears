package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
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
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class MGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreGears.MODID);

    public static final DeferredItem<MGRawOre> RAW_TIN = registerItem("raw_tin", () -> new MGRawOre(new Item.Properties(), MGColors.TIN_COLOR));
    public static final DeferredItem<MGRawOre> RAW_RUBY = registerItem("raw_ruby", () -> new MGRawOre(new Item.Properties(), MGColors.RUBY_COLOR));
    public static final DeferredItem<MGRawOre> RAW_TITANIUM = registerItem("raw_titanium", () -> new MGRawOre(new Item.Properties(), MGColors.TITANIUM_COLOR));
    public static final DeferredItem<MGRawOre> RAW_ENDERITE = registerItem("raw_enderite", () -> new MGRawOre(new Item.Properties(), MGColors.ENDERITE_COLOR));

    public static final DeferredItem<MGIngot> TIN_INGOT = registerItem("tin_ingot", () -> new MGIngot(new Item.Properties(), MGColors.TIN_COLOR));
    public static final DeferredItem<MGIngot> BRONZE_INGOT = registerItem("bronze_ingot", () -> new MGIngot(new Item.Properties(), MGColors.BRONZE_COLOR));
    public static final DeferredItem<MGIngot> STEEL_INGOT = registerItem("steel_ingot", () -> new MGIngot(new Item.Properties(), MGColors.STEEL_COLOR));
    public static final DeferredItem<MGIngot> RUBY_INGOT = registerItem("ruby", () -> new MGIngot(new Item.Properties(), MGColors.RUBY_COLOR));
    public static final DeferredItem<MGIngot> TITANIUM_INGOT = registerItem("titanium_ingot", () -> new MGIngot(new Item.Properties(), MGColors.TITANIUM_COLOR));
    public static final DeferredItem<MGIngot> ENDERITE_INGOT = registerItem("enderite_ingot", () -> new MGIngot(new Item.Properties(), MGColors.ENDERITE_COLOR));

    public static final DeferredItem<ArmorItem> COPPER_HELMET = registerItem("copper_helmet", () -> new CopperArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE = registerItem("copper_chestplate", () -> new CopperArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> COPPER_LEGGINGS = registerItem("copper_leggings", () -> new CopperArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> COPPER_BOOTS = registerItem("copper_boots", () -> new CopperArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> COPPER_SWORD = registerItem("copper_sword", () -> new SwordItem(MGToolMaterials.COPPER_TIER, new Item.Properties().attributes(SwordItem.createAttributes(MGToolMaterials.COPPER_TIER, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = registerItem("copper_pickaxe", () -> new PickaxeItem(MGToolMaterials.COPPER_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(MGToolMaterials.COPPER_TIER, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = registerItem("copper_shovel", () -> new ShovelItem(MGToolMaterials.COPPER_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(MGToolMaterials.COPPER_TIER, 1.5f, -3f))));
    public static final DeferredItem<AxeItem> COPPER_AXE = registerItem("copper_axe", () -> new AxeItem(MGToolMaterials.COPPER_TIER, new Item.Properties().attributes(AxeItem.createAttributes(MGToolMaterials.COPPER_TIER, 7, -3.2f))));
    public static final DeferredItem<HoeItem> COPPER_HOE = registerItem("copper_hoe", () -> new HoeItem(MGToolMaterials.COPPER_TIER, new Item.Properties().attributes(HoeItem.createAttributes(MGToolMaterials.COPPER_TIER, -1f, -1.5f))));

    public static final DeferredItem<ArmorItem> BRONZE_HELMET = registerItem("bronze_helmet", () -> new BronzeArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> BRONZE_CHESTPLATE = registerItem("bronze_chestplate", () -> new BronzeArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> BRONZE_LEGGINGS = registerItem("bronze_leggings", () -> new BronzeArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> BRONZE_BOOTS = registerItem("bronze_boots", () -> new BronzeArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> BRONZE_SWORD = registerItem("bronze_sword", () -> new SwordItem(MGToolMaterials.BRONZE_TIER, new Item.Properties().attributes(SwordItem.createAttributes(MGToolMaterials.BRONZE_TIER, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> BRONZE_PICKAXE = registerItem("bronze_pickaxe", () -> new BronzePickaxe(MGToolMaterials.BRONZE_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(MGToolMaterials.BRONZE_TIER, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> BRONZE_SHOVEL = registerItem("bronze_shovel", () -> new BronzeShovel(MGToolMaterials.BRONZE_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(MGToolMaterials.BRONZE_TIER, 1.5f, -3f))));
    public static final DeferredItem<AxeItem> BRONZE_AXE = registerItem("bronze_axe", () -> new BronzeAxe(MGToolMaterials.BRONZE_TIER, new Item.Properties().attributes(AxeItem.createAttributes(MGToolMaterials.BRONZE_TIER, 5.5f, -3.0f))));
    public static final DeferredItem<HoeItem> BRONZE_HOE = registerItem("bronze_hoe", () -> new BronzeHoe(MGToolMaterials.BRONZE_TIER, new Item.Properties().attributes(HoeItem.createAttributes(MGToolMaterials.BRONZE_TIER, -2.5f, -0.5f))));

    public static final DeferredItem<ArmorItem> STEEL_HELMET = registerItem("steel_helmet", () -> new SteelArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> STEEL_CHESTPLATE = registerItem("steel_chestplate", () -> new SteelArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> STEEL_LEGGINGS = registerItem("steel_leggings", () -> new SteelArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> STEEL_BOOTS = registerItem("steel_boots", () -> new SteelArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> STEEL_SWORD = registerItem("steel_sword", () -> new SteelSword(MGToolMaterials.STEEL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(MGToolMaterials.STEEL_TIER, 3, -1.4F))));
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE = registerItem("steel_pickaxe", () -> new SteelPickaxe(MGToolMaterials.STEEL_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(MGToolMaterials.STEEL_TIER, 1, -1.8f))));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = registerItem("steel_shovel", () -> new SteelShovel(MGToolMaterials.STEEL_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(MGToolMaterials.STEEL_TIER, 1.5f, -2f))));
    public static final DeferredItem<AxeItem> STEEL_AXE = registerItem("steel_axe", () -> new SteelAxe(MGToolMaterials.STEEL_TIER, new Item.Properties().attributes(AxeItem.createAttributes(MGToolMaterials.STEEL_TIER, 6, -2f))));
    public static final DeferredItem<HoeItem> STEEL_HOE = registerItem("steel_hoe", () -> new SteelHoe(MGToolMaterials.STEEL_TIER, new Item.Properties().attributes(HoeItem.createAttributes(MGToolMaterials.STEEL_TIER, -2f, 0.0f))));

    public static final DeferredItem<ArmorItem> RUBY_HELMET = registerItem("ruby_helmet", () -> new RubyArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> RUBY_CHESTPLATE = registerItem("ruby_chestplate", () -> new RubyArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> RUBY_LEGGINGS = registerItem("ruby_leggings", () -> new RubyArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> RUBY_BOOTS = registerItem("ruby_boots", () -> new RubyArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> RUBY_SWORD = registerItem("ruby_sword", () -> new SwordItem(MGToolMaterials.RUBY_TIER, new Item.Properties().attributes(SwordItem.createAttributes(MGToolMaterials.RUBY_TIER, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> RUBY_PICKAXE = registerItem("ruby_pickaxe", () -> new PickaxeItem(MGToolMaterials.RUBY_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(MGToolMaterials.RUBY_TIER, 1f, -2.8f))));
    public static final DeferredItem<ShovelItem> RUBY_SHOVEL = registerItem("ruby_shovel", () -> new ShovelItem(MGToolMaterials.RUBY_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(MGToolMaterials.RUBY_TIER, 1.5f, -3f))));
    public static final DeferredItem<AxeItem> RUBY_AXE = registerItem("ruby_axe", () -> new AxeItem(MGToolMaterials.RUBY_TIER, new Item.Properties().attributes(AxeItem.createAttributes(MGToolMaterials.RUBY_TIER, 4, -3.2f))));
    public static final DeferredItem<HoeItem> RUBY_HOE = registerItem("ruby_hoe", () -> new HoeItem(MGToolMaterials.RUBY_TIER, new Item.Properties().attributes(HoeItem.createAttributes(MGToolMaterials.RUBY_TIER, -3f, 0f))));

    public static final DeferredItem<ArmorItem> TITANIUM_HELMET = registerItem("titanium_helmet", () -> new TitaniumArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", () -> new TitaniumArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> TITANIUM_LEGGINGS = registerItem("titanium_leggings", () -> new TitaniumArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> TITANIUM_BOOTS = registerItem("titanium_boots", () -> new TitaniumArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> TITANIUM_SWORD = registerItem("titanium_sword", () -> new SwordItem(MGToolMaterials.TITANIUM_TIER, new Item.Properties().attributes(SwordItem.createAttributes(MGToolMaterials.TITANIUM_TIER, 5, -1.5F))));
    public static final DeferredItem<PickaxeItem> TITANIUM_PICKAXE = registerItem("titanium_pickaxe", () -> new PickaxeItem(MGToolMaterials.TITANIUM_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(MGToolMaterials.TITANIUM_TIER, 2, -2f))));
    public static final DeferredItem<ShovelItem> TITANIUM_SHOVEL = registerItem("titanium_shovel", () -> new ShovelItem(MGToolMaterials.TITANIUM_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(MGToolMaterials.TITANIUM_TIER, 2f, -2f))));
    public static final DeferredItem<AxeItem> TITANIUM_AXE = registerItem("titanium_axe", () -> new AxeItem(MGToolMaterials.TITANIUM_TIER, new Item.Properties().attributes(AxeItem.createAttributes(MGToolMaterials.TITANIUM_TIER, 6, -2.2f))));
    public static final DeferredItem<HoeItem> TITANIUM_HOE = registerItem("titanium_hoe", () -> new HoeItem(MGToolMaterials.TITANIUM_TIER, new Item.Properties().attributes(HoeItem.createAttributes(MGToolMaterials.TITANIUM_TIER, -2f, 0.0f))));

    public static final DeferredItem<ArmorItem> ENDERITE_HELMET = registerItem("enderite_helmet", () -> new EnderiteArmor(ArmorItem.Type.HELMET));
    public static final DeferredItem<ArmorItem> ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", () -> new EnderiteArmor(ArmorItem.Type.CHESTPLATE));
    public static final DeferredItem<ArmorItem> ENDERITE_LEGGINGS = registerItem("enderite_leggings", () -> new EnderiteArmor(ArmorItem.Type.LEGGINGS));
    public static final DeferredItem<ArmorItem> ENDERITE_BOOTS = registerItem("enderite_boots", () -> new EnderiteArmor(ArmorItem.Type.BOOTS));

    public static final DeferredItem<SwordItem> ENDERITE_SWORD = registerItem("enderite_sword",
            () -> new SwordItem(MGToolMaterials.ENDERITE_TIER, new Item.Properties().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(SwordItem.createAttributes(MGToolMaterials.ENDERITE_TIER, 8, -1F))));
    public static final DeferredItem<PickaxeItem> ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
            () -> new PickaxeItem(MGToolMaterials.ENDERITE_TIER, new Item.Properties().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(PickaxeItem.createAttributes(MGToolMaterials.ENDERITE_TIER, 4, -1.3f))));
    public static final DeferredItem<ShovelItem> ENDERITE_SHOVEL = registerItem("enderite_shovel",
            () -> new ShovelItem(MGToolMaterials.ENDERITE_TIER, new Item.Properties().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(ShovelItem.createAttributes(MGToolMaterials.ENDERITE_TIER, 3.5f, -1.8f))));
    public static final DeferredItem<AxeItem> ENDERITE_AXE = registerItem("enderite_axe",
            () -> new AxeItem(MGToolMaterials.ENDERITE_TIER, new Item.Properties().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(AxeItem.createAttributes(MGToolMaterials.ENDERITE_TIER, 9, -1.5f))));
    public static final DeferredItem<HoeItem> ENDERITE_HOE = registerItem("enderite_hoe",
            () -> new HoeItem(MGToolMaterials.ENDERITE_TIER, new Item.Properties().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(HoeItem.createAttributes(MGToolMaterials.ENDERITE_TIER, -1f, 0.0f))));

    public static final DeferredItem<SmithingTemplateItem> TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.literal("Netherite Equipment").withStyle(ChatFormatting.BLUE),
            Component.literal("Titanium Ingot").withStyle(ChatFormatting.BLUE),
            Component.literal("Titanium Upgrade").withStyle(ChatFormatting.GRAY),
            Component.literal("Add Netherite Armor, Weapon, or Tool"),
            Component.literal("Add Titanium Ingot"),
            List.of(
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe")
            ),
            List.of(ResourceLocation.withDefaultNamespace("item/empty_slot_ingot"))
    ));

    public static final DeferredItem<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.literal("Titanium Equipment").withStyle(ChatFormatting.BLUE),
            Component.literal("Enderite Ingot").withStyle(ChatFormatting.BLUE),
            Component.literal("Enderite Upgrade").withStyle(ChatFormatting.GRAY),
            Component.literal("Add Titanium Armor, Weapon, or Tool"),
            Component.literal("Add Enderite Ingot"),
            List.of(
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe")
            ),
            List.of(ResourceLocation.withDefaultNamespace("item/empty_slot_ingot"))
    ));

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item){
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
