package com.bierfleisch.industrialmod.block.entity;

import com.bierfleisch.industrialmod.block.LiquidContainerSettings;
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

    protected final LiquidContainerSettings settings;

    public static final int PRESSURE_PROPERTY_INDEX = 0;
    public static final int FLOW_PROPERTY_INDEX = 1;
    public static final int CONNECTED_PROPERTY_INDEX = 2;

    protected final List<LiquidContainerBlockEntity> connectedNeighbors = new ArrayList<>();
    protected final PropertyDelegate propertyDelegate;

    public LiquidContainerBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        propertyDelegate = createPropertyDelegate();
        this.settings = this.createSettings();
    }

    protected LiquidContainerSettings createSettings() {
        return new LiquidContainerSettings();
    }

    protected PropertyDelegate createPropertyDelegate() {
        return new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case PRESSURE_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.pressure;
                    case FLOW_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.flow;
                    case CONNECTED_PROPERTY_INDEX -> LiquidContainerBlockEntity.this.connectedNeighbors.size();
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
                return 3;
            }
        };
    }

    /**
     * Called every tick. Can be overwritten, but super must be called.
     * @param world
     * @param pos
     * @param state
     */
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

        int maxFoundPressure = settings.generatedPressure + 1;
        for (var pipe : connectedNeighbors) {
            int connectedPressure = pipe.getPressure();

            if (connectedPressure > maxFoundPressure) {
                maxFoundPressure = connectedPressure;
            }
        }
        this.setPressure(maxFoundPressure - 1);

        this.updateState();
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

    private void transferPressure(LiquidContainerBlockEntity pipe) {
        pipe.setPressure(this.pressure - 1);
    }

    public void setPressure(int value) {
        this.pressure = value;
    }

    public int getPressure() {
        return this.pressure;
    }

    public int getFlow() {
        return flow;
    }

    public boolean addFlow(int amount) {
        if (amount > getRemainingFlowSpace()) return false;

        this.flow += amount;

        return true;
    }

    public int getRemainingFlowSpace() {
        return settings.maxFlow - this.flow;
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

        strongUpdate();
        updateState();
    }

    public void weakUpdate() {
        loadNeighbors();
    }

    public void strongUpdate() {
        weakUpdate();
        updateNeighbors();
    }

    private void updateNeighbors() {
        for (var neighbor : connectedNeighbors) {
            neighbor.weakUpdate();
        }
    }

    private void loadNeighbors() {
        this.connectedNeighbors.clear();

        Iterator<Direction> directions = Iterators.concat(Direction.Type.HORIZONTAL.iterator(), Direction.Type.VERTICAL.iterator());

        while (directions.hasNext()) {
            Direction direction = directions.next();
            BlockPos neighborPos = pos.offset(direction);

            BlockEntity neighbor = world.getBlockEntity(neighborPos);

            if (neighbor instanceof LiquidContainerBlockEntity) {
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
