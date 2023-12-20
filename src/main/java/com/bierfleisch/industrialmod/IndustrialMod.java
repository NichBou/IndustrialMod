package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.register.*;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndustrialMod implements ModInitializer {
    public static final String MOD_ID = "industrialmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Industrial Mod");

        IndustrialModItemRegister.registerAll();
        IndustrialModBlockRegister.registerAll();
        IndustrialModBlockEntityRegister.registerAll();
        IndustrialModEntityRegister.registerAll();
        IndustrialModItemGroupRegister.registerAll();
        IndustrialModScreenHandlerRegister.registerAll();
        IndustrialModEventRegister.registerAll();

    }
}