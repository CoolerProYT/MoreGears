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
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.display.SlotDisplayContexts;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.context.ContextParameterMap;
import org.jetbrains.annotations.Nullable;

public class AlloySmeltingCategory implements IRecipeCategory<AlloySmeltingRecipe> {
    public static final Identifier UID = Identifier.of(MoreGears.MODID, "alloy_smelting");
    public static final Identifier TEXTURE = Identifier.of(MoreGears.MODID, "textures/gui/compat/alloy_smelter_gui.png");
    public static final IRecipeType<AlloySmeltingRecipe> ALLOY_SMELTING_TYPE = IRecipeType.create(UID, AlloySmeltingRecipe.class);
    private int tickCount = 0;

    private final IDrawable background;
    private final IDrawable icon;

    public AlloySmeltingCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 0, 140, 76);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MGBlocks.ALLOY_SMELTER));
    }

    @Override
    public IRecipeType<AlloySmeltingRecipe> getRecipeType() {
        return ALLOY_SMELTING_TYPE;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.moregears.alloy_smelter");
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void draw(AlloySmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        guiGraphics.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, 0, 0, 4, 4, 140, 76, 256, 256);

        tickCount++;

        int arrowHeight = (tickCount % 600) * 25 / 600;
        guiGraphics.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, 95, 26, 176, 18, 20, arrowHeight, 256, 256);

        int energyScaled = (int) Math.ceil((double) 1000 / 100000 * 58);
        guiGraphics.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, 5, 9 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled, 256, 256);

        int energyGeneration = (tickCount % 2000) * 18 / 2000;
        guiGraphics.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, 29, 40 + energyGeneration, 176, energyGeneration, 12, 18 - energyGeneration, 256, 256);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AlloySmeltingRecipe recipe, IFocusGroup focuses) {
        ContextParameterMap contextMap = SlotDisplayContexts.createParameters(MinecraftClient.getInstance().world);
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 19).add(new ItemStack(Items.COAL));
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 19).addItemStacks(recipe.getInputItems().getFirst().ingredient().toDisplay().getStacks(contextMap).stream().peek(stack -> stack.setCount(recipe.getInputItems().getFirst().count())).toList());
        builder.addSlot(RecipeIngredientRole.INPUT, 115, 19).addItemStacks(recipe.getInputItems().get(1).ingredient().toDisplay().getStacks(contextMap).stream().peek(stack -> stack.setCount(recipe.getInputItems().get(1).count())).toList());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 51).add(recipe.getOutput().getFirst());
    }
}
