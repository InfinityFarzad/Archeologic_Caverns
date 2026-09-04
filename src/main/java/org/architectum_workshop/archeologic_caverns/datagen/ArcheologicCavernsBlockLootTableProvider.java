package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;

import java.util.concurrent.CompletableFuture;

public class ArcheologicCavernsBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected ArcheologicCavernsBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ArcheologicCavernsBlocks.CALCITE_BRICKS);
        add(ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB));
        dropSelf(ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_BRICK_WALL);

        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS);
        add(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB));
        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS);
        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL);

/*
        dropSelf(ArcheologicCavernsBlocks.CALCITE_SHINGLES);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS);
        add(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB));
*/

        dropSelf(ArcheologicCavernsBlocks.POLISHED_CALCITE);
        dropSelf(ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL);
        dropSelf(ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS);
        add(ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB));

        dropSelf(ArcheologicCavernsBlocks.CALCITE_TILES);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_TILE_WALL);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS);
        add(ArcheologicCavernsBlocks.CALCITE_TILE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.CALCITE_TILE_SLAB));

        dropSelf(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE);
        dropSelf(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL);
        dropSelf(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB));

        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_TILES);
        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL);
        dropSelf(ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS);
        add(ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB));


        dropSelf(ArcheologicCavernsBlocks.CHISELED_CALCITE);
        dropSelf(ArcheologicCavernsBlocks.CHISELED_DRIPSTONE);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_LANTERN);
        dropSelf(ArcheologicCavernsBlocks.DEEPSLATE_LANTERN);
    }
}
