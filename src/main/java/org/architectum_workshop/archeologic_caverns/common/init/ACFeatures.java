package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.SaltClusterFeature;

public interface ACFeatures {
    SaltClusterFeature SALT_CLUSTER_FEATURE = register(SaltClusterFeature.SALT_FEATURE_ID.getNamespace(), new SaltClusterFeature(ProbabilityFeatureConfiguration.CODEC));


    static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(BuiltInRegistries.FEATURE, ArcheologicCaverns.id(name), feature);
    }

    static void init() {}
}
