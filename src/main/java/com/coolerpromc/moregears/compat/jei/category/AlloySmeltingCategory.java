package com.coolerpromc.moregears.compat.jei.category;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.recipe.AlloySmeltingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class AlloySmeltingCategory implements IRecipeCategory<AlloySmeltingRecipe> {
    public static final Identifier UID = Identifier.of(MoreGears.MODID, "alloy_smelting");
    public static final Identifier TEXTURE = Identifier.of(MoreGears.MODID, "textures/gui/compat/alloy_smelter_gui.png");
    public static final RecipeType<AlloySmeltingRecipe> ALLOY_SMELTING_TYPE = new RecipeType<>(UID, AlloySmeltingRecipe.class);
    private int tickCount = 0;

    private final IDrawable background;
    private final IDrawable icon;

    public AlloySmeltingCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 84);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MGBlocks.ALLOY_SMELTER));
    }

    @Override
    public RecipeType<AlloySmeltingRecipe> getRecipeType() {
        return ALLOY_SMELTING_TYPE;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.moregears.alloy_smelter");
    }

    @SuppressWarnings("removal")
    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void draw(AlloySmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        MinecraftClient.getInstance().getTextureManager().bindTexture(TEXTURE);

        tickCount++;

        int arrowHeight = (tickCount % 600) * 25 / 600;
        guiGraphics.drawTexture(TEXTURE, 99, 30, 176, 18, 20, arrowHeight);

        int energyScaled = (int) Math.ceil((double) 1000 / 100000 * 58);
        guiGraphics.drawTexture(TEXTURE, 9, 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled);

        int energyGeneration = (tickCount % 2000) * 18 / 2000;
        guiGraphics.drawTexture(TEXTURE, 33, 44 + energyGeneration, 176, energyGeneration, 12, 18 - energyGeneration);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AlloySmeltingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 23).addItemStack(new ItemStack(Items.COAL));
        builder.addSlot(RecipeIngredientRole.INPUT, 83, 23).addItemStack(new ItemStack(recipe.getInputItems().get(0).getMatchingStacks()[0].getItem()));
        builder.addSlot(RecipeIngredientRole.INPUT, 119, 23).addItemStack(new ItemStack(recipe.getInputItems().get(1).getMatchingStacks()[0].getItem()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 101, 55).addItemStack(recipe.getOutput());
    }
}