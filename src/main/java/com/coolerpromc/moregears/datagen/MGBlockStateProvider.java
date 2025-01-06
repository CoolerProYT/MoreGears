package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MGBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper existingFileHelper;

    public MGBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreGears.MODID, exFileHelper);
        this.existingFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        final ModelFile IRON_ORE_STYLE = new ModelFile.ExistingModelFile(this.modLoc("block/template_iron_ore"), this.existingFileHelper);
        final ModelFile GOLD_ORE_STYLE = new ModelFile.ExistingModelFile(this.modLoc("block/template_gold_ore"), this.existingFileHelper);
        final ModelFile DIAMOND_ORE_STYLE = new ModelFile.ExistingModelFile(this.modLoc("block/template_diamond_ore"), this.existingFileHelper);
        final ModelFile EMERALD_ORE_STYLE = new ModelFile.ExistingModelFile(this.modLoc("block/template_emerald_ore"), this.existingFileHelper);
        final ModelFile REDSTONE_ORE_STYLE = new ModelFile.ExistingModelFile(this.modLoc("block/template_redstone_ore"), this.existingFileHelper);

        simpleBlockWithItem(MGBlocks.TIN_ORE.get(), IRON_ORE_STYLE);
        simpleBlockWithItem(MGBlocks.RUBY_ORE.get(), DIAMOND_ORE_STYLE);
    }
}
