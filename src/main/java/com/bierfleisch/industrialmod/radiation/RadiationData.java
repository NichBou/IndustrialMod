package com.bierfleisch.industrialmod.radiation;

import com.bierfleisch.industrialmod.network.packet.ModNetworkPacketRegister;
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

        if (amount < 1) return radiation;

        radiation = Math.max(Math.min(amount + radiation, 1000), 0);

        nbt.putInt("radiation", radiation);
        syncRadiation(radiation, (ServerPlayerEntity) player);
        return radiation;
    }

    public static int setRadiation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();

        // Clamp between 0-100
        int clampedAmount = Math.max(Math.min(amount, 1000), 0);

        nbt.putInt("radiation", clampedAmount);
        syncRadiation(clampedAmount, (ServerPlayerEntity) player);
        return clampedAmount;
    }

    public static int removeRadiation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int radiation = nbt.getInt("radiation");

        if (amount < 1) return radiation;

        radiation = Math.max(Math.min(radiation - amount, 1000), 0);

        nbt.putInt("radiation", radiation);
        syncRadiation(radiation, (ServerPlayerEntity) player);
        return radiation;
    }

    public static void syncRadiation(int radiation, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(radiation);
        ServerPlayNetworking.send(player, ModNetworkPacketRegister.RADIATION_SYNC_ID, buffer);
    }
}
