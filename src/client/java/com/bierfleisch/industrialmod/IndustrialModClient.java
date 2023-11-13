package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.register.IndustrialModScreenRegister;
import com.bierfleisch.industrialmod.screen.LiquidContainerScreen;
import com.bierfleisch.industrialmod.register.IndustrialModBlockRegister;
import com.bierfleisch.industrialmod.register.IndustrialModScreenHandlerRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class IndustrialModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(IndustrialModBlockRegister.PIPE_BLOCK, RenderLayer.getTranslucent());

		IndustrialModScreenRegister.registerAll();
	}
}