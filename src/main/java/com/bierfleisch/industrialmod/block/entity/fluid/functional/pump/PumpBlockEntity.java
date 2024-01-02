package com.bierfleisch.industrialmod.block.entity.fluid.functional.pump;

import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import com.bierfleisch.industrialmod.fluid.FluidContainerSettings;
import com.bierfleisch.industrialmod.block.entity.fluid.transporter.pipe.PipeBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PumpBlockEntity extends PipeBlockEntity {
    public PumpBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityRegister.PUMP_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected FluidContainerSettings createSettings() {
        return super.createSettings();
    }
}
