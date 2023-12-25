package com.bierfleisch.industrialmod.block.entity.radioactive;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

import java.util.List;

public class RadioactiveBlockEntity extends BlockEntity {
    private static int radiationStrength = 10;

    public RadioactiveBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        List<LivingEntity> nearbyPlayers = world.getEntitiesByClass(
                LivingEntity.class,
                getRadiationZone(pos, radiationStrength),
                Entity::isPlayer);

        for (LivingEntity entity : nearbyPlayers) {
            int dist = entity.getBlockPos().getManhattanDistance(pos);
            entity.sendMessage(Text.literal("Radiation: " + dist));
        }

    }

    private Box getRadiationZone(BlockPos pos, int radiationStrength) {
        return new Box(pos).expand(radiationStrength);
    }
}
