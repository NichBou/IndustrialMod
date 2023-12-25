package com.bierfleisch.industrialmod.radiation;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.register.IndustrialModNetworkPacketRegister;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class RadiationData {
    public static int addRadiation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int radiation = nbt.getInt("radiation");

        radiation = Math.min(radiation + amount, 10);

        nbt.putInt("radiation", radiation);
        syncRadiation(radiation, (ServerPlayerEntity) player);
        return radiation;
    }

    public static int setRadiation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();

        nbt.putInt("radiation", amount);
        syncRadiation(amount, (ServerPlayerEntity) player);
        return amount;
    }

    public static int removeRadiation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int radiation = nbt.getInt("radiation");

        radiation = Math.max(radiation - amount, 0);

        nbt.putInt("radiation", radiation);
        syncRadiation(radiation, (ServerPlayerEntity) player);
        return radiation;
    }

    public static void syncRadiation(int radiation, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(radiation);
        ServerPlayNetworking.send(player, IndustrialModNetworkPacketRegister.RADIATION_SYNC_ID, buffer);
    }
}
