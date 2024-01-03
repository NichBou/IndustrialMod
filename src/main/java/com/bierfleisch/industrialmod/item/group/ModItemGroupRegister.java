package com.bierfleisch.industrialmod.item.group;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.ModBlockRegister;
import com.bierfleisch.industrialmod.item.ModItemRegister;
import com.bierfleisch.industrialmod.item.ModToolItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroupRegister {
    public static final ItemGroup BLOCK_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlockRegister.PUMP_BLOCK_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".block_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlockRegister.PUMP_BLOCK_ITEM);
                entries.add(ModBlockRegister.PIPE_BLOCK_ITEM);
                entries.add(ModBlockRegister.TANK_BLOCK_ITEM);


            })
            .build();

    public static final ItemGroup TOOL_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModToolItems.PRESSURE_GAUGE_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".tool_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(ModToolItems.PRESSURE_GAUGE_ITEM);
                entries.add(ModToolItems.WRENCH_ITEM);
            })
            .build();

    public static final ItemGroup URANIUM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItemRegister.RAW_URANIUM_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".uranium_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlockRegister.URANIUM_ORE_BLOCK_ITEM);
                entries.add(ModItemRegister.RAW_URANIUM_ITEM);
                entries.add(ModItemRegister.URANIUM_INGOT_ITEM);
                entries.add(ModBlockRegister.URANIUM_BLOCK_ITEM);
                entries.add(ModToolItems.URANIUM_PICKAXE_ITEM);
                entries.add(ModToolItems.URANIUM_AXE_ITEM);
                entries.add(ModToolItems.URANIUM_SWORD_ITEM);
                entries.add(ModToolItems.URANIUM_SHOVEL_ITEM);
                entries.add(ModToolItems.URANIUM_HOE_ITEM);

                entries.add(ModBlockRegister.LEAD_ORE_BLOCK_ITEM);
                entries.add(ModItemRegister.RAW_LEAD_ITEM);
                entries.add(ModItemRegister.LEAD_INGOT_ITEM);
                entries.add(ModBlockRegister.LEAD_BLOCK_ITEM);
                entries.add(ModItemRegister.LEAD_ROD_ITEM);
                entries.add(ModItemRegister.LEAD_PLATE_ITEM);
                entries.add(ModBlockRegister.LEAD_PLATE_BLOCK_ITEM);

                entries.add(ModBlockRegister.TITANIUM_ORE_BLOCK_ITEM);
                entries.add(ModBlockRegister.TITANIUM_BLOCK_ITEM);
                entries.add(ModItemRegister.RAW_TITANIUM_ITEM);
                entries.add(ModItemRegister.TITANIUM_INGOT_ITEM);
                entries.add(ModItemRegister.TITANIUM_PLATE_ITEM);
                entries.add(ModBlockRegister.TITANIUM_PLATE_BLOCK_ITEM);
                entries.add(ModItemRegister.TITANIUM_ROD_ITEM);
                entries.add(ModToolItems.TITANIUM_PICKAXE_ITEM);
                entries.add(ModToolItems.TITANIUM_AXE_ITEM);
                entries.add(ModToolItems.TITANIUM_SWORD_ITEM);
                entries.add(ModToolItems.TITANIUM_SHOVEL_ITEM);
                entries.add(ModToolItems.TITANIUM_HOE_ITEM);

                entries.add(ModBlockRegister.PLUTONIUM_ORE_BLOCK_ITEM);
                entries.add(ModItemRegister.RAW_PLUTONIUM_ITEM);
                entries.add(ModItemRegister.PLUTONIUM_INGOT_ITEM);
                entries.add(ModBlockRegister.PLUTONIUM_BLOCK_ITEM);


                entries.add(ModItemRegister.IODINE_ITEM);
                entries.add(ModItemRegister.IODINE_PILL_ITEM);
                entries.add(ModBlockRegister.IODINE_BLOCK_ITEM);
            })
            .build();

    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "block_item_group"), BLOCK_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "tool_item_group"), TOOL_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "uranium_item_group"), URANIUM_GROUP);
    }
}
