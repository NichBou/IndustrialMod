package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import com.bierfleisch.industrialmod.register.IndustrialModBlockRegister;
import com.bierfleisch.industrialmod.register.IndustrialModItemRegister;
import com.bierfleisch.industrialmod.register.IndustrialModScreenHandlerRegister;
import net.fabricmc.api.ModInitializer;

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
		IndustrialModBlockEntityRegister.registerAll();
		IndustrialModScreenHandlerRegister.registerAll();
	}
}