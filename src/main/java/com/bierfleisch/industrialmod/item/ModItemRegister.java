package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.item.food.IodinePillItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemRegister {
    public static final Item RAW_URANIUM_ITEM = new Item(new FabricItemSettings());
    public static final Item RAW_PLUTONIUM_ITEM = new Item(new FabricItemSettings());
    public static final Item URANIUM_INGOT_ITEM = new Item(new FabricItemSettings());
    public static final Item PLUTONIUM_INGOT = new Item(new FabricItemSettings());
    public static final IodinePillItem IODINE_PILL_ITEM = new IodinePillItem();
    public static final Item IODINE_ITEM = new Item(new FabricItemSettings());
    public static final Item RAW_LEAD_ITEM = new Item(new FabricItemSettings());
    public static final Item LEAD_INGOT_ITEM = new Item(new FabricItemSettings());
    public static final Item LEAD_ROD_ITEM = new Item(new FabricItemSettings());

    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Items");

        registerItem("raw_plutonium_item", ModItemRegister.RAW_PLUTONIUM_ITEM);
        registerItem("plutonium_ingot", ModItemRegister.PLUTONIUM_INGOT);

        registerItem("iodine_pill_item", ModItemRegister.IODINE_PILL_ITEM);
        registerItem("iodine_item", ModItemRegister.IODINE_ITEM);

        registerItem("raw_lead_item", ModItemRegister.RAW_LEAD_ITEM);
        registerItem("lead_ingot_item", ModItemRegister.LEAD_INGOT_ITEM);
        registerItem("lead_rod_item", ModItemRegister.LEAD_ROD_ITEM);

        registerItem("pressure_gauge_item", ModToolItems.PRESSURE_GAUGE_ITEM);
        registerItem("wrench_item", ModToolItems.WRENCH_ITEM);

        registerItem("raw_uranium_item", ModItemRegister.RAW_URANIUM_ITEM);
        registerItem("uranium_ingot_item", ModItemRegister.URANIUM_INGOT_ITEM);
        registerItem("uranium_pickaxe_item", ModToolItems.URANIUM_PICKAXE_ITEM);
        registerItem("uranium_axe_item", ModToolItems.URANIUM_AXE_ITEM);
        registerItem("uranium_sword_item", ModToolItems.URANIUM_SWORD_ITEM);
        registerItem("uranium_shovel_item", ModToolItems.URANIUM_SHOVEL_ITEM);
        registerItem("uranium_hoe_item", ModToolItems.URANIUM_HOE_ITEM);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, name), item);
    }
}

