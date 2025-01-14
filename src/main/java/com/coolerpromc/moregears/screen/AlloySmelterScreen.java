package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlloySmelterScreen extends AbstractContainerScreen<AlloySmelterMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "textures/gui/alloy_smelter_gui.png");

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
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderEnergyBar(pGuiGraphics, x, y);
        renderProgressArrow(pGuiGraphics, x, y);
        renderEnergyGeneration(pGuiGraphics, x, y);
    }

    private void renderEnergyBar(GuiGraphics guiGraphics, int x, int y) {
        int energyScaled = menu.getEnergyStoredScaled();
        guiGraphics.blit(TEXTURE, x + 9, y + 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 99, y + 30, 176, 18, 20, menu.getScaledProgress());
        }
    }

    private void renderEnergyGeneration(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isGeneratingEnergy()) {
            guiGraphics.blit(TEXTURE, x + 33, y + 44 + menu.getEnergyProgress(), 176, menu.getEnergyProgress(), 12, 18 - menu.getEnergyProgress());
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
            pGuiGraphics.renderTooltip(this.font, text, pMouseX, pMouseY);
        }
    }
}