package com.bierfleisch.industrialmod.block.entity;

import com.bierfleisch.industrialmod.block.PipeBlock;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PipeBlockEntity extends LiquidContainerBlockEntity {
    public PipeBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.PIPE_BLOCK_ENTITY, pos, state);
    }

    protected PipeBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected void updateState() {
        BlockState state = getUpdatedState(this.world.getBlockState(this.pos));
        this.world.setBlockState(this.pos, state);
    }

    private BlockState getUpdatedState(BlockState state) {
        return state.with(PipeBlock.FILLED, this.getFlow() > 0);
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state) {
        super.tick(world, pos, state);
    }
}
