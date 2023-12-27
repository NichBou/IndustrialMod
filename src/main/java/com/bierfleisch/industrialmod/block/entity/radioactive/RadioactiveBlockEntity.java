package com.bierfleisch.industrialmod.block.entity.radioactive;

import com.bierfleisch.industrialmod.radiation.RadiationData;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
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

public abstract class RadioactiveBlockEntity extends BlockEntity {
    public RadioactiveBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        List<LivingEntity> nearbyPlayers = world.getEntitiesByClass(
                LivingEntity.class,
                getRadiationZone(pos, getRadiationStrength()),
                Entity::isPlayer);

        for (LivingEntity entity : nearbyPlayers) {
            int dist = entity.getBlockPos().getManhattanDistance(pos);
            int radiation = -dist + getRadiationStrength() + 1;
            RadiationData.addRadiation((IEntityDataSaver) entity, radiation);
        }

    }

    protected int getRadiationStrength() {
        return 10;
    }

    private Box getRadiationZone(BlockPos pos, int radiationStrength) {
        return new Box(pos).expand(radiationStrength);
    }
}
