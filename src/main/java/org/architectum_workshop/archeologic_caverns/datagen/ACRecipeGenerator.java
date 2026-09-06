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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;

import java.util.concurrent.CompletableFuture;

public class ACRecipeGenerator extends FabricRecipeProvider {
    public ACRecipeGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
                    @Override
                    public void buildRecipes() {
                        HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_BRICKS, 4)
                                .define('#', ACBlocks.POLISHED_DRIPSTONE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_DRIPSTONE, 4)
                                .define('#', Blocks.DRIPSTONE_BLOCK)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_TILES, 4)
                                .define('#', ACBlocks.DRIPSTONE_BRICKS)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE))
                                .save(output);

                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_BRICKS, 4)
                                .define('#', ACBlocks.POLISHED_CALCITE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_CALCITE, 4)
                                .define('#', Blocks.CALCITE)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);
                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_TILES, 4)
                                .define('#', ACBlocks.CALCITE_BRICKS)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);

                        shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_PILLAR, 2)
                                .define('#', ACBlocks.POLISHED_CALCITE_SLAB)
                                .pattern("#")
                                .pattern("#")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);

                        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CHISELED_CALCITE, Ingredient.of(ACBlocks.CALCITE_BRICK_SLAB)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CHISELED_DRIPSTONE, Ingredient.of(ACBlocks.DRIPSTONE_BRICK_SLAB)).unlockedBy(getHasName(Items.POINTED_DRIPSTONE), has(Items.POINTED_DRIPSTONE)).save(output);

                        shaped(RecipeCategory.DECORATIONS, ACBlocks.CALCITE_LANTERN, 3)
                                .define('#', Blocks.CALCITE)
                                .define('a', Items.AMETHYST_SHARD)
                                .define('c', Items.CHARCOAL)
                                .define('i', Items.IRON_NUGGET)
                                .pattern(" i ")
                                .pattern("aca")
                                .pattern("###")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);

                        shaped(RecipeCategory.DECORATIONS, ACBlocks.DEEPSLATE_LANTERN, 3)
                                .define('#', Blocks.COBBLED_DEEPSLATE)
                                .define('a', Items.LAPIS_LAZULI)
                                .define('c', Items.CHARCOAL)
                                .define('i', Items.IRON_NUGGET)
                                .pattern(" i ")
                                .pattern("aca")
                                .pattern("###")
                                .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                                .save(output);

                        shaped(RecipeCategory.DECORATIONS, ACBlocks.DRIPSTONE_LANTERN, 3)
                                .define('#', Blocks.DRIPSTONE_BLOCK)
                                .define('a', Items.RESIN_CLUMP)
                                .define('c', Items.CHARCOAL)
                                .define('i', Items.IRON_NUGGET)
                                .pattern(" i ")
                                .pattern("aca")
                                .pattern("###")
                                .unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.DRIPSTONE_BLOCK))
                                .save(output);


                        /*                        shaped(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_SHINGLES, 4)
                                .define('#', ArcheologicCavernsBlocks.CALCITE_TILES)
                                .pattern("##")
                                .pattern("##")
                                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                                .save(output);*/

                        // stairs
                        stairBuilder(ACBlocks.POLISHED_DRIPSTONE_STAIRS, Ingredient.of(ACBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        stairBuilder(ACBlocks.DRIPSTONE_BRICK_STAIRS, Ingredient.of(ACBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        stairBuilder(ACBlocks.DRIPSTONE_TILE_STAIRS, Ingredient.of(ACBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        stairBuilder(ACBlocks.SALT_STAIRS, Ingredient.of(ACBlocks.SALT)).unlockedBy(getHasName(ACBlocks.SALT), has(ACBlocks.SALT)).save(output);

                        stairBuilder(ACBlocks.POLISHED_CALCITE_STAIRS, Ingredient.of(ACBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        stairBuilder(ACBlocks.CALCITE_BRICK_STAIRS, Ingredient.of(ACBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        stairBuilder(ACBlocks.CALCITE_TILE_STAIRS, Ingredient.of(ACBlocks.CALCITE_TILES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        //stairBuilder(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_SHINGLES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);


                        // slabs
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_DRIPSTONE_SLAB, Ingredient.of(ACBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_BRICK_SLAB, Ingredient.of(ACBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_TILE_SLAB, Ingredient.of(ACBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);

                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_CALCITE_SLAB, Ingredient.of(ACBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_BRICK_SLAB, Ingredient.of(ACBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_TILE_SLAB, Ingredient.of(ACBlocks.CALCITE_TILES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);
                        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SALT_SLAB, Ingredient.of(ACBlocks.SALT)).unlockedBy(getHasName(ACBlocks.SALT), has(ACBlocks.SALT)).save(output);
                        //slabBuilder(RecipeCategory.BUILDING_BLOCKS, ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB, Ingredient.of(ArcheologicCavernsBlocks.CALCITE_SHINGLES)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(output);

                        // walls
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_DRIPSTONE_WALL, Ingredient.of(ACBlocks.POLISHED_DRIPSTONE)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_BRICK_WALL, Ingredient.of(ACBlocks.DRIPSTONE_BRICKS)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.DRIPSTONE_TILE_WALL, Ingredient.of(ACBlocks.DRIPSTONE_TILES)).unlockedBy(getHasName(Items.DRIPSTONE_BLOCK), has(Items.POINTED_DRIPSTONE)).save(output);

                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_CALCITE_WALL, Ingredient.of(ACBlocks.POLISHED_CALCITE)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_BRICK_WALL, Ingredient.of(ACBlocks.CALCITE_BRICKS)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CALCITE_TILE_WALL, Ingredient.of(ACBlocks.CALCITE_TILES)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output);
                        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SALT_WALL, Ingredient.of(ACBlocks.SALT)).unlockedBy(getHasName(ACBlocks.SALT), has(ACBlocks.SALT)).save(output);

                        createStonecutterRecipe(ACBlocks.SALT,
                                ACBlocks.SALT_STAIRS,
                                ACBlocks.SALT_WALL
                        );
                        createDoubleStonecutterRecipe(ACBlocks.SALT, ACBlocks.SALT_SLAB);

                        pressurePlate(ACBlocks.SALT_PRESSURE_PLATE, ACBlocks.SALT);
                    }
            public void createStonecutterRecipe(ItemLike base, ItemLike... results) {
                for (ItemLike result : results) {
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, base);
                }
            }
            public void createDoubleStonecutterRecipe(ItemLike base, ItemLike... results) {
                for (ItemLike result : results) {
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, base, 2);
                }
            }
        };
     }



    @Override
    public String getName() {
        return "ArcheologicCavernsRecipeGenerator";
    }
}

