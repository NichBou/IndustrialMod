package com.bierfleisch.industrialmod.screen;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.screen.LiquidContainerScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerRegister {
    public static final ScreenHandlerType<LiquidContainerScreenHandler> LIQUID_CONTAINER_SCREEN_HANDLER =
            new ScreenHandlerType<>(LiquidContainerScreenHandler::new, FeatureFlags.VANILLA_FEATURES);


    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Screen Handlers");

        registerScreenHandler("liquid_container", LIQUID_CONTAINER_SCREEN_HANDLER);
    }

    private static void registerScreenHandler(String name, ScreenHandlerType screenHandlerType) {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(IndustrialMod.MOD_ID, name), screenHandlerType);
    }
}
