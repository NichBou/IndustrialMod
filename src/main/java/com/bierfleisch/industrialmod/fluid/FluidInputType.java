package com.bierfleisch.industrialmod.fluid;

public enum FluidInputType {
    NONE,
    INPUT,
    OUTPUT;

    /**
     * get next enum state and wrap around
     *
     * @return next enum state
     */
    public FluidInputType next() {
        return values()[(ordinal() + 1) % values().length];
    }
}
