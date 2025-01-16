package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.BasicItemModel;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.util.Identifier;

import java.util.List;

public class MGModelProvider extends FabricModelProvider {
    public final Identifier RAW_ORE = itemTextureLoc("template_raw_ore");
    public final Identifier INGOT = itemTextureLoc("template_ingot");
    public final Identifier GEM = itemTextureLoc("template_gem");

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
        withExistingTexture(itemModelGenerator, MGItems.RAW_TIN, RAW_ORE);
        withExistingTexture(itemModelGenerator, MGItems.RAW_RUBY, RAW_ORE);
        withExistingTexture(itemModelGenerator, MGItems.RAW_TITANIUM, RAW_ORE);
        withExistingTexture(itemModelGenerator, MGItems.RAW_ENDERITE, RAW_ORE);

        withExistingTexture(itemModelGenerator, MGItems.TIN_INGOT, INGOT);
        withExistingTexture(itemModelGenerator, MGItems.BRONZE_INGOT, INGOT);
        withExistingTexture(itemModelGenerator, MGItems.STEEL_INGOT, INGOT);
        withExistingTexture(itemModelGenerator, MGItems.RUBY_INGOT, GEM);
        withExistingTexture(itemModelGenerator, MGItems.TITANIUM_INGOT, INGOT);
        withExistingTexture(itemModelGenerator, MGItems.ENDERITE_INGOT, INGOT);

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
    }

    private <T extends Item> void withExistingTexture(ItemModelGenerator itemModelGenerator, T item, Identifier texture){
        TextureMap textureMap = new TextureMap();
        textureMap.put(TextureKey.LAYER0, texture);

        int color = -1;

        if(item instanceof MGRawOre mgRawOre){
            color = mgRawOre.getColor();
        }

        if (item instanceof MGIngot mgIngot){
            color = mgIngot.getColor();
        }

        itemModelGenerator.output.accept(item, new BasicItemModel.Unbaked(Models.GENERATED.upload(item, textureMap, itemModelGenerator.modelCollector), List.of(ItemModels.constantTintSource(color))));
    }

    private void trimmedArmorItem(ItemModelGenerator itemModels, MGArmorItem item, ArmorMaterial armorMaterial){
        itemModels.registerArmor(item, armorMaterial.assetId(), item.getType().getName(), false);
    }
    
    private <T extends Block> void simpleBlockWithItem(BlockStateModelGenerator blockStateModelGenerator, T block){
        blockStateModelGenerator.registerSimpleCubeAll(block);
    }

    private <T extends Block> void horizontalRotationBlock(BlockStateModelGenerator blockStateModelGenerator, T block){
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(block);
    }

    private Identifier textureLoc(String location){
        return Identifier.of(MoreGears.MODID, "block/" + location);
    }

    private Identifier itemTextureLoc(String location){
        return Identifier.of(MoreGears.MODID, "item/" + location);
    }
}
