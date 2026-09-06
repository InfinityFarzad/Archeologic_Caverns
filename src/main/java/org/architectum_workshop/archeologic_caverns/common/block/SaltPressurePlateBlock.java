package org.architectum_workshop.archeologic_caverns.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

import java.util.Comparator;
import java.util.List;

public class SaltPressurePlateBlock extends PressurePlateBlock {
    public static final IntegerProperty OUTPUT = IntegerProperty.create("output", 0, 15);

    public SaltPressurePlateBlock(Properties properties) {
        super(BlockSetType.STONE, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false).setValue(OUTPUT, 0));
    }


    protected int getSignalStrength(final Level level, final BlockPos pos) {
        List<LivingEntity> livingEntity = level.getEntitiesOfClass(LivingEntity.class, TOUCH_AABB.move(pos));
        livingEntity.sort(Comparator.comparingDouble(entity -> entity.distanceToSqr(pos.getBottomCenter())));
        if (livingEntity.isEmpty()) {
            return 0;
        }
        double maxHealthCombao = 0;
        double healthCombao = 0;
        for (LivingEntity entity : livingEntity) {
            maxHealthCombao += entity.getMaxHealth();
            healthCombao += entity.getHealth();
        }

        double ratio = healthCombao / maxHealthCombao;
        return Mth.floor(15.0 * ratio);
    }

    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, OUTPUT);
    }

    @Override
    protected BlockState setSignalForState(BlockState state, int signal) {
        return super.setSignalForState(state, signal).setValue(OUTPUT, signal);
    }

    @Override
    protected int getSignalForState(BlockState state) {
        return state.getValue(OUTPUT);
    }
}
