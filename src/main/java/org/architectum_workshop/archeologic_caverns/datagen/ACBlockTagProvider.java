package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;

import java.util.concurrent.CompletableFuture;

public class ACBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ACBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.WALLS)
                .add(
                        ACBlocks.POLISHED_DRIPSTONE_WALL,
                        ACBlocks.DRIPSTONE_BRICK_WALL,
                        ACBlocks.DRIPSTONE_TILE_WALL
                ).add(
                        ACBlocks.POLISHED_CALCITE_WALL,
                        ACBlocks.CALCITE_BRICK_WALL,
                        ACBlocks.CALCITE_TILE_WALL
                )
                .add(ACBlocks.SALT_WALL);

        valueLookupBuilder(BlockTags.SLABS)
                .add(
                        ACBlocks.POLISHED_DRIPSTONE_SLAB,
                        ACBlocks.DRIPSTONE_BRICK_SLAB,
                        ACBlocks.DRIPSTONE_TILE_SLAB
                ).add(
                        ACBlocks.POLISHED_CALCITE_SLAB,
                        ACBlocks.CALCITE_BRICK_SLAB,
                        ACBlocks.CALCITE_TILE_SLAB
                )
                .add(ACBlocks.SALT_SLAB);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(
                        ACBlocks.POLISHED_DRIPSTONE_STAIRS,
                        ACBlocks.DRIPSTONE_BRICK_STAIRS,
                        ACBlocks.DRIPSTONE_TILE_STAIRS
                )
                .add(
                        ACBlocks.POLISHED_CALCITE_STAIRS,
                        ACBlocks.CALCITE_BRICK_STAIRS,
                        ACBlocks.CALCITE_TILE_STAIRS
                )
                .add(ACBlocks.SALT_STAIRS);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ACBlocks.POLISHED_DRIPSTONE_WALL,
                        ACBlocks.POLISHED_DRIPSTONE,
                        ACBlocks.POLISHED_DRIPSTONE_STAIRS,
                        ACBlocks.POLISHED_DRIPSTONE_SLAB,
                        ACBlocks.POLISHED_CALCITE_WALL,
                        ACBlocks.POLISHED_CALCITE,
                        ACBlocks.POLISHED_CALCITE_STAIRS,
                        ACBlocks.POLISHED_CALCITE_SLAB
                )
                .add(
                        ACBlocks.DRIPSTONE_BRICKS,
                        ACBlocks.DRIPSTONE_BRICK_WALL,
                        ACBlocks.DRIPSTONE_BRICK_SLAB,
                        ACBlocks.DRIPSTONE_BRICK_STAIRS,
                        ACBlocks.CALCITE_BRICKS,
                        ACBlocks.CALCITE_BRICK_WALL,
                        ACBlocks.CALCITE_BRICK_SLAB,
                        ACBlocks.CALCITE_BRICK_STAIRS
                ).add(
                        ACBlocks.DRIPSTONE_TILES,
                        ACBlocks.DRIPSTONE_TILE_WALL,
                        ACBlocks.DRIPSTONE_TILE_SLAB,
                        ACBlocks.DRIPSTONE_TILE_STAIRS,
                        ACBlocks.CALCITE_TILES,
                        ACBlocks.CALCITE_TILE_WALL,
                        ACBlocks.CALCITE_TILE_SLAB,
                        ACBlocks.CALCITE_TILE_STAIRS
                )
                .add(
                        ACBlocks.CHISELED_DRIPSTONE,
                        ACBlocks.CHISELED_CALCITE
                )
                .add(
                        ACBlocks.CALCITE_PILLAR,
                        ACBlocks.DRIPSTONE_PILLAR,
                        ACBlocks.DEEPSLATE_PILLAR
                )
                .add(
                    ACBlocks.DEEPSLATE_LANTERN,
                    ACBlocks.CALCITE_LANTERN,
                    ACBlocks.DRIPSTONE_LANTERN
                )
                .add(
                        ACBlocks.SALT_BLOCK,
                        ACBlocks.SALT_STAIRS,
                        ACBlocks.SALT_SLAB,
                        ACBlocks.SALT_WALL,
                        ACBlocks.POTENT_SALT,
                        ACBlocks.SALT_PRESSURE_PLATE
                );
        valueLookupBuilder(BlockTags.LANTERNS).add(ACBlocks.DEEPSLATE_LANTERN, ACBlocks.CALCITE_LANTERN, ACBlocks.DRIPSTONE_LANTERN);
    }
}
