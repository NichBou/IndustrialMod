package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.fluid.ModFluids;
import com.bierfleisch.industrialmod.register.IndustrialModNetworkPacketRegister;
import com.bierfleisch.industrialmod.register.IndustrialModScreenRegister;
import com.bierfleisch.industrialmod.register.IndustrialModBlockRegister;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class IndustrialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(IndustrialModBlockRegister.PIPE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IndustrialModBlockRegister.TANK_BLOCK, RenderLayer.getCutout());

        IndustrialModScreenRegister.registerAll();

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_OIL, ModFluids.FLOWING_OIL,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA0A0A0
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_OIL, ModFluids.FLOWING_OIL);

        ClientPlayNetworking.registerGlobalReceiver(IndustrialModNetworkPacketRegister.RADIATION_SYNC_ID, ((client, handler, buf, responseSender) -> {
            int rad = buf.readInt();

            if (client.player != null) {
                ((IEntityDataSaver) client.player).getPersistentData().putInt("radiation", rad);
            }
        }));
    }
}