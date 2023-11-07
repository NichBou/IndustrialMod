package com.bierfleisch.industrialmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

public class PumpBlock extends Block {
    public static final BooleanProperty PUMPING = BooleanProperty.of("pumping");

    public PumpBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(PUMPING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PUMPING);
    }
}
