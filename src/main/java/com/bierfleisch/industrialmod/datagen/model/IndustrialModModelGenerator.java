package com.bierfleisch.industrialmod.datagen.model;

import com.bierfleisch.industrialmod.register.IndustrialModBlockRegister;
import com.bierfleisch.industrialmod.register.IndustrialModItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class IndustrialModModelGenerator extends FabricModelProvider {
    public IndustrialModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(IndustrialModItemRegister.PRESSURE_GAUGE_ITEM, Models.GENERATED);
        itemModelGenerator.register(IndustrialModItemRegister.WRENCH_ITEM, Models.GENERATED);
    }
}
