package org.architectum_workshop.archeologic_caverns.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.architectum_workshop.archeologic_caverns.common.block.impl.LightableBlock;
import org.architectum_workshop.archeologic_caverns.common.block.impl.ShovelExtinguishable;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.Desc;

public class BrazierBlock extends Block implements SimpleWaterloggedBlock, ShovelExtinguishable, LightableBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 13.0);


    public BrazierBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, true).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (entity instanceof LivingEntity livingEntity && state.getValue(LIT)) {
            livingEntity.setRemainingFireTicks(20);
        }

        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {

        if (state.getValue(LIT)) {
            if (random.nextInt(10) == 0) {
                level.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5f + random.nextFloat(), random.nextFloat() * 0.7f + 0.6f, false);
            }
            if (random.nextInt(5) == 0) {
                for (int i = 0; i < random.nextInt(1) + 1; ++i) {
                    level.addParticle(ParticleTypes.LAVA, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, random.nextFloat() / 2.0f, 5.0E-5, random.nextFloat() / 2.0f);
                }
            }
        }

        super.animateTick(state, level, pos, random);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }

        return super.getFluidState(state);
    }

    @Desc("for a very good reason")
    @Deprecated
    public static void NoooHowCouldYouTurnOffMyFlameYouGodDamnMinecraftPlayerWhatDoYouThinkIamACampfireQuestionMarkAKAExtinguish(Player player, Level level, BlockState state, BlockPos pos) {
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {

        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockState state = level.getBlockState(context.getClickedPos());
        boolean isWaterLogged = level.getFluidState(context.getClickedPos()).is(FluidTags.WATER);
        return this.defaultBlockState().setValue(WATERLOGGED, isWaterLogged).setValue(LIT, !isWaterLogged).setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void onExtinguish(Entity source ,BlockState state, BlockPos pos, LevelAccessor level) {
        level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS);
        level.gameEvent(source, GameEvent.BLOCK_CHANGE, pos);
        if (level.isClientSide()) {
            for (int i = 5; i >= 0; i--) {
                CampfireBlock.makeParticles((Level) level, pos, false, true);
            }
        }
    }

    @Override
    public void light(Player player, BlockState state, BlockPos pos, LevelAccessor level) {
        BlockState newState = state.setValue(BlockStateProperties.LIT, true);
        if (!level.isClientSide()) {
            level.setBlock(pos, newState, 11);
            level.levelEvent(null, 1009, pos, 0);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
        }
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        // aka condition for activation of redstone or smt idk
        boolean conditionthatisveryfunnyat5am = !level.isClientSide() && state.getValue(LIT);
        return conditionthatisveryfunnyat5am ? 15 : 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT, WATERLOGGED);
    }

}

