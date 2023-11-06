package com.bierfleisch.industrialmod.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class IndustrialModEnglishLangProvider extends FabricLanguageProvider {
    public IndustrialModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // translationBuilder.add(IndustrialModBlockRegister.SAMPLE_ITEM, "Sample Item");
    }
}
