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
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class MGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreGears.MODID);

    public static final RegistryObject<MGRawOre> RAW_TIN = registerItem("raw_tin", () -> new MGRawOre(new Item.Properties(), MGColors.TIN_COLOR));
    public static final RegistryObject<MGRawOre> RAW_RUBY = registerItem("raw_ruby", () -> new MGRawOre(new Item.Properties(), MGColors.RUBY_COLOR));
    public static final RegistryObject<MGRawOre> RAW_TITANIUM = registerItem("raw_titanium", () -> new MGRawOre(new Item.Properties(), MGColors.TITANIUM_COLOR));
    public static final RegistryObject<MGRawOre> RAW_ENDERITE = registerItem("raw_enderite", () -> new MGRawOre(new Item.Properties(), MGColors.ENDERITE_COLOR));

    public static final RegistryObject<MGIngot> TIN_INGOT = registerItem("tin_ingot", () -> new MGIngot(new Item.Properties(), MGColors.TIN_COLOR));
    public static final RegistryObject<MGIngot> BRONZE_INGOT = registerItem("bronze_ingot", () -> new MGIngot(new Item.Properties(), MGColors.BRONZE_COLOR));
    public static final RegistryObject<MGIngot> STEEL_INGOT = registerItem("steel_ingot", () -> new MGIngot(new Item.Properties(), MGColors.STEEL_COLOR));
    public static final RegistryObject<MGIngot> RUBY_INGOT = registerItem("ruby", () -> new MGIngot(new Item.Properties(), MGColors.RUBY_COLOR));
    public static final RegistryObject<MGIngot> TITANIUM_INGOT = registerItem("titanium_ingot", () -> new MGIngot(new Item.Properties(), MGColors.TITANIUM_COLOR));
    public static final RegistryObject<MGIngot> ENDERITE_INGOT = registerItem("enderite_ingot", () -> new MGIngot(new Item.Properties(), MGColors.ENDERITE_COLOR));

    public static final RegistryObject<ArmorItem> COPPER_HELMET = registerItem("copper_helmet", () -> new CopperArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = registerItem("copper_chestplate", () -> new CopperArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = registerItem("copper_leggings", () -> new CopperArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = registerItem("copper_boots", () -> new CopperArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> COPPER_SWORD = registerItem("copper_sword", () -> new SwordItem(MGToolMaterials.COPPER_TIER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = registerItem("copper_pickaxe", () -> new PickaxeItem(MGToolMaterials.COPPER_TIER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = registerItem("copper_shovel", () -> new ShovelItem(MGToolMaterials.COPPER_TIER, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<AxeItem> COPPER_AXE = registerItem("copper_axe", () -> new AxeItem(MGToolMaterials.COPPER_TIER, 7, -3.2f, new Item.Properties()));
    public static final RegistryObject<HoeItem> COPPER_HOE = registerItem("copper_hoe", () -> new HoeItem(MGToolMaterials.COPPER_TIER, -1, -1.5f, new Item.Properties()));

    public static final RegistryObject<ArmorItem> BRONZE_HELMET = registerItem("bronze_helmet", () -> new BronzeArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = registerItem("bronze_chestplate", () -> new BronzeArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = registerItem("bronze_leggings", () -> new BronzeArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = registerItem("bronze_boots", () -> new BronzeArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> BRONZE_SWORD = registerItem("bronze_sword", () -> new SwordItem(MGToolMaterials.BRONZE_TIER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = registerItem("bronze_pickaxe", () -> new BronzePickaxe(MGToolMaterials.BRONZE_TIER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = registerItem("bronze_shovel", () -> new BronzeShovel(MGToolMaterials.BRONZE_TIER, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<AxeItem> BRONZE_AXE = registerItem("bronze_axe", () -> new BronzeAxe(MGToolMaterials.BRONZE_TIER, 5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<HoeItem> BRONZE_HOE = registerItem("bronze_hoe", () -> new BronzeHoe(MGToolMaterials.BRONZE_TIER, -3, -0.5f, new Item.Properties()));


    public static final RegistryObject<ArmorItem> STEEL_HELMET = registerItem("steel_helmet", () -> new SteelArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = registerItem("steel_chestplate", () -> new SteelArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = registerItem("steel_leggings", () -> new SteelArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> STEEL_BOOTS = registerItem("steel_boots", () -> new SteelArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> STEEL_SWORD = registerItem("steel_sword", () -> new SteelSword(MGToolMaterials.STEEL_TIER, 3, -1.4F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = registerItem("steel_pickaxe", () -> new SteelPickaxe(MGToolMaterials.STEEL_TIER, 1, -1.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = registerItem("steel_shovel", () -> new SteelShovel(MGToolMaterials.STEEL_TIER, 1.5f, -2f, new Item.Properties()));
    public static final RegistryObject<AxeItem> STEEL_AXE = registerItem("steel_axe", () -> new SteelAxe(MGToolMaterials.STEEL_TIER, 6, -2f, new Item.Properties()));
    public static final RegistryObject<HoeItem> STEEL_HOE = registerItem("steel_hoe", () -> new SteelHoe(MGToolMaterials.STEEL_TIER, -2, 0.0f, new Item.Properties()));;

    public static final RegistryObject<ArmorItem> RUBY_HELMET = registerItem("ruby_helmet", () -> new RubyArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = registerItem("ruby_chestplate", () -> new RubyArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = registerItem("ruby_leggings", () -> new RubyArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = registerItem("ruby_boots", () -> new RubyArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> RUBY_SWORD = registerItem("ruby_sword", () -> new SwordItem(MGToolMaterials.RUBY_TIER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = registerItem("ruby_pickaxe", () -> new PickaxeItem(MGToolMaterials.RUBY_TIER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = registerItem("ruby_shovel", () -> new ShovelItem(MGToolMaterials.RUBY_TIER, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<AxeItem> RUBY_AXE = registerItem("ruby_axe", () -> new AxeItem(MGToolMaterials.RUBY_TIER, 4, -3.2f, new Item.Properties()));
    public static final RegistryObject<HoeItem> RUBY_HOE = registerItem("ruby_hoe", () -> new HoeItem(MGToolMaterials.RUBY_TIER, -3, 0f, new Item.Properties()));


    public static final RegistryObject<ArmorItem> TITANIUM_HELMET = registerItem("titanium_helmet", () -> new TitaniumArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", () -> new TitaniumArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> TITANIUM_LEGGINGS = registerItem("titanium_leggings", () -> new TitaniumArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> TITANIUM_BOOTS = registerItem("titanium_boots", () -> new TitaniumArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> TITANIUM_SWORD = registerItem("titanium_sword", () -> new SwordItem(MGToolMaterials.TITANIUM_TIER, 5, -1.5F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> TITANIUM_PICKAXE = registerItem("titanium_pickaxe", () -> new PickaxeItem(MGToolMaterials.TITANIUM_TIER, 2, -2f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> TITANIUM_SHOVEL = registerItem("titanium_shovel", () -> new ShovelItem(MGToolMaterials.TITANIUM_TIER, 2f, -2f, new Item.Properties()));
    public static final RegistryObject<AxeItem> TITANIUM_AXE = registerItem("titanium_axe", () -> new AxeItem(MGToolMaterials.TITANIUM_TIER, 6, -2.2f, new Item.Properties()));
    public static final RegistryObject<HoeItem> TITANIUM_HOE = registerItem("titanium_hoe", () -> new HoeItem(MGToolMaterials.TITANIUM_TIER, -2, 0.0f, new Item.Properties()));


    public static final RegistryObject<ArmorItem> ENDERITE_HELMET = registerItem("enderite_helmet", () -> new EnderiteArmor(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", () -> new EnderiteArmor(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = registerItem("enderite_leggings", () -> new EnderiteArmor(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = registerItem("enderite_boots", () -> new EnderiteArmor(ArmorItem.Type.BOOTS));

    public static final RegistryObject<SwordItem> ENDERITE_SWORD = registerItem("enderite_sword", () -> new SwordItem(MGToolMaterials.ENDERITE_TIER, 8, -1F, new Item.Properties().fireResistant()){
        @Override
        public boolean isDamageable(ItemStack stack) {
            return false;
        }

        @Override
        public boolean isEnchantable(ItemStack p_41456_) {
            return true;
        }
    });
    public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = registerItem("enderite_pickaxe", () -> new PickaxeItem(MGToolMaterials.ENDERITE_TIER, 4, -1.3f, new Item.Properties().fireResistant()){
        @Override
        public boolean isDamageable(ItemStack stack) {
            return false;
        }

        @Override
        public boolean isEnchantable(ItemStack p_41456_) {
            return true;
        }
    });
    public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = registerItem("enderite_shovel", () -> new ShovelItem(MGToolMaterials.ENDERITE_TIER, 3.5f, -1.8f, new Item.Properties().fireResistant()){
        @Override
        public boolean isDamageable(ItemStack stack) {
            return false;
        }

        @Override
        public boolean isEnchantable(ItemStack p_41456_) {
            return true;
        }
    });
    public static final RegistryObject<AxeItem> ENDERITE_AXE = registerItem("enderite_axe", () -> new AxeItem(MGToolMaterials.ENDERITE_TIER, 9, -1.5f, new Item.Properties().fireResistant()){
        @Override
        public boolean isDamageable(ItemStack stack) {
            return false;
        }

        @Override
        public boolean isEnchantable(ItemStack p_41456_) {
            return true;
        }
    });
    public static final RegistryObject<HoeItem> ENDERITE_HOE = registerItem("enderite_hoe", () -> new HoeItem(MGToolMaterials.ENDERITE_TIER, -1, 0.0f, new Item.Properties().fireResistant()){
        @Override
        public boolean isDamageable(ItemStack stack) {
            return false;
        }

        @Override
        public boolean isEnchantable(ItemStack p_41456_) {
            return true;
        }
    });


    public static final RegistryObject<SmithingTemplateItem> TITANIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("titanium_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.literal("Netherite Equipment").withStyle(ChatFormatting.BLUE),
            Component.literal("Titanium Ingot").withStyle(ChatFormatting.BLUE),
            Component.literal("Titanium Upgrade").withStyle(ChatFormatting.GRAY),
            Component.literal("Add Netherite Armor, Weapon, or Tool"),
            Component.literal("Add Titanium Ingot"),
            List.of(
                    new ResourceLocation("item/empty_armor_slot_helmet"),
                    new ResourceLocation("item/empty_armor_slot_chestplate"),
                    new ResourceLocation("item/empty_armor_slot_leggings"),
                    new ResourceLocation("item/empty_armor_slot_boots"),
                    new ResourceLocation("item/empty_slot_hoe"),
                    new ResourceLocation("item/empty_slot_axe"),
                    new ResourceLocation("item/empty_slot_sword"),
                    new ResourceLocation("item/empty_slot_shovel"),
                    new ResourceLocation("item/empty_slot_pickaxe")
            ),
            List.of(new ResourceLocation("item/empty_slot_ingot"))
    ));

    public static final RegistryObject<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.literal("Titanium Equipment").withStyle(ChatFormatting.BLUE),
            Component.literal("Enderite Ingot").withStyle(ChatFormatting.BLUE),
            Component.literal("Enderite Upgrade").withStyle(ChatFormatting.GRAY),
            Component.literal("Add Titanium Armor, Weapon, or Tool"),
            Component.literal("Add Enderite Ingot"),
            List.of(
                    new ResourceLocation("item/empty_armor_slot_helmet"),
                    new ResourceLocation("item/empty_armor_slot_chestplate"),
                    new ResourceLocation("item/empty_armor_slot_leggings"),
                    new ResourceLocation("item/empty_armor_slot_boots"),
                    new ResourceLocation("item/empty_slot_hoe"),
                    new ResourceLocation("item/empty_slot_axe"),
                    new ResourceLocation("item/empty_slot_sword"),
                    new ResourceLocation("item/empty_slot_shovel"),
                    new ResourceLocation("item/empty_slot_pickaxe")
            ),
            List.of(new ResourceLocation("item/empty_slot_ingot"))
    ));

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item){
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
