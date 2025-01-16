package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import com.coolerpromc.moregears.util.MGOreTypes;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MGModelProvider extends ModelProvider {
    public final ResourceLocation RAW_ORE = itemLocation("template_raw_ore");
    public final ResourceLocation INGOT = itemLocation("template_ingot");
    public final ResourceLocation GEM = itemLocation("template_gem");

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
        withExistingTexture(itemModels, MGItems.RAW_TIN, RAW_ORE);
        withExistingTexture(itemModels, MGItems.RAW_RUBY, RAW_ORE);
        withExistingTexture(itemModels, MGItems.RAW_TITANIUM, RAW_ORE);
        withExistingTexture(itemModels, MGItems.RAW_ENDERITE, RAW_ORE);

        withExistingTexture(itemModels, MGItems.TIN_INGOT, INGOT);
        withExistingTexture(itemModels, MGItems.BRONZE_INGOT, INGOT);
        withExistingTexture(itemModels, MGItems.STEEL_INGOT, INGOT);
        withExistingTexture(itemModels, MGItems.RUBY_INGOT, GEM);
        withExistingTexture(itemModels, MGItems.TITANIUM_INGOT, INGOT);
        withExistingTexture(itemModels, MGItems.ENDERITE_INGOT, INGOT);

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
        itemModels.generateTrimmableItem(item.get(), armorMaterial.assetId(), item.get().getArmorType().getName(), false);
    }

    private <T extends Item> void basicItem(ItemModelGenerators itemModels, DeferredItem<T> item){
        itemModels.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
    }

    private <T extends Item> void handheldItem(ItemModelGenerators itemModels, DeferredItem<T> item){
        TextureMapping textureMapping = new TextureMapping();
        textureMapping.put(TextureSlot.LAYER0, itemLocation(getItemName(item.get())));

        itemModels.itemModelOutput.accept(item.get(), new BlockModelWrapper.Unbaked(ModelTemplates.FLAT_HANDHELD_ITEM.create(item.get(), textureMapping, itemModels.modelOutput), List.of()));
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
