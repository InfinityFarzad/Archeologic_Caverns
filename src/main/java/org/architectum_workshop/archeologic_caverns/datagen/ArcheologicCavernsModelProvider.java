package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.item.Item;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;

public class ArcheologicCavernsModelProvider extends FabricModelProvider {
    public ArcheologicCavernsModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.family(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE).slab(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB).stairs(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS).wall(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL);
        blockModelGenerators.family(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS).wall(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL).slab(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB).stairs(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS);
        blockModelGenerators.family(ArcheologicCavernsBlocks.DRIPSTONE_TILES).wall(ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL).slab(ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB).stairs(ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS);

        blockModelGenerators.family(ArcheologicCavernsBlocks.POLISHED_CALCITE).slab(ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB).stairs(ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS).wall(ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL);
        blockModelGenerators.family(ArcheologicCavernsBlocks.CALCITE_BRICKS).wall(ArcheologicCavernsBlocks.CALCITE_BRICK_WALL).slab(ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB).stairs(ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS);
        blockModelGenerators.family(ArcheologicCavernsBlocks.CALCITE_TILES).wall(ArcheologicCavernsBlocks.CALCITE_TILE_WALL).slab(ArcheologicCavernsBlocks.CALCITE_TILE_SLAB).stairs(ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS);
        //blockModelGenerators.family(ArcheologicCavernsBlocks.CALCITE_SHINGLES).slab(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB).stairs(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS);

        blockModelGenerators.createTrivialBlock(ArcheologicCavernsBlocks.CHISELED_DRIPSTONE, TexturedModel.COLUMN);
        blockModelGenerators.createTrivialBlock(ArcheologicCavernsBlocks.CHISELED_CALCITE, TexturedModel.COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.createFlatItemModel(ArcheologicCavernsBlocks.CALCITE_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ArcheologicCavernsBlocks.DEEPSLATE_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);

    }
}
