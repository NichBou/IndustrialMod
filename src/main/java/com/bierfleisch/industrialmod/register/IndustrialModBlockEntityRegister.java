package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.entity.fluid.container.tank.FluidTankBlockEntity;
import com.bierfleisch.industrialmod.block.entity.fluid.transporter.pipe.PipeBlockEntity;
import com.bierfleisch.industrialmod.block.entity.fluid.functional.pump.PumpBlockEntity;
import com.bierfleisch.industrialmod.block.entity.radioactive.PlutoniumOreBlockEntity;
import com.bierfleisch.industrialmod.block.entity.radioactive.UraniumOreBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IndustrialModBlockEntityRegister {
    public static final BlockEntityType<PumpBlockEntity> PUMP_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(IndustrialMod.MOD_ID, "pump_block_entity"),
            FabricBlockEntityTypeBuilder.create(PumpBlockEntity::new, IndustrialModBlockRegister.PUMP_BLOCK).build()
    );

    public static final BlockEntityType<PipeBlockEntity> PIPE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(IndustrialMod.MOD_ID, "pipe_block_entity"),
            FabricBlockEntityTypeBuilder.create(PipeBlockEntity::new, IndustrialModBlockRegister.PIPE_BLOCK).build()
    );
    public static final BlockEntityType<FluidTankBlockEntity> TANK_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(IndustrialMod.MOD_ID, "tank_block_entity"),
            FabricBlockEntityTypeBuilder.create(FluidTankBlockEntity::new, IndustrialModBlockRegister.TANK_BLOCK).build()
    );

    public static final BlockEntityType<UraniumOreBlockEntity> URANIUM_ORE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(IndustrialMod.MOD_ID, "uranium_ore_block_entity"),
            FabricBlockEntityTypeBuilder.create(UraniumOreBlockEntity::new, IndustrialModBlockRegister.URANIUM_ORE_BLOCK).build()
    );

    public static final BlockEntityType<PlutoniumOreBlockEntity> PLUTONIUM_ORE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(IndustrialMod.MOD_ID, "plutonium_ore_block_entity"),
            FabricBlockEntityTypeBuilder.create(PlutoniumOreBlockEntity::new, IndustrialModBlockRegister.PLUTONIUM_ORE_BLOCK).build()
    );

    public static void registerAll() {
        IndustrialMod.LOGGER.info("Loading Block Entities");
    }
}
