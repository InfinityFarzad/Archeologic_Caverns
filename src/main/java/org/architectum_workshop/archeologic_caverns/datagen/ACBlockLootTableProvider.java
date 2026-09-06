package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;

import java.util.concurrent.CompletableFuture;

public class ACBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected ACBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ACBlocks.CALCITE_BRICKS);
        add(ACBlocks.CALCITE_BRICK_SLAB, createSlabItemTable(ACBlocks.CALCITE_BRICK_SLAB));
        dropSelf(ACBlocks.CALCITE_BRICK_STAIRS);
        dropSelf(ACBlocks.CALCITE_BRICK_WALL);
        dropSelf(ACBlocks.CALCITE_PILLAR);
        dropSelf(ACBlocks.DRIPSTONE_BRICKS);
        add(ACBlocks.DRIPSTONE_BRICK_SLAB, createSlabItemTable(ACBlocks.DRIPSTONE_BRICK_SLAB));
        dropSelf(ACBlocks.DRIPSTONE_BRICK_STAIRS);
        dropSelf(ACBlocks.DRIPSTONE_BRICK_WALL);

/*
        dropSelf(ArcheologicCavernsBlocks.CALCITE_SHINGLES);
        dropSelf(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS);
        add(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB, createSlabItemTable(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB));
*/

        dropSelf(ACBlocks.POLISHED_CALCITE);
        dropSelf(ACBlocks.POLISHED_CALCITE_WALL);
        dropSelf(ACBlocks.POLISHED_CALCITE_STAIRS);
        add(ACBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(ACBlocks.POLISHED_CALCITE_SLAB));

        dropSelf(ACBlocks.CALCITE_TILES);
        dropSelf(ACBlocks.CALCITE_TILE_WALL);
        dropSelf(ACBlocks.CALCITE_TILE_STAIRS);
        add(ACBlocks.CALCITE_TILE_SLAB, createSlabItemTable(ACBlocks.CALCITE_TILE_SLAB));

        dropSelf(ACBlocks.POLISHED_DRIPSTONE);
        dropSelf(ACBlocks.POLISHED_DRIPSTONE_WALL);
        dropSelf(ACBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(ACBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(ACBlocks.POLISHED_DRIPSTONE_SLAB));

        dropSelf(ACBlocks.DRIPSTONE_TILES);
        dropSelf(ACBlocks.DRIPSTONE_TILE_WALL);
        dropSelf(ACBlocks.DRIPSTONE_TILE_STAIRS);
        add(ACBlocks.DRIPSTONE_TILE_SLAB, createSlabItemTable(ACBlocks.DRIPSTONE_TILE_SLAB));

        dropSelf(ACBlocks.CHISELED_CALCITE);
        dropSelf(ACBlocks.CHISELED_DRIPSTONE);
        dropSelf(ACBlocks.CALCITE_LANTERN);
        dropSelf(ACBlocks.DEEPSLATE_LANTERN);
        dropSelf(ACBlocks.DRIPSTONE_LANTERN);


        dropSelf(ACBlocks.SALT);
        dropSelf(ACBlocks.SALT_WALL);
        dropSelf(ACBlocks.SALT_STAIRS);
        add(ACBlocks.SALT_SLAB, createSlabItemTable(ACBlocks.SALT_SLAB));

        dropSelf(ACBlocks.POTENT_SALT);
        dropSelf(ACBlocks.SALT_PRESSURE_PLATE);
    }
}
