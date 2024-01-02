package com.bierfleisch.industrialmod.block.fluid.functional.pump;

import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import com.bierfleisch.industrialmod.block.entity.fluid.functional.pump.PumpBlockEntity;
import com.bierfleisch.industrialmod.block.fluid.functional.FluidFunctionalBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PumpBlock extends FluidFunctionalBlock {
    public PumpBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PumpBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityRegister.PUMP_BLOCK_ENTITY,
                ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }

    @Override
    public ActionResult onUseWithWrench(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;

        //Direction sideDirection = hit.getSide();
        //var current = blockFluidSides.get(sideDirection);
        //current.inputType = current.inputType.next();

        return ActionResult.SUCCESS;
    }
}
