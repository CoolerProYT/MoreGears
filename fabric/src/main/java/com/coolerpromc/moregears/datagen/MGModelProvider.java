package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.property.Arrow;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.color.item.Dye;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.data.models.ItemModelGenerators.*;

public class MGModelProvider extends FabricModelProvider {
    public static final List<TrimMaterialData> TRIM_MATERIAL_MODELS = List.of(
            new TrimMaterialData(MaterialAssetGroup.QUARTZ, TrimMaterials.QUARTZ),
            new TrimMaterialData(MaterialAssetGroup.IRON, TrimMaterials.IRON),
            new TrimMaterialData(MaterialAssetGroup.NETHERITE, TrimMaterials.NETHERITE),
            new TrimMaterialData(MaterialAssetGroup.REDSTONE, TrimMaterials.REDSTONE),
            new TrimMaterialData(MaterialAssetGroup.COPPER, TrimMaterials.COPPER),
            new TrimMaterialData(MaterialAssetGroup.GOLD, TrimMaterials.GOLD),
            new TrimMaterialData(MaterialAssetGroup.EMERALD, TrimMaterials.EMERALD),
            new TrimMaterialData(MaterialAssetGroup.DIAMOND, TrimMaterials.DIAMOND),
            new TrimMaterialData(MaterialAssetGroup.LAPIS, TrimMaterials.LAPIS),
            new TrimMaterialData(MaterialAssetGroup.AMETHYST, TrimMaterials.AMETHYST),
            new TrimMaterialData(MaterialAssetGroup.RESIN, TrimMaterials.RESIN),
            new TrimMaterialData(MGTrimMaterials.TIN_ASSET_GROUP, MGTrimMaterials.TIN),
            new TrimMaterialData(MGTrimMaterials.BRONZE_ASSET_GROUP, MGTrimMaterials.BRONZE),
            new TrimMaterialData(MGTrimMaterials.STEEL_ASSET_GROUP, MGTrimMaterials.STEEL),
            new TrimMaterialData(MGTrimMaterials.RUBY_ASSET_GROUP, MGTrimMaterials.RUBY),
            new TrimMaterialData(MGTrimMaterials.TITANIUM_ASSET_GROUP, MGTrimMaterials.TITANIUM),
            new TrimMaterialData(MGTrimMaterials.ENDERITE_ASSET_GROUP, MGTrimMaterials.ENDERITE)
    );

    public static final Identifier MOD_TRIM_PREFIX_HELMET = Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/helmet_trim");
    public static final Identifier MOD_TRIM_PREFIX_CHESTPLATE = Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/chestplate_trim");
    public static final Identifier MOD_TRIM_PREFIX_LEGGINGS = Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/leggings_trim");
    public static final Identifier MOD_TRIM_PREFIX_BOOTS = Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/boots_trim");

