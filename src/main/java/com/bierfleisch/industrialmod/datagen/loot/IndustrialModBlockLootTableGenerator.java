package com.bierfleisch.industrialmod.datagen.loot;

import com.bierfleisch.industrialmod.register.IndustrialModBlockRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class IndustrialModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public IndustrialModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(IndustrialModBlockRegister.PUMP_BLOCK, drops(IndustrialModBlockRegister.PUMP_BLOCK_ITEM));
    }
}
