package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

import java.util.List;

public interface ACPlacedFeatures {

    ResourceKey<PlacedFeature> SALT_PLACED_FEATURE = ResourceKey.create(Registries.PLACED_FEATURE, ArcheologicCaverns.id("salt_placement"));
    ResourceKey<PlacedFeature> AMBER_COLUMN_PLACED_FEATURE = ResourceKey.create(Registries.PLACED_FEATURE, ArcheologicCaverns.id("amber_placement"));

    List<PlacementModifier> SALT_PLACED_FEATURE_MODIFIERS = List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, CountPlacement.of(3), BiomeFilter.biome());
    List<PlacementModifier> AMBER_COLUMN_PLACED_FEATURE_MODIFIERS = List.of(CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

    static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder.Reference<ConfiguredFeature<?, ?>> salt = configuredFeatures.getOrThrow(ACConfiguredFeatures.SALT_CLUSTER_KEY);
        Holder.Reference<ConfiguredFeature<?, ?>> amber_column = configuredFeatures.getOrThrow(ACConfiguredFeatures.AMBER_COLUMN_KEY);

        context.register(SALT_PLACED_FEATURE, new PlacedFeature(salt, SALT_PLACED_FEATURE_MODIFIERS));
        context.register(AMBER_COLUMN_PLACED_FEATURE, new PlacedFeature(amber_column, AMBER_COLUMN_PLACED_FEATURE_MODIFIERS));

    }
}
