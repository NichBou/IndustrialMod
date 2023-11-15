package com.bierfleisch.industrialmod.block.entity;

import com.bierfleisch.industrialmod.block.LiquidContainerSettings;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PumpBlockEntity extends PipeBlockEntity {
    public PumpBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.PUMP_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected LiquidContainerSettings createSettings() {
        return super.createSettings().setGeneratedPressure(10);
    }


}
