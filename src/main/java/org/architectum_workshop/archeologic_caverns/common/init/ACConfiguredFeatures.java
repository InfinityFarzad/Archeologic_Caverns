package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.SaltClusterFeature;

public interface ACConfiguredFeatures {

    ResourceKey<ConfiguredFeature<?, ?>> SALT_CLUSTER_KEY = createKey("salt_cluster");

    static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, SALT_CLUSTER_KEY, ACFeatures.SALT_CLUSTER_FEATURE, new ProbabilityFeatureConfiguration(1.f));
    }

    static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ArcheologicCaverns.id(name));
    }
}
