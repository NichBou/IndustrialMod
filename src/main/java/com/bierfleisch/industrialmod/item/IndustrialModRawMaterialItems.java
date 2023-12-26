package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.item.food.IodinePillItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class IndustrialModRawMaterialItems {
    public static final Item RAW_URANIUM_ITEM = new Item(new FabricItemSettings());
    public static final Item RAW_PLUTONIUM_ITEM = new Item(new FabricItemSettings());
    public static final Item PLUTONIUM_INGOT = new Item(new FabricItemSettings());
    public static final IodinePillItem IODINE_PILL_ITEM = new IodinePillItem();
}

