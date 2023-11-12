package com.bierfleisch.industrialmod.block.entity;

import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PumpBlockEntity extends PipeBlockEntity {
    private static final int PRESSURE_INCREASE = 10;

    public PumpBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.PUMP_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void updateState() {
        BlockState state = getUpdatedState(this.world.getBlockState(this.pos));
        this.world.setBlockState(this.pos, state);
    }

    private BlockState getUpdatedState(BlockState state) {
        //return state.with(FILLED, !connectedNeighbors.isEmpty());
        return state;
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state) {
        super.tick(world, pos, state);
    }
}
