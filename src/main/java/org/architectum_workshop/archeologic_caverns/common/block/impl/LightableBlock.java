package org.architectum_workshop.archeologic_caverns.common.block.impl;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public interface LightableBlock {

    default void light(Player player, BlockState state, BlockPos pos, LevelAccessor level) {
    }

    default boolean canLight(BlockState state, BlockPos pos, LevelAccessor level) {
        return state.hasProperty(BlockStateProperties.LIT) && !state.getValue(BlockStateProperties.LIT);
    }
}
