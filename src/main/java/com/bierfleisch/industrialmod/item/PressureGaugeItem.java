package com.bierfleisch.industrialmod.item;

import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;

import java.util.function.Consumer;

public class PressureGaugeItem extends Item {
    public PressureGaugeItem() {
        super(new FabricItemSettings().maxDamage(100).c(1));
    }
}
