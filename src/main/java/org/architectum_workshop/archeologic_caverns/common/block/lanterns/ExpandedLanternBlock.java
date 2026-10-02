package org.architectum_workshop.archeologic_caverns.common.block.lanterns;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.architectum_workshop.archeologic_caverns.common.util.ToShapeInterface;

public class ExpandedLanternBlock extends LanternBlock {
    private final ToShapeInterface<BlockState> shape;

    public ExpandedLanternBlock(BlockBehaviour.Properties properties, ToShapeInterface<BlockState> shape) {
        super(properties);
        this.shape = shape;
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shape.toShape(state);
    }
}
