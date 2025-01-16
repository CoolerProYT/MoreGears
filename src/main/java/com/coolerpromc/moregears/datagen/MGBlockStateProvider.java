package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.util.MGOreTypes;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class MGBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper existingFileHelper;

    public MGBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreGears.MODID, exFileHelper);
        this.existingFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(MGBlocks.TIN_ORE);
        simpleBlockWithItem(MGBlocks.DEEPSLATE_TIN_ORE);
        simpleBlockWithItem(MGBlocks.RUBY_ORE);
        simpleBlockWithItem(MGBlocks.DEEPSLATE_RUBY_ORE);
        simpleBlockWithItem(MGBlocks.NETHER_TITANIUM_ORE);
        simpleBlockWithItem(MGBlocks.END_ENDERITE_ORE);

        horizontalBlock(MGBlocks.ALLOY_SMELTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/alloy_smelter")));
        simpleBlockItem(MGBlocks.ALLOY_SMELTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/alloy_smelter")));
    }

    private void simpleBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private ResourceLocation textureLoc(String location){
        return this.modLoc("block/" + location);
    }
}
