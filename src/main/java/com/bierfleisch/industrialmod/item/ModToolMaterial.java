package com.bierfleisch.industrialmod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    URANIUM(MiningLevels.IRON,650,4.5f,3.5f,26,
            ()->Ingredient.ofItems(ModItemRegister.URANIUM_INGOT_ITEM)),
    PLUTONIUM(MiningLevels.IRON,650,4.5f,3.5f,26,
            ()->Ingredient.ofItems(ModItemRegister.PLUTONIUM_INGOT_ITEM)),
    TITANIUM(MiningLevels.IRON, 650, 4.5f, 3.5f, 26,
            ()->Ingredient.ofItems(ModItemRegister.TITANIUM_INGOT_ITEM))
    ;


    private final int mininglevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient>repairIngredient;

    ModToolMaterial(int mininglevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.mininglevel = mininglevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }




    @Override
    public int getDurability() {
        return this. itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.mininglevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
