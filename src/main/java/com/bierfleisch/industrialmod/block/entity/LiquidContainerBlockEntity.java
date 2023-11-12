package com.bierfleisch.industrialmod.block.entity;

import com.bierfleisch.industrialmod.screen.LiquidContainerScreenHandler;
import com.google.common.collect.Iterators;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class LiquidContainerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    private int pressure = 0;
    private int flow = 0;

    protected static final int MAX_FLOW = 10;

    public static final int PRESSURE_PROPERTY_INDEX = 0;
    public static final int FLOW_PROPERTY_INDEX = 1;

    protected final List<LiquidContainerBlockEntity> connectedNeighbors = new ArrayList<>();
    protected final PropertyDelegate propertyDelegate;

    public LiquidContainerBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        propertyDelegate = createPropertyDelegate();
    }

    protected PropertyDelegate createPropertyDelegate() {
        return new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case PRESSURE_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.pressure;
                    case FLOW_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.flow;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PRESSURE_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.pressure = value;
                    case FLOW_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.flow = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        this.privateTick(world, pos, state);
    }

    /**
     * Custom tick logic for the LiquidContainerBlockEntity class. <br>
     * <b>Not to be overwritten by child class, for this override tick() and call super.tick()</b>
     * @param world
     * @param pos
     * @param state
     */
    private void privateTick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        boolean pressureChanged = false;

        // TODO: Transfer flow to neighbor ordered by lowest pressure first
        for (var pipe : connectedNeighbors) {
            int connectedPressure = pipe.getPressure();

            if (this.pressure - 1 > connectedPressure) {
                pressureChanged = true;
                this.transferFlow(pipe, 1);
            }
        }

        if (pressureChanged) {
            this.updateState();
        }
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new LiquidContainerScreenHandler(syncId, playerInventory, this.propertyDelegate);
    }

    protected void updateState() { }

    private BlockState getUpdatedState(BlockState state) {
        return state;
    }

    private void transferFlow(LiquidContainerBlockEntity pipe, int amount) {
        this.flow -= amount;
        pipe.addFlow(amount);
    }

    public void setPressure(int value) {
        this.pressure = value;
    }

    public int getPressure() {
        return this.pressure;
    }

    public boolean addFlow(int amount) {
        if (amount > getRemainingFlowSpace()) return false;

        this.flow += amount;

        return true;
    }

    public int getRemainingFlowSpace() {
        return MAX_FLOW - this.flow;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        pressure = nbt.getInt("pressure");
        flow = nbt.getInt("flow");

        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("pressure", pressure);
        nbt.putInt("flow", flow);

        super.writeNbt(nbt);
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos) {
        if (world.isClient()) return;

        loadNeighbors();
        updateState();
    }

    private void loadNeighbors() {
        this.connectedNeighbors.clear();

        Iterator<Direction> directions = Iterators.concat(Direction.Type.HORIZONTAL.iterator(), Direction.Type.VERTICAL.iterator());

        while (directions.hasNext()) {
            Direction direction = directions.next();
            BlockPos neighborPos = pos.offset(direction);

            BlockEntity neighbor = world.getBlockEntity(neighborPos);

            if (neighbor != null && neighbor.getType() == this.getType()) {
                connectedNeighbors.add((LiquidContainerBlockEntity) neighbor);
            }
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }
}
