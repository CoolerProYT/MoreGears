package com.coolerpromc.moregears.screen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGEnergyStorage;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlloySmelterScreen extends HandledScreen<AlloySmelterMenu> {
    private static final Identifier TEXTURE = Identifier.of(MoreGears.MODID, "textures/gui/alloy_smelter_gui.png");

    public AlloySmelterScreen(AlloySmelterMenu handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.playerInventoryTitleY = 74;
        this.titleX = 56;
        this.titleY = 5;
    }

    @Override
    protected void drawBackground(DrawContext pGuiGraphics, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        pGuiGraphics.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        renderEnergyBar(pGuiGraphics, x, y);
        renderProgressArrow(pGuiGraphics, x, y);
        renderEnergyGeneration(pGuiGraphics, x, y);
    }

    private void renderEnergyBar(DrawContext guiGraphics, int x, int y) {
        int energyScaled = handler.getEnergyStoredScaled();
        guiGraphics.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x + 9, y + 13 + (58 - energyScaled), 176, 101 - energyScaled, 14, energyScaled, 256, 256);
    }

    private void renderProgressArrow(DrawContext guiGraphics, int x, int y) {
        if(handler.isCrafting()) {
            guiGraphics.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x + 99, y + 30, 176, 18, 20, handler.getScaledProgress(), 256, 256);
        }
    }

    private void renderEnergyGeneration(DrawContext guiGraphics, int x, int y) {
        if(handler.isGeneratingEnergy()) {
            guiGraphics.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x + 33, y + 44 + handler.getEnergyProgress(), 176, handler.getEnergyProgress(), 12, 18 - handler.getEnergyProgress(), 256, 256);
        }
    }

    @Override
    public void render(DrawContext pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.drawMouseoverTooltip(pGuiGraphics, pMouseX, pMouseY);

        long energyStored = this.handler.getEnergy();
        long maxEnergy = this.handler.getMaxEnergy();

        Text text = Text.translatable("gui.moregears.energy_stored", MGEnergyStorage.convertEnergyToString(energyStored), MGEnergyStorage.convertEnergyToString(maxEnergy));
        if(isPointWithinBounds(9, 13, 14, 58, pMouseX, pMouseY)) {
            pGuiGraphics.drawTooltip(this.textRenderer, text, pMouseX, pMouseY);
        }
    }
}
