package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.fluid.ModFluids;
import com.bierfleisch.industrialmod.item.IndustrialModToolItems;
import com.bierfleisch.industrialmod.register.*;
import com.bierfleisch.industrialmod.register.item.IndustrialModRawMaterialRegister;
import com.bierfleisch.industrialmod.register.item.IndustrialModToolItemRegister;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndustrialMod implements ModInitializer {
    public static final String MOD_ID = "industrialmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Industrial Mod");

        IndustrialModRawMaterialRegister.registerAll();
        IndustrialModToolItemRegister.registerAll();
        IndustrialModBlockRegister.registerAll();
        IndustrialModBlockEntityRegister.registerAll();
        IndustrialModEntityRegister.registerAll();
        IndustrialModItemGroupRegister.registerAll();
        IndustrialModScreenHandlerRegister.registerAll();
        IndustrialModEventRegister.registerAll();

        ModFluids.register();

    }
}