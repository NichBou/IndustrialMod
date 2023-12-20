package com.bierfleisch.industrialmod.screen;

import com.bierfleisch.industrialmod.block.entity.fluid.container.FluidContainerBlockEntity;
import com.bierfleisch.industrialmod.register.IndustrialModScreenHandlerRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;

public class LiquidContainerScreenHandler extends ScreenHandler {
    private PropertyDelegate propertyDelegate;

    public LiquidContainerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new ArrayPropertyDelegate(3));
    }

    public LiquidContainerScreenHandler(int syncId, PlayerInventory playerInventory, PropertyDelegate propertyDelegate) {
        super(IndustrialModScreenHandlerRegister.LIQUID_CONTAINER_SCREEN_HANDLER, syncId);
        this.propertyDelegate = propertyDelegate;

        this.addProperties(propertyDelegate);
    }

    public int getPressure() {
        return propertyDelegate.get(FluidContainerBlockEntity.PRESSURE_PROPERTY_INDEX);
    }

    public int getFlow() {
        return propertyDelegate.get(FluidContainerBlockEntity.FLOW_PROPERTY_INDEX);
    }

    public int getConnectedAmount() {
        return propertyDelegate.get(FluidContainerBlockEntity.CONNECTED_PROPERTY_INDEX);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
