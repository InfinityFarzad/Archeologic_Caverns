package org.architectum_workshop.archeologic_caverns.common.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACTags;

public class SaltClusterFeature extends Feature<ProbabilityFeatureConfiguration> implements FeatureConfiguration {
    public SaltClusterFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }
    public static final Identifier SALT_FEATURE_ID = ArcheologicCaverns.id("salt_cluster_feature");

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        boolean placedAny = false;
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        int x = random.nextInt(8) - random.nextInt(8);
        int z = random.nextInt(8) - random.nextInt(8);
        int y = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, origin.getX() + x, origin.getZ() + z);
        BlockPos pos = new BlockPos(origin.getX() + x, y, origin.getZ() + z);
        if (level.getBlockState(pos).is(ACTags.Blocks.SALT_REPLACEABLE) && level.getBlockState(pos.above()).is(Blocks.WATER)) {
            level.setBlock(pos, ACBlocks.SALT_BLOCK.defaultBlockState(), 2);
            placedAny = true;
        }
        return placedAny;
    }

    public record SaltClusterConfig(int size) implements FeatureConfiguration {
        public static final Codec<SaltClusterConfig> CODEC = RecordCodecBuilder.create(i -> i.group(Codec.INT.fieldOf("size").forGetter(SaltClusterConfig::size)).apply(i, SaltClusterConfig::new));
    }
}
