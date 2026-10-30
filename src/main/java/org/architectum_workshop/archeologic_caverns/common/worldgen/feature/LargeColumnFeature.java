package org.architectum_workshop.archeologic_caverns.common.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.phys.Vec3;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.config.LargeColumnFeatureConfig;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

// none of this code is mine, it was taken from minecrafts code base and modified, shame me all you want, I just couldn't figure it out, i will replace it later on


public class LargeColumnFeature extends Feature<LargeColumnFeatureConfig> {

    public LargeColumnFeature(Codec<LargeColumnFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<LargeColumnFeatureConfig> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        LargeColumnFeatureConfig config = context.config();
        RandomSource random = context.random();
        if (!isEmptyOrWater(level, origin)) {
            return false;
        }
        Optional<Column> column = Column.scan(level, origin, config.floorToCeilingSearchRange, DripstoneUtils::isEmptyOrWater, DripstoneUtils::isDripstoneBaseOrLava);
        if (column.isEmpty() || !(column.get() instanceof Column.Range)) {
            return false;
        }
        Column.Range columnRange = (Column.Range)column.get();
        if (columnRange.height() < 4) {
            return false;
        }
        int maxColumnRadiusBasedOnColumnHeight = (int)((float)columnRange.height() * config.maxColumnRadiusToCaveHeightRatio);
        int maxColumnRadius = Mth.clamp(maxColumnRadiusBasedOnColumnHeight, config.columnRadius.minInclusive(), config.columnRadius.maxInclusive());
        int radius = Mth.randomBetweenInclusive(random, config.columnRadius.minInclusive(), maxColumnRadius);
        LargeColumn stalactite = makeDripstone(origin.atY(columnRange.ceiling() - 1), false, random, radius, config.stalactiteBluntness, config.heightScale);
        LargeColumn stalagmite = makeDripstone(origin.atY(columnRange.floor() + 1), true, random, radius, config.stalagmiteBluntness, config.heightScale);
        WindOffsetter wind = stalactite.isSuitableForWind(config) && stalagmite.isSuitableForWind(config) ? new WindOffsetter(origin.getY(), random, config.windSpeed) : WindOffsetter.noWind();
        boolean stalactiteBaseEmbeddedInStone = stalactite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, wind);
        boolean stalagmiteBaseEmbeddedInStone = stalagmite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, wind);
        if (stalactiteBaseEmbeddedInStone) {
            stalactite.placeBlocks(config.blockstate, level, random, wind);
        }
        if (stalagmiteBaseEmbeddedInStone) {
            stalagmite.placeBlocks(config.blockstate ,level, random, wind);
        }
        return true;
    }

    private static LargeColumn makeDripstone(BlockPos root, boolean pointingUp, RandomSource random, int radius, FloatProvider bluntness, FloatProvider heightScale) {
        return new LargeColumn(root, pointingUp, radius, bluntness.sample(random), heightScale.sample(random));
    }

    private static final class LargeColumn {
        private BlockPos root;
        private final boolean pointingUp;
        private int radius;
        private final double bluntness;
        private final double scale;

        private LargeColumn(BlockPos root, boolean pointingUp, int radius, double bluntness, double scale) {
            this.root = root;
            this.pointingUp = pointingUp;
            this.radius = radius;
            this.bluntness = bluntness;
            this.scale = scale;
        }

        private int getHeight() {
            return this.getHeightAtRadius(0.0f);
        }

        private int getMinY() {
            if (this.pointingUp) {
                return this.root.getY();
            }
            return this.root.getY() - this.getHeight();
        }

        private int getMaxY() {
            if (!this.pointingUp) {
                return this.root.getY();
            }
            return this.root.getY() + this.getHeight();
        }

        private boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel level, WindOffsetter wind) {
            while (this.radius > 1) {
                BlockPos.MutableBlockPos newRoot = this.root.mutable();
                int maxTries = Math.min(10, this.getHeight());
                for (int i = 0; i < maxTries; ++i) {
                    if (level.getBlockState(newRoot).is(Blocks.LAVA)) {
                        return false;
                    }
                    if (isCircleMostlyEmbeddedInStone(level, wind.offset(newRoot), this.radius)) {
                        this.root = newRoot;
                        return true;
                    }
                    newRoot.move(this.pointingUp ? Direction.DOWN : Direction.UP);
                }
                this.radius /= 2;
            }
            return false;
        }

        private int getHeightAtRadius(float checkRadius) {
            return (int)getDripstoneHeight(checkRadius, this.radius, this.scale, this.bluntness);
        }

        private void placeBlocks(BlockState state, WorldGenLevel level, RandomSource random, WindOffsetter wind) {
            for (int dx = -this.radius; dx <= this.radius; ++dx) {
                block1: for (int dz = -this.radius; dz <= this.radius; ++dz) {
                    int height;
                    float currentRadius = Mth.sqrt(dx * dx + dz * dz);
                    if (currentRadius > (float)this.radius || (height = this.getHeightAtRadius(currentRadius)) <= 0) continue;
                    if ((double)random.nextFloat() < 0.2) {
                        height = (int)((float)height * Mth.randomBetween(random, 0.8f, 1.0f));
                    }
                    BlockPos.MutableBlockPos pos = this.root.offset(dx, 0, dz).mutable();
                    boolean hasBeenOutOfStone = false;
                    int maxY = this.pointingUp ? level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ()) : Integer.MAX_VALUE;
                    for (int i = 0; i < height && pos.getY() < maxY; ++i) {
                        BlockPos windAdjustedPos = wind.offset(pos);
                        if (isEmptyOrWaterOrLava(level, windAdjustedPos)) {
                            hasBeenOutOfStone = true;
                            level.setBlock(windAdjustedPos, state, 2);
                        } else if (hasBeenOutOfStone && level.getBlockState(windAdjustedPos).is(BlockTags.BASE_STONE_OVERWORLD)) continue block1;
                        pos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
                    }
                }
            }
        }

        private boolean isSuitableForWind(LargeDripstoneConfiguration config) {
            return this.radius >= config.minRadiusForWind && this.bluntness >= (double)config.minBluntnessForWind;
        }
    }

    private static final class WindOffsetter {
        private final int originY;
        private final @Nullable Vec3 windSpeed;

        private WindOffsetter(int originY, RandomSource random, FloatProvider windSpeedRange) {
            this.originY = originY;
            float speed = windSpeedRange.sample(random);
            float direction = Mth.randomBetween(random, 0.0f, (float)Math.PI);
            this.windSpeed = new Vec3(Mth.cos(direction) * speed, 0.0, Mth.sin(direction) * speed);
        }

        private WindOffsetter() {
            this.originY = 0;
            this.windSpeed = null;
        }

        private static WindOffsetter noWind() {
            return new WindOffsetter();
        }

        private BlockPos offset(BlockPos pos) {
            if (this.windSpeed == null) {
                return pos;
            }
            int dy = this.originY - pos.getY();
            Vec3 totalWindAdjust = this.windSpeed.scale(dy);
            return pos.offset(Mth.floor(totalWindAdjust.x), 0, Mth.floor(totalWindAdjust.z));
        }
    }

    protected static boolean isEmptyOrWater(LevelAccessor level, BlockPos pos) {
        return level.isStateAtPosition(pos, DripstoneUtils::isEmptyOrWater);
    }

    protected static boolean isEmptyOrWaterOrLava(LevelAccessor level, BlockPos pos) {
        return level.isStateAtPosition(pos, DripstoneUtils::isEmptyOrWaterOrLava);
    }

    protected static double getDripstoneHeight(double xzDistanceFromCenter, double dripstoneRadius, double scale, double bluntness) {
        if (xzDistanceFromCenter < bluntness) {
            xzDistanceFromCenter = bluntness;
        }
        double cutoff = 0.384;
        double r = xzDistanceFromCenter / dripstoneRadius * 0.384;
        double part1 = 0.75 * Math.pow(r, 1.3333333333333333);
        double part2 = Math.pow(r, 0.6666666666666666);
        double part3 = 0.3333333333333333 * Math.log(r);
        double heightRelativeToMaxRadius = scale * (part1 - part2 - part3);
        heightRelativeToMaxRadius = Math.max(heightRelativeToMaxRadius, 0.0);
        return heightRelativeToMaxRadius / 0.384 * dripstoneRadius;
    }

    protected static boolean isCircleMostlyEmbeddedInStone(WorldGenLevel level, BlockPos center, int xzRadius) {
        if (isEmptyOrWaterOrLava(level, center)) {
            return false;
        }
        float arcLength = 6.0f;
        float angleIncrement = 6.0f / (float)xzRadius;
        for (float angle = 0.0f; angle < (float)Math.PI * 2; angle += angleIncrement) {
            int dz;
            int dx = (int)(Mth.cos(angle) * (float)xzRadius);
            if (!isEmptyOrWaterOrLava(level, center.offset(dx, 0, dz = (int)(Mth.sin(angle) * (float)xzRadius)))) continue;
            return false;
        }
        return true;
    }
}