    public MGModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.TIN_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.DEEPSLATE_TIN_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.RUBY_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.DEEPSLATE_RUBY_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.NETHER_TITANIUM_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.END_ENDERITE_ORE);

        horizontalRotationBlock(blockStateModelGenerator, MGBlocks.ALLOY_SMELTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        basicItem(itemModelGenerator, MGItems.RAW_TIN);
        basicItem(itemModelGenerator, MGItems.RAW_RUBY);
        basicItem(itemModelGenerator, MGItems.RAW_TITANIUM);
        basicItem(itemModelGenerator, MGItems.RAW_ENDERITE);

        basicItem(itemModelGenerator, MGItems.TITANIUM_NUGGET);

        basicItem(itemModelGenerator, MGItems.TIN_INGOT);
        basicItem(itemModelGenerator, MGItems.BRONZE_INGOT);
        basicItem(itemModelGenerator, MGItems.STEEL_INGOT);
        basicItem(itemModelGenerator, MGItems.RUBY_INGOT);
        basicItem(itemModelGenerator, MGItems.TITANIUM_INGOT);
        basicItem(itemModelGenerator, MGItems.ENDERITE_INGOT);

        trimmedArmorItem(itemModelGenerator, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, true);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.COPPER_HELMET, EquipmentAssets.COPPER, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.COPPER_BOOTS, EquipmentAssets.COPPER, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_HELMET, EquipmentAssets.IRON, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_LEGGINGS, EquipmentAssets.IRON, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_BOOTS, EquipmentAssets.IRON, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);

        trimmedArmorItem(itemModelGenerator, MGItems.BRONZE_HELMET, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.BRONZE_CHESTPLATE, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.BRONZE_LEGGINGS, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.BRONZE_BOOTS, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);

        trimmedArmorItem(itemModelGenerator, MGItems.STEEL_HELMET, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.STEEL_CHESTPLATE, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.STEEL_LEGGINGS, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.STEEL_BOOTS, MGArmorMaterials.STEEL_ARMOR_MATERIAL);

        trimmedArmorItem(itemModelGenerator, MGItems.RUBY_HELMET, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.RUBY_CHESTPLATE, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.RUBY_LEGGINGS, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.RUBY_BOOTS, MGArmorMaterials.RUBY_ARMOR_MATERIAL);

        trimmedArmorItem(itemModelGenerator, MGItems.TITANIUM_HELMET, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.TITANIUM_CHESTPLATE, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.TITANIUM_LEGGINGS, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.TITANIUM_BOOTS, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);

        trimmedArmorItem(itemModelGenerator, MGItems.ENDERITE_HELMET, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.ENDERITE_CHESTPLATE, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.ENDERITE_LEGGINGS, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.ENDERITE_BOOTS, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);

        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(MGItems.BRONZE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.BRONZE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.BRONZE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.BRONZE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.BRONZE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(MGItems.BRONZE_SPEAR);

        itemModelGenerator.generateFlatItem(MGItems.STEEL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.STEEL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.STEEL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.STEEL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.STEEL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(MGItems.STEEL_SPEAR);

        itemModelGenerator.generateFlatItem(MGItems.RUBY_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.RUBY_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.RUBY_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.RUBY_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.RUBY_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(MGItems.RUBY_SPEAR);

        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.TITANIUM_MACE, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);
        itemModelGenerator.generateSpear(MGItems.TITANIUM_SPEAR);

        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(MGItems.ENDERITE_MACE, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);
        itemModelGenerator.generateSpear(MGItems.ENDERITE_SPEAR);

        basicItem(itemModelGenerator, MGItems.COPPER_ARROW);
        basicItem(itemModelGenerator, MGItems.BRONZE_ARROW);
        basicItem(itemModelGenerator, MGItems.STEEL_ARROW);
        basicItem(itemModelGenerator, MGItems.RUBY_ARROW);
        basicItem(itemModelGenerator, MGItems.TITANIUM_ARROW);
        basicItem(itemModelGenerator, MGItems.ENDERITE_ARROW);

        generateBow(itemModelGenerator, Items.BOW);
        generateBow(itemModelGenerator, MGItems.COPPER_BOW);
        generateBow(itemModelGenerator, MGItems.BRONZE_BOW);
        generateBow(itemModelGenerator, MGItems.STEEL_BOW);
        generateBow(itemModelGenerator, MGItems.RUBY_BOW);
        generateBow(itemModelGenerator, MGItems.TITANIUM_BOW);
        generateBow(itemModelGenerator, MGItems.ENDERITE_BOW);
    }

    private void basicItem(ItemModelGenerators itemModels, Item item) {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }

    private void trimmedArmorItem(ItemModelGenerators itemModels, MGArmorItem item, ArmorMaterial armorMaterial){
        generateTrimmableItem(itemModels, item, armorMaterial.assetId(), Identifier.parse("trims/items/" + item.getType().getName() + "_trim"), Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/" + item.getType().getName() + "_trim"), false);
    }

    private void trimmedArmorItem(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentAsset, Identifier Identifier, Identifier Identifier2, boolean tint) {
        generateTrimmableItem(itemModels, item, equipmentAsset, Identifier, Identifier2, false);
    }

    public void generateTrimmableItem(ItemModelGenerators itemModels, Item armorItem, ResourceKey<EquipmentAsset> equipmentAsset, Identifier vanillaTrimLocation, Identifier modTrimLocation, boolean tint) {
        Identifier Identifier = ModelLocationUtils.getModelLocation(armorItem);
        Material Identifier1 = TextureMapping.getItemTexture(armorItem);
        Material Identifier2 = TextureMapping.getItemTexture(armorItem, "_overlay");
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> list = new ArrayList<>(TRIM_MATERIAL_MODELS.size());

        for (TrimMaterialData trimMaterialData : TRIM_MATERIAL_MODELS) {
            Identifier Identifier3 = Identifier.withSuffix("_" + trimMaterialData.assets().base().suffix() + "_trim");
            Material Identifier4 = new Material(MGTrimMaterials.TRIM_MATERIALS.contains(trimMaterialData.assets())
                    ? modTrimLocation.withSuffix("_" + trimMaterialData.assets().assetId(equipmentAsset).suffix())
                    : vanillaTrimLocation.withSuffix("_" + trimMaterialData.assets().assetId(equipmentAsset).suffix()));
            ItemModel.Unbaked itemmodel$unbaked;
            if (tint) {
                itemModels.generateLayeredItem(Identifier3, Identifier1, Identifier2, Identifier4);
                itemmodel$unbaked = ItemModelUtils.tintedModel(Identifier3, new Dye(-6265536));
            } else {
                itemModels.generateLayeredItem(Identifier3, Identifier1, Identifier4);
                itemmodel$unbaked = ItemModelUtils.plainModel(Identifier3);
            }

            list.add(ItemModelUtils.when(trimMaterialData.materialKey(), itemmodel$unbaked));

        }

        ItemModel.Unbaked itemmodel$unbaked1;
        if (tint) {
            ModelTemplates.TWO_LAYERED_ITEM.create(Identifier, TextureMapping.layered(Identifier1, Identifier2), itemModels.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.tintedModel(Identifier, new Dye(-6265536));
        } else {
            ModelTemplates.FLAT_ITEM.create(Identifier, TextureMapping.layer0(Identifier1), itemModels.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.plainModel(Identifier);
        }

        itemModels.itemModelOutput.accept(armorItem, ItemModelUtils.select(new TrimMaterialProperty(), itemmodel$unbaked1, list));

    }
    
    private <T extends Block> void simpleBlockWithItem(BlockModelGenerators blockStateModelGenerator, T block){
        blockStateModelGenerator.createTrivialCube(block);
    }

    private <T extends Block> void horizontalRotationBlock(BlockModelGenerators blockStateModelGenerator, T block){
        blockStateModelGenerator.createNonTemplateHorizontalBlock(block);
    }

    public void generateBow(ItemModelGenerators itemModels, Item bowItem) {
        ItemModel.Unbaked baseModel;

        if (bowItem == Items.BOW) {
            baseModel = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(bowItem));
        }
        else{
            baseModel = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "", ModelTemplates.BOW));
        }

        ItemModel.Unbaked basePulling0 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked basePulling1 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked basePulling2 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked bronzePulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked bronzePulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked bronzePulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked copperPulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked copperPulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked copperPulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked enderitePulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked enderitePulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked enderitePulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked rubyPulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked rubyPulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked rubyPulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked steelPulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked steelPulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked steelPulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_2", ModelTemplates.BOW));

        ItemModel.Unbaked titaniumPulling0 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked titaniumPulling1 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked titaniumPulling2 = ItemModelUtils.plainModel(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_2", ModelTemplates.BOW));

        itemModels.itemModelOutput.accept(
                bowItem,
                ItemModelUtils.select(
                        new Arrow(),
                        ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, basePulling0, ItemModelUtils.override(basePulling1, 0.65F), ItemModelUtils.override(basePulling2, 0.9F)), baseModel),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.BRONZE,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, bronzePulling0, ItemModelUtils.override(bronzePulling1, 0.65F), ItemModelUtils.override(bronzePulling2, 0.9F)), baseModel)
                        ),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.COPPER,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, copperPulling0, ItemModelUtils.override(copperPulling1, 0.65F), ItemModelUtils.override(copperPulling2, 0.9F)), baseModel)
                        ),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.ENDERITE,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, enderitePulling0, ItemModelUtils.override(enderitePulling1, 0.65F), ItemModelUtils.override(enderitePulling2, 0.9F)), baseModel)
                        ),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.RUBY,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, rubyPulling0, ItemModelUtils.override(rubyPulling1, 0.65F), ItemModelUtils.override(rubyPulling2, 0.9F)), baseModel)
                        ),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.STEEL,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, steelPulling0, ItemModelUtils.override(steelPulling1, 0.65F), ItemModelUtils.override(steelPulling2, 0.9F)), baseModel)
                        ),
                        ItemModelUtils.when(
                                MGArrowItem.MGArrowType.TITANIUM,
                                ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.05F, titaniumPulling0, ItemModelUtils.override(titaniumPulling1, 0.65F), ItemModelUtils.override(titaniumPulling2, 0.9F)), baseModel)
                        )
                )
        );
    }

    public Identifier createFlatItemModel(ItemModelGenerators itemModels, Item item, String suffix, ModelTemplate modelTemplate) {
        return modelTemplate.create(getModelLocation(item, suffix), TextureMapping.layer0(new Material(getModelLocation(item, suffix))), itemModels.modelOutput);
    }

    public Identifier getModelLocation(Item item, String suffix) {
        Identifier resourcelocation = Identifier.fromNamespaceAndPath(MoreGears.MODID, getItemName(item));
        return resourcelocation.withPath((p_386751_) -> "item/" + p_386751_ + suffix);
    }

    public String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    private Identifier textureLoc(String location){
        return Identifier.fromNamespaceAndPath(MoreGears.MODID, "block/" + location);
    }

    private Identifier itemTextureLoc(String location){
        return Identifier.fromNamespaceAndPath(MoreGears.MODID, "item/" + location);
    }
}
