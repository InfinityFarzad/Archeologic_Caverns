package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.LargeColumnFeature;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.SaltClusterFeature;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.config.LargeColumnFeatureConfig;

public interface ACFeatures {

    SaltClusterFeature SALT_CLUSTER_FEATURE = register("salt_cluster_feature", new SaltClusterFeature(ProbabilityFeatureConfiguration.CODEC));
    LargeColumnFeature AMBER_COLUMN_FEATURE = register("amber_column_feature", new LargeColumnFeature(LargeColumnFeatureConfig.CODEC));


    static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, ArcheologicCaverns.id(name), feature);
    }

    static void init() {}
}
