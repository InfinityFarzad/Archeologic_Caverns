package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.config.LargeColumnFeatureConfig;

public interface ACConfiguredFeatures {

    ResourceKey<ConfiguredFeature<?, ?>> SALT_CLUSTER_KEY = createKey("salt_cluster");
    ResourceKey<ConfiguredFeature<?, ?>> AMBER_COLUMN_KEY = createKey("amber_column");


    static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, SALT_CLUSTER_KEY, ACFeatures.SALT_CLUSTER_FEATURE, new ProbabilityFeatureConfiguration(1.f));
        FeatureUtils.register(context, AMBER_COLUMN_KEY, ACFeatures.AMBER_COLUMN_FEATURE, new LargeColumnFeatureConfig(30, UniformInt.of(3, 19), UniformFloat.of(0.4f, 2.0f), 0.33f, UniformFloat.of(0.3f, 0.9f), UniformFloat.of(0.4f, 1.0f), UniformFloat.of(0.0f, 0.3f), 4, 0.6f, ACBlocks.AMBER_BLOCK.defaultBlockState()));

    }

    static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ArcheologicCaverns.id(name));
    }
}
