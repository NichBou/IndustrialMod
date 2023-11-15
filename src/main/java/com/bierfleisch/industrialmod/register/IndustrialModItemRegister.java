package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.item.PressureGaugeItem;
import com.bierfleisch.industrialmod.item.WrenchItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IndustrialModItemRegister {
    public static final PressureGaugeItem PRESSURE_GAUGE_ITEM = new PressureGaugeItem();
    public static final WrenchItem WRENCH_ITEM = new WrenchItem();

    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Items");

        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "pressure_gauge_item"), PRESSURE_GAUGE_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "wrench_item"), WRENCH_ITEM);
    }
}
