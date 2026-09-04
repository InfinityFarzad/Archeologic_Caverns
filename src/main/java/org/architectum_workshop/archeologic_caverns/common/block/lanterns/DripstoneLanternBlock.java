package org.architectum_workshop.archeologic_caverns.common.block.lanterns;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DripstoneLanternBlock extends LanternBlock {
    private static final VoxelShape SHAPE_STANDING = Shapes.or(Block.column(12.0, 0.0, 6.0), Block.column(6.0, 6.0, 8.0));
    private static final VoxelShape SHAPE_HANGING = SHAPE_STANDING.move(0.0, 0.1365, 0.0).optimize();

    public DripstoneLanternBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(HANGING) ? SHAPE_HANGING : SHAPE_STANDING;
    }
}
