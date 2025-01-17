package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
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

        this.tag(MGTags.Blocks.NEEDS_COPPER_TOOL).add(
                MGBlocks.TIN_ORE.get(),
                MGBlocks.DEEPSLATE_TIN_ORE.get()
        );

        this.tag(MGTags.Blocks.NEEDS_BRONZE_TOOL).add(
                MGBlocks.RUBY_ORE.get(),
                MGBlocks.DEEPSLATE_RUBY_ORE.get()
        );

        this.tag(MGTags.Blocks.NEEDS_STEEL_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(MGBlocks.NETHER_TITANIUM_ORE.get());

        this.tag(MGTags.Blocks.NEEDS_RUBY_TOOL);

        this.tag(MGTags.Blocks.NEEDS_TITANIUM_TOOL)
            .add(MGBlocks.END_ENDERITE_ORE.get());

        this.tag(MGTags.Blocks.NEEDS_ENDERITE_TOOL);

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
