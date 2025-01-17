package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

    private <T extends Block> void simpleBlockWithItem(RegistryObject<T> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private ResourceLocation textureLoc(String location){
        return this.modLoc("block/" + location);
    }
}
