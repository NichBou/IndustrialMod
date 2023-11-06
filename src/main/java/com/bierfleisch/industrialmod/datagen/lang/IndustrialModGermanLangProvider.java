package com.bierfleisch.industrialmod.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class IndustrialModGermanLangProvider extends FabricLanguageProvider {
    public IndustrialModGermanLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "de_de");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // translationBuilder.add(IndustrialModBlockRegister.SAMPLE_ITEM, "Beispiel Item");
    }
}
