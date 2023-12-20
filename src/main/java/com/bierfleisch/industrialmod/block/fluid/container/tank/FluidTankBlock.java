package com.bierfleisch.industrialmod.block.fluid.container.tank;

import com.bierfleisch.industrialmod.block.entity.fluid.container.tank.FluidTankBlockEntity;
import com.bierfleisch.industrialmod.block.fluid.container.FluidContainerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class FluidTankBlock extends FluidContainerBlock {
    public FluidTankBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FluidTankBlockEntity(pos, state);
    }
}
