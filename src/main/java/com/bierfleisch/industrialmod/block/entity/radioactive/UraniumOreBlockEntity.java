package com.bierfleisch.industrialmod.block.entity.radioactive;

import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class UraniumOreBlockEntity extends RadioactiveBlockEntity {
    public UraniumOreBlockEntity(BlockPos pos, BlockState state) {
        super(IndustrialModBlockEntityRegister.URANIUM_ORE_BLOCK_ENTITY, pos, state);
    }
}
