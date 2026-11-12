package org.architectum_workshop.archeologic_caverns.common.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;

// why did I decide to do this? I don't know

public class LargeColumnFeatureConfig extends LargeDripstoneConfiguration {
    public final BlockState blockstate;

    public static final Codec<LargeColumnFeatureConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
            LargeDripstoneConfiguration.CODEC.fieldOf("base").forGetter(LargeColumnFeatureConfig::createConfig),
            BlockState.CODEC.fieldOf("blockstate").orElse(Blocks.AMETHYST_BLOCK.defaultBlockState()).forGetter(LargeColumnFeatureConfig::getBlockstate)
    ).apply(i, (dc, state) -> new LargeColumnFeatureConfig(dc.floorToCeilingSearchRange, dc.columnRadius, dc.heightScale, dc.maxColumnRadiusToCaveHeightRatio, dc.stalactiteBluntness, dc.stalagmiteBluntness, dc.windSpeed, dc.minRadiusForWind, dc.minBluntnessForWind, state)));


    public LargeColumnFeatureConfig(int floorToCeilingSearchRange, IntProvider columnRadius, FloatProvider heightScale, float maxColumnRadiusToCaveHeightRatio, FloatProvider stalactiteBluntness, FloatProvider stalagmiteBluntness, FloatProvider windSpeed, int minRadiusForWind, float minBluntnessForWind, BlockState blockstate) {
        super(floorToCeilingSearchRange, columnRadius, heightScale, maxColumnRadiusToCaveHeightRatio, stalactiteBluntness, stalagmiteBluntness, windSpeed, minRadiusForWind, minBluntnessForWind);
        this.blockstate = blockstate;
    }

    public BlockState getBlockstate() {
        return blockstate;
    }

    public LargeDripstoneConfiguration createConfig() {
        return new LargeDripstoneConfiguration(floorToCeilingSearchRange, columnRadius, heightScale, maxColumnRadiusToCaveHeightRatio, stalactiteBluntness, stalagmiteBluntness, windSpeed, minRadiusForWind, minBluntnessForWind);
    }
}
