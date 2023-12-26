package com.bierfleisch.industrialmod.item;

import com.bierfleisch.industrialmod.radiation.RadiationData;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class IodinePillItem extends Item {
    public IodinePillItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) return TypedActionResult.pass(itemStack);

        RadiationData.removeRadiation((IEntityDataSaver) user, 240);


        return TypedActionResult.consume(itemStack);
    }
}
