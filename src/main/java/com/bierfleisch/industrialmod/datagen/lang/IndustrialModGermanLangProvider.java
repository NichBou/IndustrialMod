package com.bierfleisch.industrialmod.datagen.lang;

import com.bierfleisch.industrialmod.block.ModBlockRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class IndustrialModGermanLangProvider extends FabricLanguageProvider {
    public IndustrialModGermanLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "de_de");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlockRegister.PUMP_BLOCK, "Pumpen Block");
    }
}
