package com.bierfleisch.industrialmod.datagen.model;

import com.bierfleisch.industrialmod.item.ModToolItems;
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
    public void generateItemModels( ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModToolItems.PRESSURE_GAUGE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModToolItems.WRENCH_ITEM, Models.GENERATED);

        itemModelGenerator.register(ModToolItems.URANIUM_PICKAXE_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModToolItems.URANIUM_AXE_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModToolItems.URANIUM_SHOVEL_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModToolItems.URANIUM_HOE_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModToolItems.URANIUM_SWORD_ITEM, Models.HANDHELD);



    }

}
