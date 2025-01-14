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
        final ResourceLocation IRON_ORE_STYLE = textureLoc("template_iron_ore_tint");
        final ResourceLocation GOLD_ORE_STYLE = textureLoc("template_gold_ore_tint");
        final ResourceLocation DIAMOND_ORE_STYLE = textureLoc("template_diamond_ore_tint");
        final ResourceLocation EMERALD_ORE_STYLE = textureLoc("template_emerald_ore_tint");
        final ResourceLocation REDSTONE_ORE_STYLE = textureLoc("template_redstone_ore_tint");

        simpleOreBlockWithItem(MGBlocks.TIN_ORE, IRON_ORE_STYLE, MGOreTypes.STONE);
        simpleOreBlockWithItem(MGBlocks.DEEPSLATE_TIN_ORE, IRON_ORE_STYLE, MGOreTypes.DEEPSLATE);
        simpleOreBlockWithItem(MGBlocks.RUBY_ORE, EMERALD_ORE_STYLE, MGOreTypes.STONE);
        simpleOreBlockWithItem(MGBlocks.DEEPSLATE_RUBY_ORE, EMERALD_ORE_STYLE, MGOreTypes.DEEPSLATE);
        simpleOreBlockWithItem(MGBlocks.NETHER_TITANIUM_ORE, DIAMOND_ORE_STYLE, MGOreTypes.NETHER);
        simpleOreBlockWithItem(MGBlocks.END_ENDERITE_ORE, REDSTONE_ORE_STYLE, MGOreTypes.END);

        horizontalBlock(MGBlocks.ALLOY_SMELTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/alloy_smelter")));
        simpleBlockItem(MGBlocks.ALLOY_SMELTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/alloy_smelter")));
    }

    private <T extends Block> void simpleOreBlockWithItem(DeferredBlock<T> block, ResourceLocation texture, MGOreTypes types){
        ResourceLocation blockTexture = switch (types){
            case MGOreTypes.STONE -> mcLoc("block/stone");
            case MGOreTypes.DEEPSLATE -> mcLoc("block/deepslate");
            case MGOreTypes.NETHER -> mcLoc("block/netherrack");
            case MGOreTypes.END -> mcLoc("block/end_stone");
        };

        simpleBlockWithItem(block.get(), models().withExistingParent("block/" + block.getId().getPath(), mcLoc("block/block"))
                .renderType("cutout")
                .texture("layer0", blockTexture)
                .texture("layer1", texture)
                .texture("particle", blockTexture)
                .element().from(0,0,0).to(16,16,16)
                .face(Direction.NORTH).uvs(0,0,16,16).texture("#layer0").cullface(Direction.NORTH).tintindex(0).end()
                .face(Direction.EAST).uvs(0,0,16,16).texture("#layer0").cullface(Direction.EAST).tintindex(0).end()
                .face(Direction.SOUTH).uvs(0,0,16,16).texture("#layer0").cullface(Direction.SOUTH).tintindex(0).end()
                .face(Direction.WEST).uvs(0,0,16,16).texture("#layer0").cullface(Direction.WEST).tintindex(0).end()
                .face(Direction.UP).uvs(0,0,16,16).texture("#layer0").cullface(Direction.UP).tintindex(0).end()
                .face(Direction.DOWN).uvs(0,0,16,16).texture("#layer0").cullface(Direction.DOWN).tintindex(0).end()
                .end()
                .element().from(0,0,0).to(16,16,16)
                .face(Direction.NORTH).uvs(0,0,16,16).texture("#layer1").cullface(Direction.NORTH).tintindex(1).end()
                .face(Direction.EAST).uvs(0,0,16,16).texture("#layer1").cullface(Direction.EAST).tintindex(1).end()
                .face(Direction.SOUTH).uvs(0,0,16,16).texture("#layer1").cullface(Direction.SOUTH).tintindex(1).end()
                .face(Direction.WEST).uvs(0,0,16,16).texture("#layer1").cullface(Direction.WEST).tintindex(1).end()
                .face(Direction.UP).uvs(0,0,16,16).texture("#layer1").cullface(Direction.UP).tintindex(1).end()
                .face(Direction.DOWN).uvs(0,0,16,16).texture("#layer1").cullface(Direction.DOWN).tintindex(1).end()
                .end()
        );
    }

    private ResourceLocation textureLoc(String location){
        return this.modLoc("block/" + location);
    }
}
