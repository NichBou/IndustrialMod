package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.item.IndustrialModRawMaterialItems;
import com.bierfleisch.industrialmod.item.IndustrialModToolItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IndustrialModItemGroupRegister {
    public static final ItemGroup BLOCK_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(IndustrialModBlockRegister.PUMP_BLOCK_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".block_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(IndustrialModBlockRegister.PUMP_BLOCK_ITEM);
                entries.add(IndustrialModBlockRegister.PIPE_BLOCK_ITEM);
                entries.add(IndustrialModBlockRegister.TANK_BLOCK_ITEM);


            })
            .build();

    public static final ItemGroup TOOL_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(IndustrialModToolItems.PRESSURE_GAUGE_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".tool_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(IndustrialModToolItems.PRESSURE_GAUGE_ITEM);
                entries.add(IndustrialModToolItems.WRENCH_ITEM);
            })
            .build();

    public static final ItemGroup URANIUM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(IndustrialModRawMaterialItems.RAW_URANIUM_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".uranium_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(IndustrialModBlockRegister.URANIUM_ORE_BLOCK_ITEM);
                entries.add(IndustrialModRawMaterialItems.RAW_URANIUM_ITEM);
                entries.add(IndustrialModBlockRegister.PLUTONIUM_ORE_BLOCK_ITEM);
                entries.add(IndustrialModRawMaterialItems.RAW_PLUTONIUM_ITEM);
                entries.add(IndustrialModRawMaterialItems.PLUTONIUM_INGOT);
            })
            .build();




    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "block_item_group"), BLOCK_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "tool_item_group"), TOOL_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "uranium_item_group"), URANIUM_GROUP);
    }
}
