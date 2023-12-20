package com.bierfleisch.industrialmod.datagen;

import com.bierfleisch.industrialmod.datagen.lang.IndustrialModEnglishLangProvider;
import com.bierfleisch.industrialmod.datagen.lang.IndustrialModGermanLangProvider;
import com.bierfleisch.industrialmod.datagen.loot.IndustrialModBlockLootTableGenerator;
import com.bierfleisch.industrialmod.datagen.model.IndustrialModModelGenerator;
import com.bierfleisch.industrialmod.datagen.recipe.IndustrialModRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class IndustrialModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(IndustrialModModelGenerator::new);
        pack.addProvider(IndustrialModBlockLootTableGenerator::new);
        pack.addProvider(IndustrialModRecipeGenerator::new);
        pack.addProvider(IndustrialModEnglishLangProvider::new);
        pack.addProvider(IndustrialModGermanLangProvider::new);
    }
}
