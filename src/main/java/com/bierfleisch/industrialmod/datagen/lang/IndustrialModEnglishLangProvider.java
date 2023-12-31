package com.bierfleisch.industrialmod.datagen.lang;

import com.bierfleisch.industrialmod.block.ModBlockRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class IndustrialModEnglishLangProvider extends FabricLanguageProvider {
    public IndustrialModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlockRegister.PUMP_BLOCK, "Pump Block");
        translationBuilder.add(ModBlockRegister.PIPE_BLOCK, "Pipe Block");
    }
}
