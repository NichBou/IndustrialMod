package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.item.tool.PressureGaugeItem;
import com.bierfleisch.industrialmod.item.tool.WrenchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

public class ModToolItems {
    public static final PressureGaugeItem PRESSURE_GAUGE_ITEM = new PressureGaugeItem();
    public static final WrenchItem WRENCH_ITEM = new WrenchItem();



    public static final Item URANIUM_PICKAXE_ITEM = new PickaxeItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_AXE_ITEM = new AxeItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_SHOVEL_ITEM = new ShovelItem(ModToolMaterial.URANIUM, 2,2f, new FabricItemSettings());
    public static final Item URANIUM_SWORD_ITEM = new SwordItem(ModToolMaterial.URANIUM, 6,2f, new FabricItemSettings());
    public static final Item URANIUM_HOE_ITEM = new HoeItem(ModToolMaterial.URANIUM, 0,0f, new FabricItemSettings());



    public static final Item TITANIUM_PICKAXE_ITEM = new PickaxeItem(ModToolMaterial.TITANIUM, 2,2f, new FabricItemSettings());
    public static final Item TITANIUM_AXE_ITEM = new AxeItem(ModToolMaterial.TITANIUM, 2,2f, new FabricItemSettings());
    public static final Item TITANIUM_SHOVEL_ITEM = new ShovelItem(ModToolMaterial.TITANIUM, 2,2f, new FabricItemSettings());
    public static final Item TITANIUM_SWORD_ITEM = new SwordItem(ModToolMaterial.TITANIUM, 6,2f, new FabricItemSettings());
    public static final Item TITANIUM_HOE_ITEM = new HoeItem(ModToolMaterial.TITANIUM, 0,0f, new FabricItemSettings());


    public static final Item LEAD_HELMET_ITEM = new ArmorItem(ModArmorMaterial.LEAD, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item LEAD_CHESTPLATE_ITEM = new  ArmorItem(ModArmorMaterial.LEAD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item LEAD_LEGGINGS_ITEM = new ArmorItem(ModArmorMaterial.LEAD, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item LEAD_BOOTS_ITEM = new ArmorItem(ModArmorMaterial.LEAD, ArmorItem.Type.BOOTS, new FabricItemSettings());

}
