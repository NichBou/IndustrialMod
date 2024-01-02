package com.bierfleisch.industrialmod.block.entity.fluid.transporter.pipe;

import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import com.bierfleisch.industrialmod.block.entity.fluid.container.FluidContainerBlockEntity;
import com.bierfleisch.industrialmod.block.fluid.container.FluidContainerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class PipeBlockEntity extends FluidContainerBlockEntity {
    public PipeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityRegister.PIPE_BLOCK_ENTITY, pos, state);
    }

    protected PipeBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    private BlockState getUpdatedState(BlockState state) {
        return state.with(FluidContainerBlock.FULL, this.getFlow() > 0);
    }
}
