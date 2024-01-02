package com.bierfleisch.industrialmod.block;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.fluid.container.tank.FluidTankBlock;
import com.bierfleisch.industrialmod.block.fluid.transporter.pipe.PipeBlock;
import com.bierfleisch.industrialmod.block.fluid.functional.pump.PumpBlock;
import com.bierfleisch.industrialmod.block.radioactive.ore.PlutoniumOreBlock;

import com.bierfleisch.industrialmod.block.radioactive.ore.UraniumOreBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockRegister {
    public static final PumpBlock PUMP_BLOCK = new PumpBlock(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Item PUMP_BLOCK_ITEM = new BlockItem(PUMP_BLOCK, new FabricItemSettings());

    public static final PipeBlock PIPE_BLOCK = new PipeBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque());
    public static final Item PIPE_BLOCK_ITEM = new BlockItem(PIPE_BLOCK, new FabricItemSettings());

    public static final FluidTankBlock TANK_BLOCK = new FluidTankBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque());
    public static final Item TANK_BLOCK_ITEM = new BlockItem(TANK_BLOCK, new FabricItemSettings());


    public static final Block URANIUM_ORE_BLOCK = new UraniumOreBlock(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Item URANIUM_ORE_BLOCK_ITEM = new BlockItem(URANIUM_ORE_BLOCK, new FabricItemSettings());
    public static final Block URANIUM_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Item URANIUM_BLOCK_ITEM = new BlockItem(URANIUM_BLOCK, new FabricItemSettings());


    public static final PlutoniumOreBlock PLUTONIUM_ORE_BLOCK = new PlutoniumOreBlock(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Item PLUTONIUM_ORE_BLOCK_ITEM = new BlockItem(PLUTONIUM_ORE_BLOCK, new FabricItemSettings());


    public static final Block LEAD_ORE_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Item LEAD_ORE_BLOCK_ITEM = new BlockItem(LEAD_ORE_BLOCK, new FabricItemSettings());

    public static final Block LEAD_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Item LEAD_BLOCK_ITEM = new BlockItem(LEAD_BLOCK, new FabricItemSettings());


    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Blocks");

        registerBlock("pump_block", PUMP_BLOCK, PUMP_BLOCK_ITEM);
        registerBlock("pipe_block", PIPE_BLOCK, PIPE_BLOCK_ITEM);
        registerBlock("tank_block", TANK_BLOCK, TANK_BLOCK_ITEM);
        registerBlock("uranium_ore_block", URANIUM_ORE_BLOCK, URANIUM_ORE_BLOCK_ITEM);
        registerBlock("uranium_block", URANIUM_BLOCK, URANIUM_BLOCK_ITEM);
        registerBlock("plutonium_ore_block", PLUTONIUM_ORE_BLOCK, PLUTONIUM_ORE_BLOCK_ITEM);
        registerBlock("lead_ore_block", LEAD_ORE_BLOCK, LEAD_ORE_BLOCK_ITEM);
        registerBlock("lead_block", LEAD_BLOCK, LEAD_BLOCK_ITEM);
    }

    private static void registerBlock(String path, Block block, Item blockItem) {
        Registry.register(Registries.BLOCK, new Identifier(IndustrialMod.MOD_ID, path), block);
        Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, path), blockItem);
    }
}
