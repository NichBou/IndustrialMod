package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.radiation.RadiationData;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class IndustrialModEventRegister {
    public static void registerAll() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

                if (((IEntityDataSaver) player).getPersistentData().getInt("radiation") != 0) {
                    RadiationData.removeRadiation((IEntityDataSaver) player, 1);
                }

            }
        });
    }
}
