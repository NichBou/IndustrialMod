package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.item.tool.PressureGaugeItem;
import com.bierfleisch.industrialmod.item.tool.WrenchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

import javax.xml.namespace.QName;

public class IndustrialModToolItems {
    public static final PressureGaugeItem PRESSURE_GAUGE_ITEM = new PressureGaugeItem();
    public static final WrenchItem WRENCH_ITEM = new WrenchItem();



    public static final Item URANIUM_PICKAXE_ITEM = new PickaxeItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_AXE_ITEM = new AxeItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_SHOVEL_ITEM = new ShovelItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_SWORD_ITEM = new SwordItem(ModToolMaterial.URANIUM, 6,2f, new FabricItemSettings());
    public static final Item URANIUM_HOE_ITEM = new HoeItem(ModToolMaterial.URANIUM, 0,0f, new FabricItemSettings());
}
