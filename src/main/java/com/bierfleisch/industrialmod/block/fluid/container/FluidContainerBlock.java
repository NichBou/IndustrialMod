package com.bierfleisch.industrialmod.block.fluid.container;

import com.bierfleisch.industrialmod.block.entity.fluid.container.FluidContainerBlockEntity;
import com.bierfleisch.industrialmod.fluid.FluidType;
import com.bierfleisch.industrialmod.register.IndustrialModItemRegister;
import com.bierfleisch.industrialmod.fluid.BlockFluidSides;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for all blocks being able to
 * receive fluids
 * <br />
 * <br />
 * Usage:
 * <br />
 * Set inputSides dictionary to which sides can receive which fluid.
 */
public abstract class FluidContainerBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty FULL = BooleanProperty.of("full");

    protected final BlockFluidSides blockFluidSides = new BlockFluidSides();

    protected FluidContainerBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(FULL, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FULL);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        var blockEntity = (FluidContainerBlockEntity) world.getBlockEntity(pos);

        blockEntity.neighborUpdate(state, world, pos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        ItemStack usedItem = player.getStackInHand(hand);

        if (usedItem.isOf(IndustrialModItemRegister.PRESSURE_GAUGE_ITEM)) {
            return this.onUseWithPressureGauge(state, world, pos, player, hand, hit);
        }
        if (usedItem.isOf(IndustrialModItemRegister.WRENCH_ITEM)) {
            return this.onUseWithWrench(state, world, pos, player, hand, hit);
        }

        return ActionResult.PASS;
    }

    public ActionResult onUseWithPressureGauge(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

        if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            player.getStackInHand(hand).damage(1, player, p -> {
            });
        }

        return ActionResult.SUCCESS;
    }

    public ActionResult onUseWithWrench(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.PASS;
    }

    public boolean isReceivable(Direction receiveDirection, FluidType fluid) {
        return blockFluidSides.receivable(receiveDirection, fluid);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FULL, false);
    }
}
