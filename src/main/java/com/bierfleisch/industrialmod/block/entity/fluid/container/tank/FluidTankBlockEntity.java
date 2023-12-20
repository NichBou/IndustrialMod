package com.bierfleisch.industrialmod.block.entity.fluid.container.tank;

import com.bierfleisch.industrialmod.block.entity.fluid.container.FluidContainerBlockEntity;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class FluidTankBlockEntity extends FluidContainerBlockEntity {
    public FluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.TANK_BLOCK_ENTITY, pos, state);
    }
}
