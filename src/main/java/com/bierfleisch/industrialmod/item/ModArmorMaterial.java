package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.IndustrialMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    LEAD("lead", 25, new int[]{3, 8, 6, 3},19,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,2f, 0.1f, () -> Ingredient.ofItems(ModItemRegister.LEAD_PLATE_ITEM)),

    TITANIUM("titanium", 25, new int[]{3, 8, 6, 3},19,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,2f, 0.1f, () -> Ingredient.ofItems(ModItemRegister.TITANIUM_PLATE_ITEM))
    ;


    private final String name;
    private  final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipsound;
    private final float toughness;
    private final float knockbackResistence;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipsound, float toughness, float knockbackResistence, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipsound = equipsound;
        this.toughness = toughness;
        this.knockbackResistence = knockbackResistence;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipsound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return IndustrialMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistence;
    }


}
