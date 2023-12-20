package com.bierfleisch.industrialmod.block.fluid.transporter.pipe;

import com.bierfleisch.industrialmod.block.entity.fluid.transporter.pipe.PipeBlockEntity;
import com.bierfleisch.industrialmod.block.fluid.container.FluidContainerBlock;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PipeBlock extends FluidContainerBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 6, 0, 16, 10, 16);

    public PipeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PipeBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, IndustrialModBlockEntityRegister.PIPE_BLOCK_ENTITY,
                ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }
}
