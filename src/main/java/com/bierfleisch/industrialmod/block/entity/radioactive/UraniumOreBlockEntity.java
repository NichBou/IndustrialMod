package com.bierfleisch.industrialmod.block.entity.radioactive;

import com.bierfleisch.industrialmod.block.entity.ModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class UraniumOreBlockEntity extends RadioactiveBlockEntity {
    public UraniumOreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityRegister.URANIUM_ORE_BLOCK_ENTITY, pos, state);
    }
}
