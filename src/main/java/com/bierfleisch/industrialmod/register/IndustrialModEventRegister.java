package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.block.entity.LiquidContainerBlockEntity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class IndustrialModEventRegister {
    public static void registerAll() {
        // ServerBlockEntityEvents.BLOCK_ENTITY_LOAD.register();
        // ServerLifecycleEvents.SERVER_STARTED.register(IndustrialModEventRegister::OnLoadLiquidContainerBlockEntity);
    }

    private static void OnLoadLiquidContainerBlockEntity(MinecraftServer minecraftServer) {

    }

    private static void OnLoadLiquidContainerBlockEntity(BlockEntity blockEntity, ServerWorld world) {
        if (!(blockEntity instanceof LiquidContainerBlockEntity)) return;

        IndustrialMod.LOGGER.info("WEAK UPDATE Liquid Container Block!");



        world.getBlockEntity(blockEntity.getPos());

        // ((LiquidContainerBlockEntity) blockEntity).weakUpdate(world);
    }
}
