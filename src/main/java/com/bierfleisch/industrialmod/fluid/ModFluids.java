package com.bierfleisch.industrialmod.fluid;

import com.bierfleisch.industrialmod.IndustrialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_OIL;
    public static FlowableFluid FLOWING_OIL;
    public static Block OIL_BLOCK;
    public static Item OIL_BUCKET;

    public static void register() {
        STILL_OIL = Registry.register(Registries.FLUID,
                new Identifier(IndustrialMod.MOD_ID, "oil"), new OilFluid.Still());
        FLOWING_OIL = Registry.register(Registries.FLUID,
                new Identifier(IndustrialMod.MOD_ID, "flowing_oil"), new OilFluid.Flowing());

        OIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(IndustrialMod.MOD_ID, "oil_block"),
                new FluidBlock(ModFluids.STILL_OIL, FabricBlockSettings.copyOf(Blocks.WATER)));
        OIL_BUCKET = Registry.register(Registries.ITEM, new Identifier(IndustrialMod.MOD_ID, "oil_bucket"),
                new BucketItem(ModFluids.STILL_OIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
