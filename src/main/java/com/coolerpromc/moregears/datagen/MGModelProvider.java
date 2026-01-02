package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.datagen.property.Arrow;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import com.coolerpromc.moregears.trim.MGTrimMaterials;
import com.coolerpromc.moregears.util.MGOreTypes;
import net.minecraft.client.color.item.Dye;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MGModelProvider extends ModelProvider {
    public final ResourceLocation RAW_ORE = itemLocation("template_raw_ore");
    public final ResourceLocation INGOT = itemLocation("template_ingot");
    public final ResourceLocation GEM = itemLocation("template_gem");public static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIAL_MODELS = List.of(
            new ItemModelGenerators.TrimMaterialData("quartz", TrimMaterials.QUARTZ, Map.of()),
            new ItemModelGenerators.TrimMaterialData("iron", TrimMaterials.IRON, Map.of(EquipmentAssets.IRON, "iron_darker")),
            new ItemModelGenerators.TrimMaterialData("netherite", TrimMaterials.NETHERITE, Map.of(EquipmentAssets.NETHERITE, "netherite_darker")),
            new ItemModelGenerators.TrimMaterialData("redstone", TrimMaterials.REDSTONE, Map.of()),
            new ItemModelGenerators.TrimMaterialData("copper", TrimMaterials.COPPER, Map.of()),
            new ItemModelGenerators.TrimMaterialData("gold", TrimMaterials.GOLD, Map.of(EquipmentAssets.GOLD, "gold_darker")),
            new ItemModelGenerators.TrimMaterialData("emerald", TrimMaterials.EMERALD, Map.of()),
            new ItemModelGenerators.TrimMaterialData("diamond", TrimMaterials.DIAMOND, Map.of(EquipmentAssets.DIAMOND, "diamond_darker")),
            new ItemModelGenerators.TrimMaterialData("lapis", TrimMaterials.LAPIS, Map.of()),
            new ItemModelGenerators.TrimMaterialData("amethyst", TrimMaterials.AMETHYST, Map.of()),
            new ItemModelGenerators.TrimMaterialData("resin", TrimMaterials.RESIN, Map.of()),
            new ItemModelGenerators.TrimMaterialData("tin", MGTrimMaterials.TIN, Map.of()),
            new ItemModelGenerators.TrimMaterialData("bronze", MGTrimMaterials.BRONZE, Map.of()),
            new ItemModelGenerators.TrimMaterialData("steel", MGTrimMaterials.STEEL, Map.of()),
            new ItemModelGenerators.TrimMaterialData("ruby", MGTrimMaterials.RUBY, Map.of()),
            new ItemModelGenerators.TrimMaterialData("titanium", MGTrimMaterials.TITANIUM, Map.of()),
            new ItemModelGenerators.TrimMaterialData("enderite", MGTrimMaterials.ENDERITE, Map.of())
    );

    public static final ResourceLocation MOD_TRIM_PREFIX_HELMET = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/helmet_trim");
    public static final ResourceLocation MOD_TRIM_PREFIX_CHESTPLATE = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/chestplate_trim");
    public static final ResourceLocation MOD_TRIM_PREFIX_LEGGINGS = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/leggings_trim");
    public static final ResourceLocation MOD_TRIM_PREFIX_BOOTS = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/boots_trim");

    public static final ResourceLocation TRIM_PREFIX_HELMET = ResourceLocation.withDefaultNamespace("trims/items/helmet_trim");
    public static final ResourceLocation TRIM_PREFIX_CHESTPLATE = ResourceLocation.withDefaultNamespace("trims/items/chestplate_trim");
    public static final ResourceLocation TRIM_PREFIX_LEGGINGS = ResourceLocation.withDefaultNamespace("trims/items/leggings_trim");
    public static final ResourceLocation TRIM_PREFIX_BOOTS = ResourceLocation.withDefaultNamespace("trims/items/boots_trim");

    public MGModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        registerBlockState(blockModels);
        registerItemModels(itemModels);
    }

    private void registerBlockState(BlockModelGenerators blockModels){
        simpleBlockWithItem(blockModels, MGBlocks.TIN_ORE);
        simpleBlockWithItem(blockModels, MGBlocks.DEEPSLATE_TIN_ORE);
        simpleBlockWithItem(blockModels, MGBlocks.RUBY_ORE);
        simpleBlockWithItem(blockModels, MGBlocks.DEEPSLATE_RUBY_ORE);
        simpleBlockWithItem(blockModels, MGBlocks.NETHER_TITANIUM_ORE);
        simpleBlockWithItem(blockModels, MGBlocks.END_ENDERITE_ORE);

        horizontalRotationBlock(blockModels, MGBlocks.ALLOY_SMELTER);
    }

    private void registerItemModels(ItemModelGenerators itemModels){
        basicItem(itemModels, MGItems.RAW_TIN);
        basicItem(itemModels, MGItems.RAW_RUBY);
        basicItem(itemModels, MGItems.RAW_TITANIUM);
        basicItem(itemModels, MGItems.RAW_ENDERITE);

        basicItem(itemModels, MGItems.TITANIUM_NUGGET);

        basicItem(itemModels, MGItems.TIN_INGOT);
        basicItem(itemModels, MGItems.BRONZE_INGOT);
        basicItem(itemModels, MGItems.STEEL_INGOT);
        basicItem(itemModels, MGItems.RUBY_INGOT);
        basicItem(itemModels, MGItems.TITANIUM_INGOT);
        basicItem(itemModels, MGItems.ENDERITE_INGOT);

        trimmedArmorItem(itemModels, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, true);
        trimmedArmorItem(itemModels, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, true);
        trimmedArmorItem(itemModels, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, true);
        trimmedArmorItem(itemModels, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, true);
        trimmedArmorItem(itemModels, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModels, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModels, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModels, Items.IRON_HELMET, EquipmentAssets.IRON, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModels, Items.IRON_LEGGINGS, EquipmentAssets.IRON, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModels, Items.IRON_BOOTS, EquipmentAssets.IRON, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModels, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModels, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModels, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModels, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModels, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModels, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);
        trimmedArmorItem(itemModels, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, TRIM_PREFIX_HELMET, MOD_TRIM_PREFIX_HELMET, false);
        trimmedArmorItem(itemModels, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, TRIM_PREFIX_CHESTPLATE, MOD_TRIM_PREFIX_CHESTPLATE, false);
        trimmedArmorItem(itemModels, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, TRIM_PREFIX_LEGGINGS, MOD_TRIM_PREFIX_LEGGINGS, false);
        trimmedArmorItem(itemModels, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, TRIM_PREFIX_BOOTS, MOD_TRIM_PREFIX_BOOTS, false);

        trimmedArmorItem(itemModels, MGItems.COPPER_HELMET, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.COPPER_CHESTPLATE, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.COPPER_LEGGINGS, MGArmorMaterials.COPPER_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.COPPER_BOOTS, MGArmorMaterials.COPPER_ARMOR_MATERIAL);

        trimmedArmorItem(itemModels, MGItems.BRONZE_HELMET, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.BRONZE_CHESTPLATE, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.BRONZE_LEGGINGS, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.BRONZE_BOOTS, MGArmorMaterials.BRONZE_ARMOR_MATERIAL);

        trimmedArmorItem(itemModels, MGItems.STEEL_HELMET, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.STEEL_CHESTPLATE, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.STEEL_LEGGINGS, MGArmorMaterials.STEEL_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.STEEL_BOOTS, MGArmorMaterials.STEEL_ARMOR_MATERIAL);

        trimmedArmorItem(itemModels, MGItems.RUBY_HELMET, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.RUBY_CHESTPLATE, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.RUBY_LEGGINGS, MGArmorMaterials.RUBY_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.RUBY_BOOTS, MGArmorMaterials.RUBY_ARMOR_MATERIAL);

        trimmedArmorItem(itemModels, MGItems.TITANIUM_HELMET, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.TITANIUM_CHESTPLATE, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.TITANIUM_LEGGINGS, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.TITANIUM_BOOTS, MGArmorMaterials.TITANIUM_ARMOR_MATERIAL);

        trimmedArmorItem(itemModels, MGItems.ENDERITE_HELMET, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.ENDERITE_CHESTPLATE, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.ENDERITE_LEGGINGS, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);
        trimmedArmorItem(itemModels, MGItems.ENDERITE_BOOTS, MGArmorMaterials.ENDERITE_ARMOR_MATERIAL);

        basicItem(itemModels, MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE);
        basicItem(itemModels, MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);

        handheldItem(itemModels, MGItems.COPPER_SWORD);
        handheldItem(itemModels, MGItems.COPPER_SHOVEL);
        handheldItem(itemModels, MGItems.COPPER_PICKAXE);
        handheldItem(itemModels, MGItems.COPPER_AXE);
        handheldItem(itemModels, MGItems.COPPER_HOE);

        handheldItem(itemModels, MGItems.BRONZE_SWORD);
        handheldItem(itemModels, MGItems.BRONZE_SHOVEL);
        handheldItem(itemModels, MGItems.BRONZE_PICKAXE);
        handheldItem(itemModels, MGItems.BRONZE_AXE);
        handheldItem(itemModels, MGItems.BRONZE_HOE);

        handheldItem(itemModels, MGItems.STEEL_SWORD);
        handheldItem(itemModels, MGItems.STEEL_SHOVEL);
        handheldItem(itemModels, MGItems.STEEL_PICKAXE);
        handheldItem(itemModels, MGItems.STEEL_AXE);
        handheldItem(itemModels, MGItems.STEEL_HOE);

        handheldItem(itemModels, MGItems.RUBY_SWORD);
        handheldItem(itemModels, MGItems.RUBY_SHOVEL);
        handheldItem(itemModels, MGItems.RUBY_PICKAXE);
        handheldItem(itemModels, MGItems.RUBY_AXE);
        handheldItem(itemModels, MGItems.RUBY_HOE);

        handheldItem(itemModels, MGItems.TITANIUM_SWORD);
        handheldItem(itemModels, MGItems.TITANIUM_SHOVEL);
        handheldItem(itemModels, MGItems.TITANIUM_PICKAXE);
        handheldItem(itemModels, MGItems.TITANIUM_AXE);
        handheldItem(itemModels, MGItems.TITANIUM_HOE);

        handheldItem(itemModels, MGItems.ENDERITE_SWORD);
        handheldItem(itemModels, MGItems.ENDERITE_SHOVEL);
        handheldItem(itemModels, MGItems.ENDERITE_PICKAXE);
        handheldItem(itemModels, MGItems.ENDERITE_AXE);
        handheldItem(itemModels, MGItems.ENDERITE_HOE);

        basicItem(itemModels, MGItems.COPPER_ARROW);
        basicItem(itemModels, MGItems.BRONZE_ARROW);
        basicItem(itemModels, MGItems.STEEL_ARROW);
        basicItem(itemModels, MGItems.RUBY_ARROW);
        basicItem(itemModels, MGItems.TITANIUM_ARROW);
        basicItem(itemModels, MGItems.ENDERITE_ARROW);

        generateBow(itemModels, Items.BOW);
        generateBow(itemModels, MGItems.COPPER_BOW.get());
        generateBow(itemModels, MGItems.BRONZE_BOW.get());
        generateBow(itemModels, MGItems.STEEL_BOW.get());
        generateBow(itemModels, MGItems.RUBY_BOW.get());
        generateBow(itemModels, MGItems.TITANIUM_BOW.get());
        generateBow(itemModels, MGItems.ENDERITE_BOW.get());
    }

    // Block model methods
    private <T extends Block> void horizontalRotationBlock(BlockModelGenerators blockModels, DeferredBlock<T> block){
        blockModels.createNonTemplateHorizontalBlock(MGBlocks.ALLOY_SMELTER.get());
        blockModels.registerSimpleItemModel(block.get(), blockLocation(getBlockName(block.get())));
    }

    private <T extends Block> void simpleBlockWithItem(BlockModelGenerators blockModels, DeferredBlock<T> block) {
        blockModels.createTrivialCube(block.get());
    }

    // Item model methods
    private <T extends Item> void withExistingTexture(ItemModelGenerators itemModels, DeferredItem<T> item, ResourceLocation texture){
        TextureMapping textureMapping = new TextureMapping();
        textureMapping.put(TextureSlot.LAYER0, texture);

        int color = -1;

        if(item.get() instanceof MGRawOre mgRawOre){
            color = mgRawOre.getColor();
        }

        if (item.get() instanceof MGIngot mgIngot){
            color = mgIngot.getColor();
        }

        itemModels.itemModelOutput.accept(item.get(), new BlockModelWrapper.Unbaked(ModelTemplates.FLAT_ITEM.create(item.get(), textureMapping, itemModels.modelOutput), List.of(ItemModelUtils.constantTint(color))));
    }

    private void trimmedArmorItem(ItemModelGenerators itemModels, DeferredItem<MGArmorItem> item, ArmorMaterial armorMaterial){
        generateTrimmableItem(itemModels, item.get(), armorMaterial.assetId(), ResourceLocation.parse("trims/items/" + item.get().getArmorType().getName() + "_trim"), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/" + item.get().getArmorType().getName() + "_trim"), false);
    }

    private void trimmedArmorItem(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentAsset, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, boolean tint) {
        generateTrimmableItem(itemModels, item, equipmentAsset, resourceLocation, resourceLocation2, false);
    }

    public void generateTrimmableItem(ItemModelGenerators itemModels, Item armorItem, ResourceKey<EquipmentAsset> equipmentAsset, ResourceLocation vanillaTrimLocation, ResourceLocation modTrimLocation, boolean tint) {
        ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(armorItem);
        ResourceLocation resourcelocation1 = TextureMapping.getItemTexture(armorItem);
        ResourceLocation resourcelocation2 = TextureMapping.getItemTexture(armorItem, "_overlay");
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> list = new ArrayList<>(TRIM_MATERIAL_MODELS.size());

        for (ItemModelGenerators.TrimMaterialData itemmodelgenerators$trimmaterialdata : TRIM_MATERIAL_MODELS) {
            ResourceLocation resourcelocation3 = resourcelocation.withSuffix("_" + itemmodelgenerators$trimmaterialdata.name() + "_trim");
            ResourceLocation resourcelocation4 = MGTrimMaterials.TRIM_MATERIALS.contains(itemmodelgenerators$trimmaterialdata.name())
                    ? modTrimLocation.withSuffix("_" + itemmodelgenerators$trimmaterialdata.name())
                    : vanillaTrimLocation.withSuffix("_" + itemmodelgenerators$trimmaterialdata.name());
            ItemModel.Unbaked itemmodel$unbaked;
            if (tint) {
                itemModels.generateLayeredItem(resourcelocation3, resourcelocation1, resourcelocation2, resourcelocation4);
                itemmodel$unbaked = ItemModelUtils.tintedModel(resourcelocation3, new Dye(-6265536));
            } else {
                itemModels.generateLayeredItem(resourcelocation3, resourcelocation1, resourcelocation4);
                itemmodel$unbaked = ItemModelUtils.plainModel(resourcelocation3);
            }

            list.add(ItemModelUtils.when(itemmodelgenerators$trimmaterialdata.materialKey(), itemmodel$unbaked));
        }

        ItemModel.Unbaked itemmodel$unbaked1;
        if (tint) {
            ModelTemplates.TWO_LAYERED_ITEM.create(resourcelocation, TextureMapping.layered(resourcelocation1, resourcelocation2), itemModels.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.tintedModel(resourcelocation, new Dye(-6265536));
        } else {
            ModelTemplates.FLAT_ITEM.create(resourcelocation, TextureMapping.layer0(resourcelocation1), itemModels.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.plainModel(resourcelocation);
        }

        itemModels.itemModelOutput.accept(armorItem, ItemModelUtils.select(new TrimMaterialProperty(), itemmodel$unbaked1, list));
    }

    private <T extends Item> void basicItem(ItemModelGenerators itemModels, DeferredItem<T> item){
        itemModels.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
    }

    private <T extends Item> void handheldItem(ItemModelGenerators itemModels, DeferredItem<T> item){
        TextureMapping textureMapping = new TextureMapping();
        textureMapping.put(TextureSlot.LAYER0, itemLocation(getItemName(item.get())));

        itemModels.itemModelOutput.accept(item.get(), new BlockModelWrapper.Unbaked(ModelTemplates.FLAT_HANDHELD_ITEM.create(item.get(), textureMapping, itemModels.modelOutput), List.of()));
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

    // Helper methods
    private ResourceLocation mcLoc(String path){
        return ResourceLocation.withDefaultNamespace(path);
    }

    private String getBlockName(Block block){
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        return location.getPath();
    }

    private String getItemName(Item item){
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        return location.getPath();
    }

    private ResourceLocation blockLocation(String modelName){
        return ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "block/" + modelName);
    }

    private ResourceLocation itemLocation(String modelName){
        return ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "item/" + modelName);
    }

    public ResourceLocation createFlatItemModel(ItemModelGenerators itemModels, Item item, String suffix, ModelTemplate modelTemplate) {
        return modelTemplate.create(getModelLocation(item, suffix), TextureMapping.layer0(getModelLocation(item, suffix)), itemModels.modelOutput);
    }

    public ResourceLocation getModelLocation(Item item, String suffix) {
        ResourceLocation resourcelocation = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, getItemName(item));
        return resourcelocation.withPath((p_386751_) -> "item/" + p_386751_ + suffix);
    }

    // Override methods
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.listElements().filter(blockReference -> Optional.of(BuiltInRegistries.BLOCK.getKey(blockReference.value())).filter(resourceLocation -> resourceLocation.getNamespace().equals(MoreGears.MODID)).isPresent());
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return BuiltInRegistries.ITEM.listElements().filter(itemReference -> Optional.of(BuiltInRegistries.ITEM.getKey(itemReference.value())).filter(resourceLocation -> resourceLocation.getNamespace().equals(MoreGears.MODID)).isPresent());
    }
}
