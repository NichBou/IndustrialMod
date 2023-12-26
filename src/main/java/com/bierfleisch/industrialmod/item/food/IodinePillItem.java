package com.bierfleisch.industrialmod.item.food;

import com.bierfleisch.industrialmod.item.IndustrialModFoodComponents;
import com.bierfleisch.industrialmod.radiation.RadiationData;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IodinePillItem extends Item {
    public IodinePillItem() {
        super(new FabricItemSettings()

                .food(IndustrialModFoodComponents.IODINE_PILL_FOOD_COMPONENT));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                if (((IEntityDataSaver) user).getPersistentData().getInt("radiation") > 0) {
                    user.setCurrentHand(hand);
                    return TypedActionResult.consume(itemStack);
                }
            }
            return TypedActionResult.fail(itemStack);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            RadiationData.removeRadiation((IEntityDataSaver) user, 250);
        }

        return super.finishUsing(stack, world, user);
    }
}
