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

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_TOOL_LEVEL_1).add(
                MGBlocks.TIN_ORE,
                MGBlocks.DEEPSLATE_TIN_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_TOOL_LEVEL_2).add(
                MGBlocks.RUBY_ORE,
                MGBlocks.DEEPSLATE_RUBY_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_TOOL_LEVEL_4).add(
                MGBlocks.NETHER_TITANIUM_ORE
        );

        this.getOrCreateTagBuilder(MGTags.Blocks.NEEDS_TOOL_LEVEL_5)
                .add(MGBlocks.END_ENDERITE_ORE);

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
