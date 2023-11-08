package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.PipeBlock;
import com.bierfleisch.industrialmod.block.PumpBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IndustrialModBlockRegister {
    public static final PumpBlock PUMP_BLOCK = new PumpBlock(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Item PUMP_BLOCK_ITEM = new BlockItem(PUMP_BLOCK, new FabricItemSettings());

    public static final PipeBlock PIPE_BLOCK = new PipeBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque());
    public static final Item PIPE_BLOCK_ITEM = new BlockItem(PIPE_BLOCK, new FabricItemSettings());

    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Blocks");

        register("pump_block", PUMP_BLOCK, PUMP_BLOCK_ITEM);
        register("pipe_block", PIPE_BLOCK, PIPE_BLOCK_ITEM);
    }

    private static void register(String path, Block block, Item blockItem) {
        Registry.register(Registries.BLOCK, new Identifier(IndustrialMod.MOD_ID, path), block);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, path), blockItem);
    }
}
