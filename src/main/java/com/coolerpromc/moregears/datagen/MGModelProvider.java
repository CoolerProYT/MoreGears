package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.datagen.property.Arrow;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.BasicItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.model.SelectItemModel;
import net.minecraft.client.render.item.property.numeric.UseDurationProperty;
import net.minecraft.client.render.item.property.select.TrimMaterialProperty;
import net.minecraft.client.render.item.tint.DyeTintSource;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.data.ItemModelGenerator.*;

public class MGModelProvider extends FabricModelProvider {
    public static final List<ItemModelGenerator.TrimMaterial> TRIM_MATERIAL_MODELS = List.of(
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.QUARTZ, ArmorTrimMaterials.QUARTZ),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.IRON, ArmorTrimMaterials.IRON),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.NETHERITE, ArmorTrimMaterials.NETHERITE),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.REDSTONE, ArmorTrimMaterials.REDSTONE),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.COPPER, ArmorTrimMaterials.COPPER),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.GOLD, ArmorTrimMaterials.GOLD),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.EMERALD, ArmorTrimMaterials.EMERALD),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.DIAMOND, ArmorTrimMaterials.DIAMOND),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.LAPIS, ArmorTrimMaterials.LAPIS),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.AMETHYST, ArmorTrimMaterials.AMETHYST),
            new ItemModelGenerator.TrimMaterial(ArmorTrimAssets.RESIN, ArmorTrimMaterials.RESIN),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.TIN_ASSET_GROUP, MGTrimMaterials.TIN),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.BRONZE_ASSET_GROUP, MGTrimMaterials.BRONZE),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.STEEL_ASSET_GROUP, MGTrimMaterials.STEEL),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.RUBY_ASSET_GROUP, MGTrimMaterials.RUBY),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.TITANIUM_ASSET_GROUP, MGTrimMaterials.TITANIUM),
            new ItemModelGenerator.TrimMaterial(MGTrimMaterials.ENDERITE_ASSET_GROUP, MGTrimMaterials.ENDERITE)
    );

    public static final Identifier MOD_TRIM_PREFIX_HELMET = Identifier.of(MoreGears.MODID, "item/helmet_trim");
    public static final Identifier MOD_TRIM_PREFIX_CHESTPLATE = Identifier.of(MoreGears.MODID, "item/chestplate_trim");
    public static final Identifier MOD_TRIM_PREFIX_LEGGINGS = Identifier.of(MoreGears.MODID, "item/leggings_trim");
    public static final Identifier MOD_TRIM_PREFIX_BOOTS = Identifier.of(MoreGears.MODID, "item/boots_trim");

    public MGModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.TIN_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.DEEPSLATE_TIN_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.RUBY_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.DEEPSLATE_RUBY_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.NETHER_TITANIUM_ORE);
        simpleBlockWithItem(blockStateModelGenerator, MGBlocks.END_ENDERITE_ORE);

        horizontalRotationBlock(blockStateModelGenerator, MGBlocks.ALLOY_SMELTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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

        trimmedArmorItem(itemModelGenerator, Items.TURTLE_HELMET, EquipmentAssetKeys.TURTLE_SCUTE, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_HELMET, EquipmentAssetKeys.LEATHER, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_CHESTPLATE, EquipmentAssetKeys.LEATHER, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_LEGGINGS, EquipmentAssetKeys.LEATHER, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, true);
        trimmedArmorItem(itemModelGenerator, Items.LEATHER_BOOTS, EquipmentAssetKeys.LEATHER, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, true);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_HELMET, EquipmentAssetKeys.CHAINMAIL, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssetKeys.CHAINMAIL, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_LEGGINGS, EquipmentAssetKeys.CHAINMAIL, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.CHAINMAIL_BOOTS, EquipmentAssetKeys.CHAINMAIL, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_HELMET, EquipmentAssetKeys.IRON, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_CHESTPLATE, EquipmentAssetKeys.IRON, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_LEGGINGS, EquipmentAssetKeys.IRON, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.IRON_BOOTS, EquipmentAssetKeys.IRON, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_HELMET, EquipmentAssetKeys.DIAMOND, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_CHESTPLATE, EquipmentAssetKeys.DIAMOND, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_LEGGINGS, EquipmentAssetKeys.DIAMOND, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.DIAMOND_BOOTS, EquipmentAssetKeys.DIAMOND, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_HELMET, EquipmentAssetKeys.GOLD, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_CHESTPLATE, EquipmentAssetKeys.GOLD, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_LEGGINGS, EquipmentAssetKeys.GOLD, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.GOLDEN_BOOTS, EquipmentAssetKeys.GOLD, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_HELMET, EquipmentAssetKeys.NETHERITE, HELMET_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_CHESTPLATE, EquipmentAssetKeys.NETHERITE, CHESTPLATE_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_LEGGINGS, EquipmentAssetKeys.NETHERITE, LEGGINGS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModelGenerator, Items.NETHERITE_BOOTS, EquipmentAssetKeys.NETHERITE, BOOTS_TRIM_ID_PREFIX, MOD_TRIM_PREFIX_BOOTS, false);

        trimmedArmorItem(itemModelGenerator, MGItems.COPPER_HELMET, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.COPPER_CHESTPLATE, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.COPPER_LEGGINGS, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModelGenerator, MGItems.COPPER_BOOTS, MGArmorMaterials.COPPER_ARMOR_MATERIAL);

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

        itemModelGenerator.register(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(MGItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.register(MGItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.BRONZE_HOE, Models.HANDHELD);

        itemModelGenerator.register(MGItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.STEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(MGItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.RUBY_HOE, Models.HANDHELD);

        itemModelGenerator.register(MGItems.TITANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.TITANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.TITANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.TITANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.TITANIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(MGItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MGItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MGItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(MGItems.ENDERITE_HOE, Models.HANDHELD);

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

    private void basicItem(ItemModelGenerator itemModels, Item item) {
        itemModels.register(item, Models.GENERATED);
    }

    private void trimmedArmorItem(ItemModelGenerator itemModels, MGArmorItem item, ArmorMaterial armorMaterial){
        generateTrimmableItem(itemModels, item, armorMaterial.assetId(), Identifier.of("trims/items/" + item.getType().getName() + "_trim"), Identifier.of(MoreGears.MODID, "item/" + item.getType().getName() + "_trim"), false);
    }

    private void trimmedArmorItem(ItemModelGenerator itemModels, Item item, RegistryKey<EquipmentAsset> equipmentAsset, Identifier Identifier, Identifier Identifier2, boolean tint) {
        generateTrimmableItem(itemModels, item, equipmentAsset, Identifier, Identifier2, false);
    }

    public void generateTrimmableItem(ItemModelGenerator itemModels, Item armorItem, RegistryKey<EquipmentAsset> equipmentAsset, Identifier vanillaTrimLocation, Identifier modTrimLocation, boolean tint) {
        Identifier Identifier = ModelIds.getItemModelId(armorItem);
        Identifier Identifier1 = TextureMap.getId(armorItem);
        Identifier Identifier2 = TextureMap.getSubId(armorItem, "_overlay");
        List<SelectItemModel.SwitchCase<RegistryKey<ArmorTrimMaterial>>> list = new ArrayList<>(TRIM_MATERIAL_MODELS.size());

        for (ItemModelGenerator.TrimMaterial trimMaterialData : TRIM_MATERIAL_MODELS) {
            Identifier Identifier3 = Identifier.withSuffixedPath("_" + trimMaterialData.assets().base().suffix() + "_trim");
            Identifier Identifier4 = MGTrimMaterials.TRIM_MATERIALS.contains(trimMaterialData.assets())
                    ? modTrimLocation.withSuffixedPath("_" + trimMaterialData.assets().getAssetId(equipmentAsset).suffix())
                    : vanillaTrimLocation.withSuffixedPath("_" + trimMaterialData.assets().getAssetId(equipmentAsset).suffix());
            ItemModel.Unbaked itemmodel$unbaked;
            if (tint) {
                itemModels.uploadArmor(Identifier3, Identifier1, Identifier2, Identifier4);
                itemmodel$unbaked = ItemModels.tinted(Identifier3, new DyeTintSource(-6265536));
            } else {
                itemModels.uploadArmor(Identifier3, Identifier1, Identifier4);
                itemmodel$unbaked = ItemModels.basic(Identifier3);
            }

            list.add(ItemModels.switchCase(trimMaterialData.materialKey(), itemmodel$unbaked));

        }

        ItemModel.Unbaked itemmodel$unbaked1;
        if (tint) {
            Models.GENERATED_TWO_LAYERS.upload(Identifier, TextureMap.layered(Identifier1, Identifier2), itemModels.modelCollector);
            itemmodel$unbaked1 = ItemModels.tinted(Identifier, new DyeTintSource(-6265536));
        } else {
            Models.GENERATED.upload(Identifier, TextureMap.layer0(Identifier1), itemModels.modelCollector);
            itemmodel$unbaked1 = ItemModels.basic(Identifier);
        }

        itemModels.output.accept(armorItem, ItemModels.select(new TrimMaterialProperty(), itemmodel$unbaked1, list));

    }
    
    private <T extends Block> void simpleBlockWithItem(BlockStateModelGenerator blockStateModelGenerator, T block){
        blockStateModelGenerator.registerSimpleCubeAll(block);
    }

    private <T extends Block> void horizontalRotationBlock(BlockStateModelGenerator blockStateModelGenerator, T block){
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(block);
    }

    public void generateBow(ItemModelGenerator itemModels, Item bowItem) {
        ItemModel.Unbaked baseModel;

        if (bowItem == Items.BOW) {
            baseModel = ItemModels.basic(ModelIds.getItemModelId(bowItem));
        }
        else{
            baseModel = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "", Models.BOW));
        }

        ItemModel.Unbaked basePulling0 = ItemModels.basic(itemModels.registerSubModel(bowItem, "_pulling_0", Models.BOW));
        ItemModel.Unbaked basePulling1 = ItemModels.basic(itemModels.registerSubModel(bowItem, "_pulling_1", Models.BOW));
        ItemModel.Unbaked basePulling2 = ItemModels.basic(itemModels.registerSubModel(bowItem, "_pulling_2", Models.BOW));

        ItemModel.Unbaked bronzePulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked bronzePulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked bronzePulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_bronze_arrow_pulling_2", Models.BOW));

        ItemModel.Unbaked copperPulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked copperPulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked copperPulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_copper_arrow_pulling_2", Models.BOW));

        ItemModel.Unbaked enderitePulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked enderitePulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked enderitePulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_enderite_arrow_pulling_2", Models.BOW));

        ItemModel.Unbaked rubyPulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked rubyPulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked rubyPulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_ruby_arrow_pulling_2", Models.BOW));

        ItemModel.Unbaked steelPulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked steelPulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked steelPulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_steel_arrow_pulling_2", Models.BOW));

        ItemModel.Unbaked titaniumPulling0 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_0", Models.BOW));
        ItemModel.Unbaked titaniumPulling1 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_1", Models.BOW));
        ItemModel.Unbaked titaniumPulling2 = ItemModels.basic(createFlatItemModel(itemModels, bowItem, "_titanium_arrow_pulling_2", Models.BOW));

        itemModels.output.accept(
                bowItem,
                ItemModels.select(
                        new Arrow(),
                        ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, basePulling0, ItemModels.rangeDispatchEntry(basePulling1, 0.65F), ItemModels.rangeDispatchEntry(basePulling2, 0.9F)), baseModel),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.BRONZE,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, bronzePulling0, ItemModels.rangeDispatchEntry(bronzePulling1, 0.65F), ItemModels.rangeDispatchEntry(bronzePulling2, 0.9F)), baseModel)
                        ),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.COPPER,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, copperPulling0, ItemModels.rangeDispatchEntry(copperPulling1, 0.65F), ItemModels.rangeDispatchEntry(copperPulling2, 0.9F)), baseModel)
                        ),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.ENDERITE,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, enderitePulling0, ItemModels.rangeDispatchEntry(enderitePulling1, 0.65F), ItemModels.rangeDispatchEntry(enderitePulling2, 0.9F)), baseModel)
                        ),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.RUBY,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, rubyPulling0, ItemModels.rangeDispatchEntry(rubyPulling1, 0.65F), ItemModels.rangeDispatchEntry(rubyPulling2, 0.9F)), baseModel)
                        ),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.STEEL,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, steelPulling0, ItemModels.rangeDispatchEntry(steelPulling1, 0.65F), ItemModels.rangeDispatchEntry(steelPulling2, 0.9F)), baseModel)
                        ),
                        ItemModels.switchCase(
                                MGArrowItem.MGArrowType.TITANIUM,
                                ItemModels.condition(ItemModels.usingItemProperty(), ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, titaniumPulling0, ItemModels.rangeDispatchEntry(titaniumPulling1, 0.65F), ItemModels.rangeDispatchEntry(titaniumPulling2, 0.9F)), baseModel)
                        )
                )
        );
    }

    public Identifier createFlatItemModel(ItemModelGenerator itemModels, Item item, String suffix, Model modelTemplate) {
        return modelTemplate.upload(getModelLocation(item, suffix), TextureMap.layer0(getModelLocation(item, suffix)), itemModels.modelCollector);
    }

    public Identifier getModelLocation(Item item, String suffix) {
        Identifier resourcelocation = Identifier.of(MoreGears.MODID, getItemName(item));
        return resourcelocation.withPath((p_386751_) -> "item/" + p_386751_ + suffix);
    }

    public String getItemName(Item item) {
        return Registries.ITEM.getId(item).getPath();
    }

    private Identifier textureLoc(String location){
        return Identifier.of(MoreGears.MODID, "block/" + location);
    }

    private Identifier itemTextureLoc(String location){
        return Identifier.of(MoreGears.MODID, "item/" + location);
    }
}
