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

public interface ArcheologicCavernsCreativeTabs {

    ResourceKey<CreativeModeTab> CAVE_BLOCKS_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ArcheologicCaverns.id("cave_blocks"));


    CreativeModeTab CAVE_BLOCKS_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .title(Component.translatable("creative_tab.archeologic_caverns.cave_blocks"))
            .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                @Override
                public void accept(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_BRICKS);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_SLAB);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_BRICK_WALL);

                    output.accept(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_SLAB);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_DRIPSTONE_WALL);

                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_TILES);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_TILE_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_TILE_SLAB);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_TILE_WALL);

                    output.accept(ArcheologicCavernsBlocks.CHISELED_DRIPSTONE);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_PILLAR);
                    output.accept(ArcheologicCavernsBlocks.DRIPSTONE_LANTERN);
                    output.accept(Blocks.DRIPSTONE_BLOCK);
                    output.accept(Items.POINTED_DRIPSTONE);

                    output.accept(ArcheologicCavernsBlocks.CALCITE_BRICKS);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_BRICK_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_BRICK_SLAB);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_BRICK_WALL);

                    output.accept(ArcheologicCavernsBlocks.POLISHED_CALCITE);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_CALCITE_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_CALCITE_SLAB);
                    output.accept(ArcheologicCavernsBlocks.POLISHED_CALCITE_WALL);

                    output.accept(ArcheologicCavernsBlocks.CALCITE_TILES);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_TILE_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_TILE_SLAB);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_TILE_WALL);

/*                    output.accept(ArcheologicCavernsBlocks.CALCITE_SHINGLES);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_SHINGLE_STAIRS);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_SHINGLE_SLAB);*/

                    output.accept(ArcheologicCavernsBlocks.CHISELED_CALCITE);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_PILLAR);
                    output.accept(ArcheologicCavernsBlocks.CALCITE_LANTERN);
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
                    output.accept(ArcheologicCavernsBlocks.DEEPSLATE_PILLAR);
                    output.accept(ArcheologicCavernsBlocks.DEEPSLATE_LANTERN);
                    output.accept(Blocks.DEEPSLATE);
                }
            })
            .icon(() -> new ItemStack(ArcheologicCavernsBlocks.CHISELED_DRIPSTONE))
            .build();

    static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CAVE_BLOCKS_CREATIVE_TAB_KEY, CAVE_BLOCKS_CREATIVE_TAB);
        ArcheologicCaverns.LOGGER.info("Registering Creative Tabs for Archeologic Caverns");
    }

}
