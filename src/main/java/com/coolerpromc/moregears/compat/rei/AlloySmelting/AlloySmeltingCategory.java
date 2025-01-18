package com.coolerpromc.moregears.compat.rei.AlloySmelting;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlloySmeltingCategory implements DisplayCategory<AlloySmeltingRecipeDisplay> {
    public static final CategoryIdentifier<? extends AlloySmeltingRecipeDisplay> ALLOY_SMELTING = CategoryIdentifier.of(MoreGears.MODID, "alloy_smelting");
    public static final Identifier TEXTURE = Identifier.of(MoreGears.MODID, "textures/gui/compat/alloy_smelter_gui.png");
    private int tickCount = 0;

    @Override
    public CategoryIdentifier<? extends AlloySmeltingRecipeDisplay> getCategoryIdentifier() {
        return ALLOY_SMELTING;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.moregears.alloy_smelter");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(MGBlocks.ALLOY_SMELTER);
    }

    @Override
    public List<Widget> setupDisplay(AlloySmeltingRecipeDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 88, bounds.getCenterY() - 42);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, startPoint.x, startPoint.y,176, 84));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 31, startPoint.y + 23)).entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 83, startPoint.y + 23)).entries(display.getInputEntries().get(1)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 119, startPoint.y + 23)).entries(display.getInputEntries().get(2)).markInput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 101, startPoint.y + 55)).entries(display.getOutputEntries().get(0)).markOutput());

        widgets.add(new Widget() {
            @Override
            public List<? extends Element> children() {
                return new ArrayList<>();
            }

            @Override
            public void render(DrawContext guiGraphics, int i, int i1, float v) {
                MinecraftClient.getInstance().getTextureManager().bindTexture(TEXTURE);

                tickCount++;

                int arrowHeight = (tickCount % 600) * 25 / 600;
                guiGraphics.drawTexture(TEXTURE, startPoint.x + 99, startPoint.y + 30, 176, 18, 20, arrowHeight);

                int energyScaled = (int) Math.ceil((double) 1000 / 100000 * 58);
                guiGraphics.drawTexture(TEXTURE, startPoint.x + 9, startPoint.y + 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled);

                int energyGeneration = (tickCount % 2000) * 18 / 2000;
                guiGraphics.drawTexture(TEXTURE, startPoint.x + 33, startPoint.y + 44 + energyGeneration, 176, energyGeneration, 12, 18 - energyGeneration);
            }

        });

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 84;
    }
}