package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACTags;

import java.util.concurrent.CompletableFuture;

public class ACItemTagProvider extends FabricTagsProvider.ItemTagsProvider{

    public ACItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.LANTERNS).add(ACBlocks.DEEPSLATE_LANTERN.asItem(), ACBlocks.CALCITE_LANTERN.asItem(), ACBlocks.DRIPSTONE_LANTERN.asItem(), ACBlocks.SALT_LANTERN.asItem());
        valueLookupBuilder(ACTags.Items.AMETHYST_TOOL_REPAIRABLE).add(Items.AMETHYST_SHARD);
    }
}
