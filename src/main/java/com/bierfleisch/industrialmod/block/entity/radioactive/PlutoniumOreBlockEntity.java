package com.bierfleisch.industrialmod.block.entity.radioactive;

import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PlutoniumOreBlockEntity extends RadioactiveBlockEntity {
    public PlutoniumOreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityRegister.PLUTONIUM_ORE_BLOCK_ENTITY, pos, state);
    }
}
