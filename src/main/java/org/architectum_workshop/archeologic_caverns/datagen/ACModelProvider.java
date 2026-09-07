package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACItems;

public class ACModelProvider extends FabricModelProvider {
    public ACModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.family(ACBlocks.POLISHED_DRIPSTONE).slab(ACBlocks.POLISHED_DRIPSTONE_SLAB).stairs(ACBlocks.POLISHED_DRIPSTONE_STAIRS).wall(ACBlocks.POLISHED_DRIPSTONE_WALL);
        blockModelGenerators.family(ACBlocks.DRIPSTONE_BRICKS).wall(ACBlocks.DRIPSTONE_BRICK_WALL).slab(ACBlocks.DRIPSTONE_BRICK_SLAB).stairs(ACBlocks.DRIPSTONE_BRICK_STAIRS);
        blockModelGenerators.family(ACBlocks.DRIPSTONE_TILES).wall(ACBlocks.DRIPSTONE_TILE_WALL).slab(ACBlocks.DRIPSTONE_TILE_SLAB).stairs(ACBlocks.DRIPSTONE_TILE_STAIRS);

        blockModelGenerators.family(ACBlocks.POLISHED_CALCITE).slab(ACBlocks.POLISHED_CALCITE_SLAB).stairs(ACBlocks.POLISHED_CALCITE_STAIRS).wall(ACBlocks.POLISHED_CALCITE_WALL);
        blockModelGenerators.family(ACBlocks.CALCITE_BRICKS).wall(ACBlocks.CALCITE_BRICK_WALL).slab(ACBlocks.CALCITE_BRICK_SLAB).stairs(ACBlocks.CALCITE_BRICK_STAIRS);
        blockModelGenerators.family(ACBlocks.CALCITE_TILES).wall(ACBlocks.CALCITE_TILE_WALL).slab(ACBlocks.CALCITE_TILE_SLAB).stairs(ACBlocks.CALCITE_TILE_STAIRS);
        //blockModelGenerators.family(ArcheologicCavernsBlocks.CALCITE_SHINGLES).slab(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB).stairs(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS);

        blockModelGenerators.createTrivialBlock(ACBlocks.CHISELED_DRIPSTONE, TexturedModel.COLUMN);
        blockModelGenerators.createTrivialBlock(ACBlocks.CHISELED_CALCITE, TexturedModel.COLUMN);

        blockModelGenerators.family(ACBlocks.SALT_BLOCK).slab(ACBlocks.SALT_SLAB).stairs(ACBlocks.SALT_STAIRS).wall(ACBlocks.SALT_WALL).pressurePlate(ACBlocks.SALT_PRESSURE_PLATE);
        blockModelGenerators.family(ACBlocks.SALT_BRICKS).wall(ACBlocks.SALT_BRICK_WALL).slab(ACBlocks.SALT_BRICK_SLAB).stairs(ACBlocks.SALT_BRICK_STAIRS);
        blockModelGenerators.family(ACBlocks.POLISHED_SALT).wall(ACBlocks.POLISHED_SALT_WALL).slab(ACBlocks.POLISHED_SALT_SLAB).stairs(ACBlocks.POLISHED_SALT_STAIRS);
        blockModelGenerators.createTrivialCube(ACBlocks.POTENT_SALT);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.createFlatItemModel(ACBlocks.CALCITE_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ACBlocks.DEEPSLATE_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ACBlocks.DRIPSTONE_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ACBlocks.SALT_LANTERN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ACItems.AMBER, ModelTemplates.FLAT_ITEM);

    }
}
