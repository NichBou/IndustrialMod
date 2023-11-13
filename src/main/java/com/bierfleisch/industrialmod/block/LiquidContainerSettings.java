package com.bierfleisch.industrialmod.block;

public class LiquidContainerSettings {
    public int maxFlow = 10;
    public int generatedPressure = 0;

    public LiquidContainerSettings setMaxFlow(int val) {
        this.maxFlow = val;
        return this;
    }

    public LiquidContainerSettings setGeneratedPressure(int val) {
        this.generatedPressure = val;
        return this;
    }
}
