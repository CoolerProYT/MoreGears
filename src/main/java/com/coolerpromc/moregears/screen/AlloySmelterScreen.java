package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class AlloySmelterScreen extends AbstractContainerScreen<AlloySmelterMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MoreGears.MODID, "textures/gui/alloy_smelter_gui.png");

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
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderEnergyBar(pGuiGraphics, x, y);
        renderProgressArrow(pGuiGraphics, x, y);
        renderEnergyGeneration(pGuiGraphics, x, y);
    }

    private void renderEnergyBar(GuiGraphics guiGraphics, int x, int y) {
        int energyScaled = menu.getEnergyStoredScaled();
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 9, y + 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled, 256, 256);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 99, y + 30, 176, 18, 20, menu.getScaledProgress(), 256, 256);
        }
    }

    private void renderEnergyGeneration(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isGeneratingEnergy()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 33, y + 44 + menu.getEnergyProgress(), 176, menu.getEnergyProgress(), 12, 18 - menu.getEnergyProgress(), 256, 256);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.renderTooltip(pGuiGraphics, pMouseX, pMouseY);

        int energyStored = this.menu.getEnergy();
        int maxEnergy = this.menu.getMaxEnergy();

        Component text = Component.translatable("gui.moregears.energy_stored", MGEnergyStorage.convertEnergyToString(energyStored), MGEnergyStorage.convertEnergyToString(maxEnergy));
        if(isHovering(9, 13, 14, 58, pMouseX, pMouseY)) {
            pGuiGraphics.setTooltipForNextFrame(this.font, text, pMouseX, pMouseY);
        }
    }
}