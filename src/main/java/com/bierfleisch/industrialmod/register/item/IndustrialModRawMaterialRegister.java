package com.bierfleisch.industrialmod.register.item;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.item.IndustrialModRawMaterialItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IndustrialModRawMaterialRegister {
    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Raw Material Items");

        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "raw_uranium_item"), IndustrialModRawMaterialItems.RAW_URANIUM_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "raw_plutonium_item"), IndustrialModRawMaterialItems.RAW_PLUTONIUM_ITEM);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "plutonium_ingot"), IndustrialModRawMaterialItems.PLUTONIUM_INGOT);
    }
}
