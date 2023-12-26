package com.bierfleisch.industrialmod.block.radioactive;

import com.bierfleisch.industrialmod.block.entity.radioactive.RadioactiveBlockEntity;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.LiteralMessage;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public abstract class RadioactiveBlock extends BlockWithEntity implements BlockEntityProvider {
    public RadioactiveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
