package com.bierfleisch.industrialmod.mixin.client;

import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

import static com.bierfleisch.industrialmod.IndustrialMod.MOD_ID;

@Mixin(InGameHud.class)
public abstract class RenderHudStatusBarMixin {
    @Unique
    private static final Identifier EMPTY_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_empty.png");

    @Unique
    private static final Identifier FULL_RADIATION =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_full.png");

    @Unique
    private static final Identifier RADIATION_SYMBOL =
            new Identifier(MOD_ID, "textures/gui/sprites/hud/radiation/radiation_symbol.png");

    @Shadow private int scaledWidth;
    @Shadow private int scaledHeight;
    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract TextRenderer getTextRenderer();

    @Inject(at = @At("TAIL"), method = "renderStatusBars")
    private void renderStatusBars(DrawContext drawContext, CallbackInfo info) {
        int x = this.scaledWidth / 2;
        int y = this.scaledHeight - 49;

        int radiation = ((IEntityDataSaver)client.player).getPersistentData().getInt("radiation");

        if (client.player != null && client.player.isSubmergedInWater()) {
            y -= 9;
        }



        drawContext.drawText(this.getTextRenderer(), String.valueOf(radiation),
                this.scaledWidth / 2 + 20, this.scaledHeight / 2 - 3,
                ColorHelper.Argb.getArgb(255, 0, 0, 0), false);

        final int maxPixelWidth = 69;

        int pixelWidth = (int)(((float)radiation / 1000) * maxPixelWidth);

        if (radiation > 10) {
            drawContext.drawTexture(RADIATION_SYMBOL, x + 10, y, 0, 0, 8, 8, 8, 8);

            drawContext.fill(x + 20, y, x + pixelWidth + 20, y + 6, ColorHelper.Argb.getArgb(255, 200, 200, 0));
            drawContext.drawBorder(x + 20, y, maxPixelWidth, 6, ColorHelper.Argb.getArgb(255, 0, 0, 0));
        }
    }
}
