package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;

import java.util.concurrent.CompletableFuture;

public class ArcheologicCavernsRecipeGenerator extends FabricRecipeProvider {
    public ArcheologicCavernsRecipeGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
                    @Override
                    public void buildRecipes() {
                        HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.DRIPSTONE_BRICKS, 4)
                                .define('#', ArcheologicCavernsBlocks.POLISHED_DRIPSTONE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_DRIPSTONE, 4)
                                .define('#', Blocks.DRIPSTONE_BLOCK)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.DRIPSTONE_TILES, 4)
                                .define('#', ArcheologicCavernsBlocks.DRIPSTONE_BRICKS)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);

                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_BRICKS, 4)
                                .define('#', ArcheologicCavernsBlocks.POLISHED_CALCITE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_CALCITE, 4)
                                .define('#', Blocks.CALCITE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_TILES, 4)
                                .define('#', ArcheologicCavernsBlocks.CALCITE_BRICKS)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);

                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_PILLAR, 2)
                                .define('#', ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB)
                                .pattern("#")
                                .pattern("#")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);

                        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CHISELED_CALCITE, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CHISELED_DRIPSTONE, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB)).unlockedBy(getHasName(Items.POINTED_DRIPSTONE), has(Items.POINTED_DRIPSTONE)).save(output);

                        shaped(RecipeCategory.DECORATIONS, ArcheologicCavernsBlocks.CALCITE_LANTERN, 3)
                                .define('#', Blocks.CALCITE)
                                .define('a', Items.AMETHYST_SHARD)
                                .define('c', Items.CHARCOAL)
                                .define('i', Items.IRON_NUGGET)
                                .pattern(" i ")
                                .pattern("aca")
                                .pattern("###")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);


                        /*                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_SHINGLES, 4)
                                .define('#', ArcheologicCavernsBlocks.CALCITE_TILES)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);*/

                        // stairs
                        stairBuilder(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        stairBuilder(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        stairBuilder(ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);

                        stairBuilder(ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        stairBuilder(ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        stairBuilder(ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_TILES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        //stairBuilder(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_SHINGLES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);


                        // slabs
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);

                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_TILE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_TILES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        //slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_SHINGLES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);

                        // walls
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL, Ingredient.of(ArcheologicCavernsBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);

                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL, Ingredient.of(ArcheologicCavernsBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_BRICK_WALL, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_TILE_WALL, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_TILES)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);

                    }
        };
     }

    @Override
    public String getName() {
        return "ArcheologicCavernsRecipeGenerator";
    }
}

