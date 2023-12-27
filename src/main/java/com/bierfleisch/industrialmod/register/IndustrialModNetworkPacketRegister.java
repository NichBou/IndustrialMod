package com.bierfleisch.industrialmod.register;

import com.bierfleisch.industrialmod.IndustrialMod;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class IndustrialModNetworkPacketRegister {
    public static final Identifier RADIATION_SYNC_ID = new Identifier(IndustrialMod.MOD_ID, "radiation");
}
