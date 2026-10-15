package org.architectum_workshop.archeologic_caverns.common.init;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACCreativeTabs {

    ResourceKey<CreativeModeTab> ITEM_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ArcheologicCaverns.id("ac_blocks"));
    ResourceKey<CreativeModeTab> BLOCKS_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ArcheologicCaverns.id("ac_items"));


    CreativeModeTab ITEM_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .title(Component.translatable("creative_tab.archeologic_caverns.items_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ACItems.ITEM_OF_TRUE_GAYNESS);
                output.accept(ACItems.CLEAVER);
                output.accept(ACItems.AMBER);
                output.accept(ACItems.SHINEWICH);
                output.accept(ACItems.CUPRIC_STEW);
                output.accept(ACItems.PLATE_OF_NAILS);
            })
            .icon(() -> new ItemStack(ACItems.AMBER))
            .build();

    CreativeModeTab BLOCKS_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .title(Component.translatable("creative_tab.archeologic_caverns.blocks_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ACBlocks.DRIPSTONE_BRICKS);
                output.accept(ACBlocks.DRIPSTONE_BRICK_STAIRS);
                output.accept(ACBlocks.DRIPSTONE_BRICK_SLAB);
                output.accept(ACBlocks.DRIPSTONE_BRICK_WALL);

                output.accept(ACBlocks.POLISHED_DRIPSTONE);
                output.accept(ACBlocks.POLISHED_DRIPSTONE_STAIRS);
                output.accept(ACBlocks.POLISHED_DRIPSTONE_SLAB);
                output.accept(ACBlocks.POLISHED_DRIPSTONE_WALL);

                output.accept(ACBlocks.DRIPSTONE_TILES);
                output.accept(ACBlocks.DRIPSTONE_TILE_STAIRS);
                output.accept(ACBlocks.DRIPSTONE_TILE_SLAB);
                output.accept(ACBlocks.DRIPSTONE_TILE_WALL);

                output.accept(ACBlocks.CHISELED_DRIPSTONE);
                output.accept(ACBlocks.DRIPSTONE_PILLAR);
                output.accept(ACBlocks.DRIPSTONE_LANTERN);
                output.accept(Blocks.DRIPSTONE_BLOCK);
                output.accept(Items.POINTED_DRIPSTONE);

                output.accept(ACBlocks.CALCITE_BRICKS);
                output.accept(ACBlocks.CALCITE_BRICK_STAIRS);
                output.accept(ACBlocks.CALCITE_BRICK_SLAB);
                output.accept(ACBlocks.CALCITE_BRICK_WALL);

                output.accept(ACBlocks.POLISHED_CALCITE);
                output.accept(ACBlocks.POLISHED_CALCITE_STAIRS);
                output.accept(ACBlocks.POLISHED_CALCITE_SLAB);
                output.accept(ACBlocks.POLISHED_CALCITE_WALL);

                output.accept(ACBlocks.CALCITE_TILES);
                output.accept(ACBlocks.CALCITE_TILE_STAIRS);
                output.accept(ACBlocks.CALCITE_TILE_SLAB);
                output.accept(ACBlocks.CALCITE_TILE_WALL);

                output.accept(ACBlocks.CHISELED_CALCITE);
                output.accept(ACBlocks.CALCITE_PILLAR);
                output.accept(ACBlocks.CALCITE_LANTERN);
                output.accept(Blocks.CALCITE);

                output.accept(Blocks.DEEPSLATE_BRICKS);
                output.accept(Blocks.DEEPSLATE_BRICK_STAIRS);
                output.accept(Blocks.DEEPSLATE_BRICK_SLAB);
                output.accept(Blocks.DEEPSLATE_BRICK_WALL);

                output.accept(Blocks.POLISHED_DEEPSLATE);
                output.accept(Blocks.POLISHED_DEEPSLATE_STAIRS);
                output.accept(Blocks.POLISHED_DEEPSLATE_SLAB);
                output.accept(Blocks.POLISHED_DEEPSLATE_WALL);

                output.accept(Blocks.DEEPSLATE_TILES);
                output.accept(Blocks.DEEPSLATE_TILE_STAIRS);
                output.accept(Blocks.DEEPSLATE_TILE_SLAB);
                output.accept(Blocks.DEEPSLATE_TILE_WALL);

                output.accept(Blocks.COBBLED_DEEPSLATE);
                output.accept(Blocks.COBBLED_DEEPSLATE_STAIRS);
                output.accept(Blocks.COBBLED_DEEPSLATE_SLAB);
                output.accept(Blocks.COBBLED_DEEPSLATE_WALL);

                output.accept(Blocks.CHISELED_DEEPSLATE);
                output.accept(ACBlocks.DEEPSLATE_PILLAR);
                output.accept(ACBlocks.DEEPSLATE_LANTERN);
                output.accept(Blocks.DEEPSLATE);

                output.accept(ACBlocks.SALT_BLOCK);
                output.accept(ACBlocks.SALT_STAIRS);
                output.accept(ACBlocks.SALT_SLAB);
                output.accept(ACBlocks.SALT_WALL);

                output.accept(ACBlocks.POLISHED_SALT);
                output.accept(ACBlocks.POLISHED_SALT_STAIRS);
                output.accept(ACBlocks.POLISHED_SALT_SLAB);
                output.accept(ACBlocks.POLISHED_SALT_WALL);

                output.accept(ACBlocks.SALT_BRICKS);
                output.accept(ACBlocks.SALT_BRICK_STAIRS);
                output.accept(ACBlocks.SALT_BRICK_SLAB);
                output.accept(ACBlocks.SALT_BRICK_WALL);
                output.accept(ACBlocks.SALT_LANTERN);

                output.accept(ACBlocks.SALT_PRESSURE_PLATE);
                output.accept(ACBlocks.POTENT_SALT);

                output.accept(ACBlocks.AMBER_BLOCK);


                output.accept(ACBlocks.BRAZIER);
                output.accept(ACBlocks.SOUL_BRAZIER);

            })
            .icon(() -> new ItemStack(ACBlocks.CHISELED_DRIPSTONE))
            .build();

    static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKS_CREATIVE_TAB_KEY, BLOCKS_CREATIVE_TAB);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_CREATIVE_TAB_KEY, ITEM_CREATIVE_TAB);
    }

}
