package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

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

        itemModelGenerator.registerArmor(MGItems.COPPER_HELMET);
        itemModelGenerator.registerArmor(MGItems.COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.COPPER_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.COPPER_BOOTS);

        itemModelGenerator.registerArmor(MGItems.BRONZE_HELMET);
        itemModelGenerator.registerArmor(MGItems.BRONZE_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.BRONZE_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.BRONZE_BOOTS);

        itemModelGenerator.registerArmor(MGItems.STEEL_HELMET);
        itemModelGenerator.registerArmor(MGItems.STEEL_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.STEEL_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.STEEL_BOOTS);

        itemModelGenerator.registerArmor(MGItems.RUBY_HELMET);
        itemModelGenerator.registerArmor(MGItems.RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.RUBY_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.RUBY_BOOTS);

        itemModelGenerator.registerArmor(MGItems.TITANIUM_HELMET);
        itemModelGenerator.registerArmor(MGItems.TITANIUM_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.TITANIUM_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.TITANIUM_BOOTS);

        itemModelGenerator.registerArmor(MGItems.ENDERITE_HELMET);
        itemModelGenerator.registerArmor(MGItems.ENDERITE_CHESTPLATE);
        itemModelGenerator.registerArmor(MGItems.ENDERITE_LEGGINGS);
        itemModelGenerator.registerArmor(MGItems.ENDERITE_BOOTS);

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
        Map<TextureKey, Identifier> textureMapConverted = new HashMap<>();
        textureMapConverted.put(TextureKey.LAYER0, texture);

        itemModelGenerator.writer.accept(itemTextureLoc(Registries.ITEM.getId(item).getPath()), () -> Models.GENERATED.createJson(itemTextureLoc(Registries.ITEM.getId(item).getPath()), textureMapConverted));
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
