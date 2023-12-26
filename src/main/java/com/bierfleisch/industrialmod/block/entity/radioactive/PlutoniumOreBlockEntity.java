package com.bierfleisch.industrialmod.block.entity.radioactive;

import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PlutoniumOreBlockEntity extends RadioactiveBlockEntity {
    public PlutoniumOreBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.PLUTONIUM_ORE_BLOCK_ENTITY, pos, state);
    }
}
