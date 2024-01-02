package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.screen.LiquidContainerScreen;
import com.bierfleisch.industrialmod.screen.ModScreenHandlerRegister;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class IndustrialModScreenRegister {
    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Screens");

        HandledScreens.register(ModScreenHandlerRegister.LIQUID_CONTAINER_SCREEN_HANDLER, LiquidContainerScreen::new);
    }
}
