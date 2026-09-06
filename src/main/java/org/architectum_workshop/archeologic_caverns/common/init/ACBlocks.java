package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.block.ConnectingPillarBlock;
import org.architectum_workshop.archeologic_caverns.common.block.PotentSaltBlock;
import org.architectum_workshop.archeologic_caverns.common.block.SaltPressurePlateBlock;
import org.architectum_workshop.archeologic_caverns.common.block.lanterns.CalciteLanternBlock;
import org.architectum_workshop.archeologic_caverns.common.block.lanterns.DeepslateLanternBlock;
import org.architectum_workshop.archeologic_caverns.common.block.lanterns.DripstoneLanternBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface ACBlocks {

    List<Block> TRANSLATED_BLOCKS = new ArrayList<>();

    // Dripstone

    Block POLISHED_DRIPSTONE = register("polished_dripstone", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK), true);
    Block POLISHED_DRIPSTONE_STAIRS = createStairsBlock("polished_dripstone_stairs", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_SLAB = createSlabBlock("polished_dripstone_slab", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall", WallBlock::new, BlockBehaviour.Properties.of(), true);

    Block DRIPSTONE_BRICKS = register("dripstone_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK), true);
    Block DRIPSTONE_BRICK_STAIRS = createStairsBlock("dripstone_brick_stairs", DRIPSTONE_BRICKS);
    Block DRIPSTONE_BRICK_SLAB = createSlabBlock("dripstone_brick_slab", DRIPSTONE_BRICKS);
    Block DRIPSTONE_BRICK_WALL = register("dripstone_brick_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS), true);

    Block DRIPSTONE_TILES = register("dripstone_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK), true);
    Block DRIPSTONE_TILE_STAIRS = createStairsBlock("dripstone_tile_stairs", DRIPSTONE_TILES);
    Block DRIPSTONE_TILE_SLAB = createSlabBlock("dripstone_tile_slab", DRIPSTONE_TILES);
    Block DRIPSTONE_TILE_WALL = register("dripstone_tile_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_TILES), true);

    Block CHISELED_DRIPSTONE = register("chiseled_dripstone", Block::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS), true);

    // Calcite

    Block POLISHED_CALCITE = register("polished_calcite", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE), true);
    Block POLISHED_CALCITE_STAIRS = createStairsBlock("polished_calcite_stairs", POLISHED_CALCITE);
    Block POLISHED_CALCITE_SLAB = createSlabBlock("polished_calcite_slab", POLISHED_CALCITE);
    Block POLISHED_CALCITE_WALL = register("polished_calcite_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE), true);

    Block CALCITE_BRICKS = register("calcite_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE), true);
    Block CALCITE_BRICK_STAIRS = createStairsBlock("calcite_brick_stairs", CALCITE_BRICKS);
    Block CALCITE_BRICK_SLAB = createSlabBlock("calcite_brick_slab", CALCITE_BRICKS);
    Block CALCITE_BRICK_WALL = register("calcite_brick_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS), true);

    Block CALCITE_TILES = register("calcite_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    Block CALCITE_TILE_STAIRS = createStairsBlock("calcite_tile_stairs", CALCITE_TILES);
    Block CALCITE_TILE_SLAB = createSlabBlock("calcite_tile_slab", CALCITE_TILES);
    Block CALCITE_TILE_WALL = register("calcite_tile_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(CALCITE_TILES), true);

/*
    Block CALCITE_SHINGLES = register("calcite_shingles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE), true);
    Block CALCITE_SHINGLE_STAIRS = createStairsBlock("calcite_shingle_stairs", CALCITE_SHINGLES);
    Block CALCITE_SHINGLE_SLAB = createSlabBlock("calcite_shingle_slab", CALCITE_SHINGLES);
*/

    Block CHISELED_CALCITE = register("chiseled_calcite", BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS));

    Block CALCITE_LANTERN = register("calcite_lantern", CalciteLanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));
    Block DEEPSLATE_LANTERN = register("deepslate_lantern", DeepslateLanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));
    Block DRIPSTONE_LANTERN = register("dripstone_lantern", DripstoneLanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));

    Block CALCITE_PILLAR = register("calcite_pillar", ConnectingPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    Block DRIPSTONE_PILLAR = register("dripstone_pillar", ConnectingPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK));
    Block DEEPSLATE_PILLAR = register("deepslate_pillar", ConnectingPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE));

    //Salt

    Block SALT = register("salt", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.CALCITE));
    Block SALT_STAIRS = createStairsBlock("salt_stairs", SALT);
    Block SALT_SLAB = createSlabBlock("salt_slab", SALT);
    Block SALT_WALL = createWallBlock("salt_wall", SALT);

    Block POTENT_SALT = register("potent_salt", PotentSaltBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.CALCITE));

    Block SALT_PRESSURE_PLATE = register("salt_pressure_plate", SaltPressurePlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.CALCITE));

    /* registry methods */

    private static Block createWallBlock(String name, Block base) {
        return register(name, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(base));
    }

    private static Block createSlabBlock(String name, Block base) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(base));
    }

    private static Block createStairsBlock(String name, Block base) {
        return register(name, properties -> new StairBlock(base.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(base));
    }

    private static Block register(String name, BlockBehaviour.Properties properties) {
        return register(name, Block::new, properties, true);
    }

    private static Block register(String name, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        return register(name, Block::new, properties, shouldRegisterItem);
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        return register(name, blockFactory, properties, true);
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));
        TRANSLATED_BLOCKS.add(block);

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, ArcheologicCaverns.id(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, ArcheologicCaverns.id(name));
    }

    static void init() {
        ArcheologicCaverns.LOGGER.info("Registering Blocks for ArcheologicCaverns");
    }
}
