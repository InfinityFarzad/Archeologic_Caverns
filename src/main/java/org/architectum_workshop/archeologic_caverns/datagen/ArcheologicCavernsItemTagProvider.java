package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ArcheologicCavernsItemTagProvider extends FabricTagsProvider.ItemTagsProvider{

    public ArcheologicCavernsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.LANTERNS).add(ArcheologicCavernsBlocks.DEEPSLATE_LANTERN.asItem(), ArcheologicCavernsBlocks.CALCITE_LANTERN.asItem());
    }
}
