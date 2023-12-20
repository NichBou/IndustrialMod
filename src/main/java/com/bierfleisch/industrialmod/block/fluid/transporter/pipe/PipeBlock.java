package com.bierfleisch.industrialmod.block.fluid.transporter.pipe;

import com.bierfleisch.industrialmod.block.entity.fluid.transporter.pipe.PipeBlockEntity;
import com.bierfleisch.industrialmod.block.fluid.container.FluidContainerBlock;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PipeBlock extends FluidContainerBlock {
    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty EAST = Properties.EAST;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty WEST = Properties.WEST;
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;

    public PipeBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
                .with(NORTH, true)
                .with(EAST, true)
                .with(SOUTH, true)
                .with(WEST, true)
                .with(UP, true)
                .with(DOWN, true)
        );
    }

    @Override
    public ActionResult onUseWithWrench(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        switch (hit.getSide()) {
            case NORTH -> world.setBlockState(pos, state.cycle(NORTH));
            case EAST -> world.setBlockState(pos, state.cycle(EAST));
            case SOUTH -> world.setBlockState(pos, state.cycle(SOUTH));
            case WEST -> world.setBlockState(pos, state.cycle(WEST));
            case UP -> world.setBlockState(pos, state.cycle(UP));
            case DOWN -> world.setBlockState(pos, state.cycle(DOWN));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
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
