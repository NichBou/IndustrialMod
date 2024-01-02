package com.bierfleisch.industrialmod;

import com.bierfleisch.industrialmod.block.ModBlockRegister;
import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import com.bierfleisch.industrialmod.entity.ModEntityRegister;
import com.bierfleisch.industrialmod.event.ModEventRegister;
import com.bierfleisch.industrialmod.item.ModItemRegister;
import com.bierfleisch.industrialmod.item.group.ModItemGroupRegister;
import com.bierfleisch.industrialmod.screen.ModScreenHandlerRegister;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndustrialMod implements ModInitializer {
    public static final String MOD_ID = "industrialmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Industrial Mod");

        ModItemRegister.registerAll();
        ModBlockRegister.registerAll();
        ModBlockEntityRegister.registerAll();
        ModEntityRegister.registerAll();
        ModItemGroupRegister.registerAll();
        ModScreenHandlerRegister.registerAll();
        ModEventRegister.registerAll();

    }
}