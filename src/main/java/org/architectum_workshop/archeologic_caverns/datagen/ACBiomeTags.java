package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import org.architectum_workshop.archeologic_caverns.common.init.ACBiomes;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ACBiomeTags extends FabricTagsProvider<Biome> {

    public ACBiomeTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.BIOME , registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(ConventionalBiomeTags.IS_CAVE).addOptional(ACBiomes.AMBER_CAVES);
        builder(ConventionalBiomeTags.IS_UNDERGROUND).addOptional(ACBiomes.AMBER_CAVES);
        builder(ConventionalBiomeTags.IS_OVERWORLD).addOptional(ACBiomes.AMBER_CAVES);
    }
}
