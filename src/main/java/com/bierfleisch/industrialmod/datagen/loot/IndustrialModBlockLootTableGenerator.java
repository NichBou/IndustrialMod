package com.bierfleisch.industrialmod.datagen.loot;

import com.bierfleisch.industrialmod.block.ModBlockRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class IndustrialModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public IndustrialModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlockRegister.PUMP_BLOCK, drops(ModBlockRegister.PUMP_BLOCK_ITEM));
    }
}
