package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class AlloySmelterScreen extends AbstractContainerScreen<AlloySmelterMenu> {
    private static final Identifier TEXTURE = Constants.id("textures/gui/alloy_smelter_gui.png");

    public AlloySmelterScreen(AlloySmelterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelX = 56;
        this.titleLabelY = 5;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderEnergyBar(graphics, x, y);
        renderProgressArrow(graphics, x, y);
        renderEnergyGeneration(graphics, x, y);
    }

    private void renderEnergyBar(GuiGraphicsExtractor guiGraphics, int x, int y) {
        int energyScaled = menu.getEnergyStoredScaled();
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 9, y + 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled, 256, 256);
    }

    private void renderProgressArrow(GuiGraphicsExtractor guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 99, y + 30, 176, 18, 20, menu.getScaledProgress(), 256, 256);
        }
    }

    private void renderEnergyGeneration(GuiGraphicsExtractor guiGraphics, int x, int y) {
        if(menu.isGeneratingEnergy()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 33, y + 44 + menu.getEnergyProgress(), 176, menu.getEnergyProgress(), 12, 18 - menu.getEnergyProgress(), 256, 256);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.extractRenderState(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        int energyStored = this.menu.getEnergy();
        int maxEnergy = this.menu.getMaxEnergy();

        Component text = Component.translatable("gui.moregears.energy_stored", MGEnergyStorage.convertEnergyToString(energyStored), MGEnergyStorage.convertEnergyToString(maxEnergy));
        if(isHovering(9, 13, 14, 58, pMouseX, pMouseY)) {
            pGuiGraphics.setTooltipForNextFrame(this.font, text, pMouseX, pMouseY);
        }
    }
}