package com.bierfleisch.industrialmod.register.item;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.item.IndustrialModToolItems;
import com.bierfleisch.industrialmod.item.tool.PressureGaugeItem;
import com.bierfleisch.industrialmod.item.tool.WrenchItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IndustrialModToolItemRegister {
    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Tool Items");

        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "pressure_gauge_item"), IndustrialModToolItems.PRESSURE_GAUGE_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "wrench_item"), IndustrialModToolItems.WRENCH_ITEM);
    }
}
