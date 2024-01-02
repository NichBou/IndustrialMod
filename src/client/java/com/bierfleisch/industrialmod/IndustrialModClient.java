package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.network.packet.ModNetworkPacketRegister;
import com.bierfleisch.industrialmod.register.IndustrialModScreenRegister;
import com.bierfleisch.industrialmod.block.ModBlockRegister;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.render.RenderLayer;

public class IndustrialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlockRegister.PIPE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlockRegister.TANK_BLOCK, RenderLayer.getCutout());

        IndustrialModScreenRegister.registerAll();

        ClientPlayNetworking.registerGlobalReceiver(ModNetworkPacketRegister.RADIATION_SYNC_ID, ((client, handler, buf, responseSender) -> {
            int rad = buf.readInt();

            if (client.player != null) {
                ((IEntityDataSaver) client.player).getPersistentData().putInt("radiation", rad);
            }

        }));
    }
}