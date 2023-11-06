package com.bierfleisch.industrialmod.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;

public class IndustrialModRecipeGenerator extends FabricRecipeProvider {
    public IndustrialModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // https://fabricmc.net/wiki/tutorial:datagen_recipe
    }
}
