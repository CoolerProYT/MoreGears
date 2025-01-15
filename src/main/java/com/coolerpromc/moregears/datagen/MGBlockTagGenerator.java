package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class MGBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public MGBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE,
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE,
                MGBlocks.NETHER_TITANIUM_ORE,
                MGBlocks.END_ENDERITE_ORE
        );

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_COPPER_TOOL).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addOptionalTag(Identifier.of("minecraft", "needs_iron_tool"));

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_BRONZE_TOOL).add(
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_STEEL_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(MGBlocks.NETHER_TITANIUM_ORE);

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_RUBY_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .add(MGBlocks.END_ENDERITE_ORE);

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL);

        this.getOrCreateTagBuilder(MGTags.Blocks.ORES_TIN).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.ORES_RUBY).add(
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.ORES_TITANIUM).add(
                MGBlocks.NETHER_TITANIUM_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.ORES_ENDERITE).add(
                MGBlocks.END_ENDERITE_ORE
        );
    }
}
