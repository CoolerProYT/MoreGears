package com.coolerpromc.moregears.compat.jei.category;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import com.coolerpromc.moregears.recipe.MGRecipes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;

public class AlloySmeltingCategory extends AbstractRecipeCategory<RecipeHolder<AlloySmeltingRecipe>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "textures/gui/compat/alloy_smelter_gui.png");
    public static final IRecipeHolderType<AlloySmeltingRecipe> ALLOY_SMELTING_TYPE = IRecipeHolderType.create(MGRecipes.ALLOY_SMELTING_TYPE.get());
    private int tickCount = 0;

    public AlloySmeltingCategory(IGuiHelper helper){
        super(ALLOY_SMELTING_TYPE, Component.translatable("block.moregears.alloy_smelter"), helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MGBlocks.ALLOY_SMELTER.get())), 176, 84);
    }

    @Override
    public void draw(RecipeHolder<AlloySmeltingRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, 0, 0, 0, 0, 176, 84, 256, 256);

        tickCount++;

        int arrowHeight = (tickCount % 600) * 25 / 600;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, 99, 30, 176, 18, 20, arrowHeight, 256, 256);

        int energyScaled = (int) Math.ceil((double) 1000 / 100000 * 58);
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, 9, 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled, 256, 256);

        int energyGeneration = (tickCount % 2000) * 18 / 2000;
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, 33, 44 + energyGeneration, 176, energyGeneration, 12, 18 - energyGeneration, 256, 256);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<AlloySmeltingRecipe> recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 23).add(new ItemStack(Items.COAL));
        builder.addSlot(RecipeIngredientRole.INPUT, 83, 23).add(new ItemStack(recipe.value().inputItems().get(0).ingredient().getValues().get(0), recipe.value().inputItems().get(0).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 119, 23).add(new ItemStack(recipe.value().inputItems().get(1).ingredient().getValues().get(0), recipe.value().inputItems().get(1).count()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 101, 55).add(recipe.value().output().getFirst());
    }
}