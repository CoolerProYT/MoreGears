package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.item.MGItems;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

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
        itemModelGenerator.register(MGItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(MGItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(MGItems.RAW_TITANIUM, Models.GENERATED);
        itemModelGenerator.register(MGItems.RAW_ENDERITE, Models.GENERATED);

        itemModelGenerator.register(MGItems.TITANIUM_NUGGET, Models.GENERATED);

        itemModelGenerator.register(MGItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(MGItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(MGItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(MGItems.RUBY_INGOT, Models.GENERATED);
        itemModelGenerator.register(MGItems.TITANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(MGItems.ENDERITE_INGOT, Models.GENERATED);

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

        itemModelGenerator.register(MGItems.COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(MGItems.BRONZE_ARROW, Models.GENERATED);
        itemModelGenerator.register(MGItems.STEEL_ARROW, Models.GENERATED);
        itemModelGenerator.register(MGItems.RUBY_ARROW, Models.GENERATED);
        itemModelGenerator.register(MGItems.TITANIUM_ARROW, Models.GENERATED);
        itemModelGenerator.register(MGItems.ENDERITE_ARROW, Models.GENERATED);

        generateBow(itemModelGenerator, Items.BOW);
        generateBow(itemModelGenerator, MGItems.COPPER_BOW);
        generateBow(itemModelGenerator, MGItems.BRONZE_BOW);
        generateBow(itemModelGenerator, MGItems.STEEL_BOW);
        generateBow(itemModelGenerator, MGItems.RUBY_BOW);
        generateBow(itemModelGenerator, MGItems.TITANIUM_BOW);
        generateBow(itemModelGenerator, MGItems.ENDERITE_BOW);
    }

    public void generateBow(ItemModelGenerator itemModelGenerator, Item bowItem) {
        Identifier bowId = Registries.ITEM.getId(bowItem);
        String bowName = bowId.getPath();

        // Main bow model
        if (bowItem != Items.BOW){
            itemModelGenerator.writer.accept(getModelLocation(bowItem, ""), () -> {
                return JsonParser.parseString("""
                {
                  "parent": "item/generated",
                  "textures": {
                    "layer0": "%s:item/%s"
                  },
                  "display": {
                    "thirdperson_righthand": {
                      "rotation": [-80, 260, -40],
                      "translation": [-1, -2, 2.5],
                      "scale": [0.9, 0.9, 0.9]
                    },
                    "thirdperson_lefthand": {
                      "rotation": [-80, -280, 40],
                      "translation": [-1, -2, 2.5],
                      "scale": [0.9, 0.9, 0.9]
                    },
                    "firstperson_righthand": {
                      "rotation": [0, -90, 25],
                      "translation": [1.13, 3.2, 1.13],
                      "scale": [0.68, 0.68, 0.68]
                    },
                    "firstperson_lefthand": {
                      "rotation": [0, 90, -25],
                      "translation": [1.13, 3.2, 1.13],
                      "scale": [0.68, 0.68, 0.68]
                    }
                  },
                  "overrides": [
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.0},
                      "model": "%s:item/%s_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.0},
                      "model": "%s:item/%s_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.0},
                      "model": "%s:item/%s_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.1},
                      "model": "%s:item/%s_copper_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.1},
                      "model": "%s:item/%s_copper_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.1},
                      "model": "%s:item/%s_copper_arrow_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.2},
                      "model": "%s:item/%s_bronze_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.2},
                      "model": "%s:item/%s_bronze_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.2},
                      "model": "%s:item/%s_bronze_arrow_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.3},
                      "model": "%s:item/%s_steel_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.3},
                      "model": "%s:item/%s_steel_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.3},
                      "model": "%s:item/%s_steel_arrow_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.4},
                      "model": "%s:item/%s_ruby_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.4},
                      "model": "%s:item/%s_ruby_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.4},
                      "model": "%s:item/%s_ruby_arrow_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.5},
                      "model": "%s:item/%s_titanium_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.5},
                      "model": "%s:item/%s_titanium_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.5},
                      "model": "%s:item/%s_titanium_arrow_pulling_2"
                    },
                    {
                      "predicate": {"pulling": 1, "%s:select_arrow": 0.6},
                      "model": "%s:item/%s_enderite_arrow_pulling_0"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.65, "%s:select_arrow": 0.6},
                      "model": "%s:item/%s_enderite_arrow_pulling_1"
                    },
                    {
                      "predicate": {"pulling": 1, "pull": 0.9, "%s:select_arrow": 0.6},
                      "model": "%s:item/%s_enderite_arrow_pulling_2"
                    }
                  ]
                }
                """.formatted(
                        bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName,
                        MoreGears.MODID, bowId.getNamespace(), bowName
                ));
            });
        }

        // Generate all pulling model variants
        createPullingModels(itemModelGenerator, bowItem, "");
        createPullingModels(itemModelGenerator, bowItem, "_copper_arrow");
        createPullingModels(itemModelGenerator, bowItem, "_bronze_arrow");
        createPullingModels(itemModelGenerator, bowItem, "_steel_arrow");
        createPullingModels(itemModelGenerator, bowItem, "_ruby_arrow");
        createPullingModels(itemModelGenerator, bowItem, "_titanium_arrow");
        createPullingModels(itemModelGenerator, bowItem, "_enderite_arrow");
    }

    private void createPullingModels(ItemModelGenerator itemModelGenerator, Item bowItem, String arrowSuffix) {
        Identifier bowId = Registries.ITEM.getId(bowItem);
        String bowName = bowId.getPath();

        for (int i = 0; i <= 2; i++) {
            String modelName = bowName + arrowSuffix + "_pulling_" + i;
            Identifier modelId = getModelLocation(bowItem, arrowSuffix + "_pulling_" + i);

            itemModelGenerator.writer.accept(modelId, () -> {
                return JsonParser.parseString("""
                    {
                      "parent": "item/bow",
                      "textures": {
                        "layer0": "%s:item/%s"
                      }
                    }
                    """.formatted(modelId.getNamespace(), modelName));
            });
        }
    }

    private Identifier getModelLocation(Item item, String suffix) {
        Identifier itemId = Registries.ITEM.getId(item);
        if (suffix.startsWith("_pulling") && item == Items.BOW) {
            return Identifier.of("minecraft", "item/" + itemId.getPath() + suffix);
        }
        return Identifier.of(MoreGears.MODID, "item/" + itemId.getPath() + suffix);
    }

    private String getModelNamespace(Identifier bowId, String suffix) {
        if (suffix.startsWith("_pulling") && bowId.equals(Registries.ITEM.getId(Items.BOW))) {
            return "minecraft";
        }
        return MoreGears.MODID;
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
