package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.screen.LiquidContainerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class IndustrialModScreenHandlerRegister {
    public static final ScreenHandlerType<LiquidContainerScreenHandler> LIQUID_CONTAINER_SCREEN_HANDLER =
            new ScreenHandlerType<>(LiquidContainerScreenHandler::new, FeatureFlags.VANILLA_FEATURES);


    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Screen Handlers");

        Registry.register(Registries.SCREEN_HANDLER, new Identifier(IndustrialMod.MOD_ID, "liquid_container"), LIQUID_CONTAINER_SCREEN_HANDLER);
    }
}
