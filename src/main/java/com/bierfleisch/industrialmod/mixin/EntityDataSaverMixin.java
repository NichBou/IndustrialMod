package com.bierfleisch.industrialmod.mixin;

import com.bierfleisch.industrialmod.IndustrialMod;
import com.bierfleisch.industrialmod.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityDataSaverMixin implements IEntityDataSaver {
    @Unique
    private static final String INDUSTRIAL_MOD_NBT_KEY = IndustrialMod.MOD_ID + ".data";

    @Unique
    private NbtCompound persistentData;

    public NbtCompound getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }

        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void writeNbt(NbtCompound nbt, CallbackInfoReturnable info) {
        if (persistentData != null) {
            nbt.put(INDUSTRIAL_MOD_NBT_KEY, persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void readNbt(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains(INDUSTRIAL_MOD_NBT_KEY, NbtElement.COMPOUND_TYPE)) {
            persistentData = nbt.getCompound(INDUSTRIAL_MOD_NBT_KEY);
        }
    }
}
