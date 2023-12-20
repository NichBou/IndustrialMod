package com.bierfleisch.industrialmod.render;

import com.bierfleisch.industrialmod.block.entity.fluid.functional.pump.PumpBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PumpBlockEntityRenderer implements BlockEntityRenderer<PumpBlockEntity> {
    @Override
    public void render(PumpBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        RenderSystem.setShaderTexture(0, new Identifier(""));


    }
}
