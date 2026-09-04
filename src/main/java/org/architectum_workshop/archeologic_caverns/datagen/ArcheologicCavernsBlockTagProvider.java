package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;

import java.util.concurrent.CompletableFuture;

public class ArcheologicCavernsBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ArcheologicCavernsBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.WALLS)
                .add(
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL
                ).add(
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_WALL,
                        ArcheologicCavernsBlocks.CALCITE_TILE_WALL
                );

        valueLookupBuilder(BlockTags.SLABS)
                .add(
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB
                ).add(
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB,
                        ArcheologicCavernsBlocks.CALCITE_TILE_SLAB
                );

        valueLookupBuilder(BlockTags.STAIRS)
                .add(
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS
                )
                .add(
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS,
                        ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS
                );

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL,
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE,
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS,
                        ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB,
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL,
                        ArcheologicCavernsBlocks.POLISHED_CALCITE,
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS,
                        ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB
                )
                .add(
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICKS,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB,
                        ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS,
                        ArcheologicCavernsBlocks.CALCITE_BRICKS,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_WALL,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB,
                        ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS
                ).add(
                        ArcheologicCavernsBlocks.DRIPSTONE_TILES,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB,
                        ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS,
                        ArcheologicCavernsBlocks.CALCITE_TILES,
                        ArcheologicCavernsBlocks.CALCITE_TILE_WALL,
                        ArcheologicCavernsBlocks.CALCITE_TILE_SLAB,
                        ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS
                )
                .add(
                        ArcheologicCavernsBlocks.CHISELED_DRIPSTONE,
                        ArcheologicCavernsBlocks.CHISELED_CALCITE
                )
                .add(
                        ArcheologicCavernsBlocks.CALCITE_PILLAR
                )
                .add(
                    ArcheologicCavernsBlocks.DEEPSLATE_LANTERN,
                    ArcheologicCavernsBlocks.CALCITE_LANTERN,
                    ArcheologicCavernsBlocks.DRIPSTONE_LANTERN
                );
        valueLookupBuilder(BlockTags.LANTERNS).add(ArcheologicCavernsBlocks.DEEPSLATE_LANTERN, ArcheologicCavernsBlocks.CALCITE_LANTERN, ArcheologicCavernsBlocks.DRIPSTONE_LANTERN);
    }
}
