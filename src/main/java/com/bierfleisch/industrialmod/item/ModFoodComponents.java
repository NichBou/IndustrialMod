package com.bierfleisch.industrialmod.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent IODINE_PILL_FOOD_COMPONENT = new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).snack().alwaysEdible().build();
    public static final FoodComponent CREATIVE_IODINE_PILL_FOOD_COMPONENT = new FoodComponent.Builder().hunger(0).saturationModifier(0.3f).snack().alwaysEdible().build();
}
