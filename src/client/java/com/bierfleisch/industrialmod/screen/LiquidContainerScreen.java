package com.bierfleisch.industrialmod.screen;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LiquidContainerScreen extends HandledScreen<LiquidContainerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(IndustrialMod.MOD_ID, "textures/gui/liquid_container_gui.png");
    LiquidContainerScreenHandler screenHandler;

    public LiquidContainerScreen(LiquidContainerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        screenHandler = handler;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);

        context.drawText(textRenderer, "Pressure: " + screenHandler.getPressure(), getCenteredWidth(), textRenderer.fontHeight + titleY, 4210752, false);
        context.drawText(textRenderer, "Flow: " + screenHandler.getFlow(), getCenteredWidth(), textRenderer.fontHeight * 2 + titleY, 4210752, false);
        context.drawText(textRenderer, "Amount of connected: " + screenHandler.getConnectedAmount(), getCenteredWidth(), textRenderer.fontHeight * 3 + titleY, 4210752, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        drawBackground(context, delta, mouseX, mouseY);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = getCenteredWidth();
        playerInventoryTitleY = 1000;
    }

    private int getCenteredWidth() {
        return (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
