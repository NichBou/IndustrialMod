package com.bierfleisch.industrialmod.block;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.entity.LiquidContainerBlockEntity;
import com.bierfleisch.industrialmod.register.IndustrialModItemRegister;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public abstract class LiquidContainerBlock extends BlockWithEntity implements BlockEntityProvider {
    protected LiquidContainerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        var blockEntity = (LiquidContainerBlockEntity) world.getBlockEntity(pos);

        blockEntity.neighborUpdate(state, world, pos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        if (!player.getStackInHand(hand).isOf(IndustrialModItemRegister.PRESSURE_GAUGE_ITEM)) return ActionResult.PASS;

        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

        if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            player.getStackInHand(hand).damage(1, player, test -> {  });
        }

        return ActionResult.SUCCESS;
    }




}
