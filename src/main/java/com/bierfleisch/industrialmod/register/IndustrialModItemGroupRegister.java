package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IndustrialModItemGroupRegister {
    public static final ItemGroup GENERAL_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(IndustrialModBlockRegister.PUMP_BLOCK_ITEM))
            .displayName(Text.translatable("itemGroup." + IndustrialMod.MOD_ID + ".general_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(IndustrialModBlockRegister.PUMP_BLOCK_ITEM);
                entries.add(IndustrialModBlockRegister.PIPE_BLOCK_ITEM);
            })
            .build();

    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(IndustrialMod.MOD_ID, "general_item_group"), GENERAL_ITEM_GROUP);
    }
}
