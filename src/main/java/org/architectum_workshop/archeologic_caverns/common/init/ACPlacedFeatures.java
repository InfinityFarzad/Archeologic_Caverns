package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

import java.awt.*;
import java.util.List;

public interface ACPlacedFeatures {

    ResourceKey<PlacedFeature> SALT_PLACED_FEATURE = ResourceKey.create(Registries.PLACED_FEATURE, ArcheologicCaverns.id("salt_placed_feature"));
    List<PlacementModifier> SALT_PLACED_FEATURE_MODIFIERS = List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, CountPlacement.of(4), BiomeFilter.biome());


    static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder.Reference<ConfiguredFeature<?, ?>> salt = configuredFeatures.getOrThrow(ACConfiguredFeatures.SALT_CLUSTER_KEY);

        context.register(SALT_PLACED_FEATURE, new PlacedFeature(salt, SALT_PLACED_FEATURE_MODIFIERS));
    }
}
