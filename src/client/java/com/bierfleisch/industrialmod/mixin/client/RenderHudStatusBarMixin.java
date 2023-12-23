package com.bierfleisch.industrialmod.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.bierfleisch.industrialmod.IndustrialMod.MOD_ID;

@Mixin(InGameHud.class)
public class RenderHudStatusBarMixin {
    @Unique
    private static final Identifier EMPTY_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_empty.png");

    @Unique
    private static final Identifier FULL_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_full.png");

    @Shadow private int scaledWidth;
    @Shadow private int scaledHeight;
    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At("TAIL"), method = "renderStatusBars")
    private void renderStatusBars(DrawContext drawContext, CallbackInfo info) {
        int x = this.scaledWidth / 2 + 10;
        int y = this.scaledHeight - 49;

        if (client.player != null && client.player.isSubmergedInWater()) {
            y -= 9;
        }

        for (int i = 0; i < 10; i++) {
            drawContext.drawTexture(FULL_RADIATION, x + i * 8, y, 0, 0, 9, 9, 9, 9);
        }

        for (int i = 0; i < 10; i++) {
            drawContext.drawTexture(FULL_RADIATION, x + i * 8, y, 0, 0, 9, 9, 9, 9);
        }
    }
}
