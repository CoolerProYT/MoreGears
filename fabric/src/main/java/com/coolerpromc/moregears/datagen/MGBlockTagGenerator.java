package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MGBlockTagGenerator extends FabricTagsProvider.BlockTagsProvider {
    public MGBlockTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE,
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE,
                MGBlocks.NETHER_TITANIUM_ORE,
                MGBlocks.END_ENDERITE_ORE,
                MGBlocks.ALLOY_SMELTER
        );

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_COPPER_TOOL).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE,
                MGBlocks.ALLOY_SMELTER
        );

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addOptionalTag(BlockTags.NEEDS_IRON_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_BRONZE_TOOL).add(
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE
        );

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_STEEL_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(MGBlocks.NETHER_TITANIUM_ORE);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_RUBY_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .add(MGBlocks.END_ENDERITE_ORE);

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL);

        this.valueLookupBuilder(MGTags.Blocks.ORES_TIN).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE
        );

        this.valueLookupBuilder(MGTags.Blocks.ORES_RUBY).add(
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE
        );

        this.valueLookupBuilder(MGTags.Blocks.ORES_TITANIUM).add(
                MGBlocks.NETHER_TITANIUM_ORE
        );

        this.valueLookupBuilder(MGTags.Blocks.ORES_ENDERITE).add(
                MGBlocks.END_ENDERITE_ORE
        );
    }
}
