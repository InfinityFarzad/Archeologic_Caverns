package org.architectum_workshop.archeologic_caverns.common.block.impl;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public interface ExtinguishableBlock {
    default void onExtinguish(Entity source, BlockState state, BlockPos pos, LevelAccessor level) {}
    default boolean isLit(BlockState state, BlockPos pos, LevelAccessor level) {
        return state.hasProperty(BlockStateProperties.LIT) && state.getValue(BlockStateProperties.LIT);
    }
    default boolean canBeExtinguishedByShovel(BlockState state, BlockPos pos, LevelAccessor level) {
        return false;
    }
}
