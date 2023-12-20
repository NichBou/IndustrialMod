package com.bierfleisch.industrialmod.fluid;

import com.bierfleisch.industrialmod.fluid.FluidType;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.Direction;
import org.w3c.dom.ranges.DocumentRange;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class BlockFluidSides {
    private final Map<Direction, BlockFluidSide> sides = Map.of(
            Direction.DOWN, new BlockFluidSide(),
            Direction.UP, new BlockFluidSide(),
            Direction.NORTH, new BlockFluidSide(),
            Direction.SOUTH, new BlockFluidSide(),
            Direction.WEST, new BlockFluidSide(),
            Direction.EAST, new BlockFluidSide()
    );

    public BlockFluidSide get(Direction direction) {
        return sides.get(direction);
    }

    public void set(Direction direction, BlockFluidSide side) {
        sides.replace(direction, side);
    }

    public boolean receivable(Direction direction, FluidType fluid) {
        return sides.get(direction).inputType == FluidInputType.INPUT && Arrays.stream(sides.get(direction).acceptedFluids).anyMatch(f -> f == fluid);
    }

    public int count(Direction direction) {
        return sides.get(direction).acceptedFluids.length;
    }
}
