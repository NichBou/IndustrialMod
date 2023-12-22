package com.bierfleisch.industrialmod.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

import static com.bierfleisch.industrialmod.IndustrialMod.MOD_ID;

public class RadiationHudOverlay implements HudRenderCallback {
    private static final Identifier EMPTY_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_empty.png");
    private static final Identifier FULL_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_full.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client == null) return;

        int x = client.getWindow().getScaledWidth() / 2 + 9;
        int y = client.getWindow().getScaledHeight() - 50;

        for (int i = 0; i < 10; i++) {
            drawContext.drawTexture(FULL_RADIATION, x + i * 8, y, 0, 0, 9, 9, 9, 9);
        }
    }
}
