package org.architectum_workshop.archeologic_caverns.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;

public class ConnectingPillarBlock extends Block {
    public static final EnumProperty<ConnectionState> CONNECTION_STATE = EnumProperty.create("connection_state", ConnectingPillarBlock.ConnectionState.class);

    public ConnectingPillarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CONNECTION_STATE, ConnectionState.TOP));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        BlockState newBlockState = state.setValue(CONNECTION_STATE, getConnectionState(state, pos, level));

        return super.updateShape(newBlockState, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        FluidState replacedFluidState = context.getLevel().getFluidState(pos);
        BlockState state = (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(CONNECTION_STATE, getConnectionState(context.getLevel().getBlockState(pos), pos, context.getLevel()))));
        return (BlockState)state.setValue(CONNECTION_STATE, getConnectionState(state, pos, context.getLevel()));
    }


    private ConnectionState getConnectionState(BlockState state, BlockPos pos, LevelReader level) {
        BlockState aboveState = level.getBlockState(pos.above());
        System.out.println(pos.above().toString() + "a");
        BlockState belowState = level.getBlockState(pos.below());
        System.out.println(pos.below().toString() + "b");
        if (aboveState.is(state.getBlock())) {
            if (belowState.is(state.getBlock())) {
                return ConnectionState.MIDDLE;
            }
            return ConnectionState.BOTTOM;
        }
        return ConnectionState.TOP;
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CONNECTION_STATE);
    }

    public static enum ConnectionState implements StringRepresentable {
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom");
        private final String id;

        ConnectionState(String id) {
            this.id = id;
        }

        @Override
        public String getSerializedName() {
            return this.id;
        }
    }
}
