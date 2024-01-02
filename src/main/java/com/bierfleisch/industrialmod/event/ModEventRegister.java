package com.bierfleisch.industrialmod.event;

import com.bierfleisch.industrialmod.radiation.RadiationData;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModEventRegister {
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
