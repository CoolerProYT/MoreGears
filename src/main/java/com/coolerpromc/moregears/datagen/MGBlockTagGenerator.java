package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MGBlockTagGenerator extends BlockTagsProvider {
    public MGBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoreGears.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                MGBlocks.TIN_ORE.get(),
                MGBlocks.DEEPSLATE_TIN_ORE.get(),
                MGBlocks.RUBY_ORE.get(),
                MGBlocks.DEEPSLATE_RUBY_ORE.get(),
                MGBlocks.NETHER_TITANIUM_ORE.get(),
                MGBlocks.END_ENDERITE_ORE.get()
        );

        this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_STEEL_TOOL)
                .addTag(MGTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(MGTags.Blocks.NEEDS_COPPER_TOOL).add(
                MGBlocks.TIN_ORE.get(),
                MGBlocks.DEEPSLATE_TIN_ORE.get()
        );

        this.tag(MGTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(MGTags.Blocks.NEEDS_BRONZE_TOOL)
                .remove(MGTags.Blocks.NEEDS_COPPER_TOOL);

        this.tag(MGTags.Blocks.NEEDS_BRONZE_TOOL).add(
                MGBlocks.RUBY_ORE.get(),
                MGBlocks.DEEPSLATE_RUBY_ORE.get()
        );

        this.tag(MGTags.Blocks.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(MGTags.Blocks.NEEDS_BRONZE_TOOL);

        this.tag(MGTags.Blocks.NEEDS_STEEL_TOOL);

        this.tag(MGTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(MGTags.Blocks.NEEDS_STEEL_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(MGBlocks.NETHER_TITANIUM_ORE.get());

        this.tag(MGTags.Blocks.NEEDS_RUBY_TOOL);

        this.tag(MGTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(MGTags.Blocks.NEEDS_RUBY_TOOL);

        this.tag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
            .add(MGBlocks.END_ENDERITE_ORE.get());

        this.tag(MGTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL)
                .remove(MGTags.Blocks.NEEDS_TITANIUM_TOOL);

        this.tag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(MGTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL)
                .remove(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

        this.tag(MGTags.Blocks.ORES_TIN).add(
                MGBlocks.TIN_ORE.get(),
                MGBlocks.DEEPSLATE_TIN_ORE.get()
        );

        this.tag(MGTags.Blocks.ORES_RUBY).add(
                MGBlocks.RUBY_ORE.get(),
                MGBlocks.DEEPSLATE_RUBY_ORE.get()
        );

        this.tag(MGTags.Blocks.ORES_TITANIUM).add(
                MGBlocks.NETHER_TITANIUM_ORE.get()
        );

        this.tag(MGTags.Blocks.ORES_ENDERITE).add(
                MGBlocks.END_ENDERITE_ORE.get()
        );
    }
}
