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



        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "uranium_pickaxe_item"), IndustrialModToolItems.URANIUM_PICKAXE_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "uranium_axe_item"), IndustrialModToolItems.URANIUM_AXE_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "uranium_sword_item"), IndustrialModToolItems.URANIUM_SWORD_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "uranium_shovel_item"), IndustrialModToolItems.URANIUM_SHOVEL_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "uranium_hoe_item"), IndustrialModToolItems.URANIUM_HOE_ITEM);
    }
}
