package com.bierfleisch.industrialmod.datagen;

import com.bierfleisch.industrialmod.item.ModToolItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModToolItems.TITANIUM_HELMET_ITEM, ModToolItems.TITANIUM_CHESTPLATE_ITEM, ModToolItems.TITANIUM_LEGGINGS_ITEM, ModToolItems.TITANIUM_BOOTS_ITEM);
    }
}
