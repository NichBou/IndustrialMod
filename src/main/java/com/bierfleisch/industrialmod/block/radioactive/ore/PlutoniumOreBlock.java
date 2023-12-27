package com.bierfleisch.industrialmod.block.radioactive.ore;

import com.bierfleisch.industrialmod.block.entity.radioactive.PlutoniumOreBlockEntity;
import com.bierfleisch.industrialmod.block.entity.radioactive.UraniumOreBlockEntity;
import com.bierfleisch.industrialmod.block.radioactive.RadioactiveBlock;
import com.bierfleisch.industrialmod.register.IndustrialModBlockEntityRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PlutoniumOreBlock extends RadioactiveBlock {
    public PlutoniumOreBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlutoniumOreBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, IndustrialModBlockEntityRegister.PLUTONIUM_ORE_BLOCK_ENTITY,
                ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }
}
