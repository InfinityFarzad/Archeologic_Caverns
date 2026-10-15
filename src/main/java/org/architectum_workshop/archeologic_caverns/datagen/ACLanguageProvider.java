package org.architectum_workshop.archeologic_caverns.datagen;

import joptsimple.internal.Strings;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACCreativeTabs;
import org.architectum_workshop.archeologic_caverns.common.init.ACItems;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ACLanguageProvider extends FabricLanguageProvider {
    protected ACLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {

        ACBlocks.TRANSLATED_BLOCKS.forEach(translatedBlock -> translate(translationBuilder, translatedBlock));
        ACItems.TRANSLATED_ITEMS.forEach(translatedBlock -> translate(translationBuilder, translatedBlock));

        translationBuilder.add("painting.archeologic_caverns.friend_shrub.author", "mongocat");
        translationBuilder.add("painting.archeologic_caverns.friend_shrub.title", "Friend Shrub");

        translationBuilder.add(ACCreativeTabs.BLOCKS_CREATIVE_TAB_KEY, "Cavern Items");
        translationBuilder.add(ACCreativeTabs.ITEM_CREATIVE_TAB_KEY, "Cavern Blocks");
        translationBuilder.add("death.attack.inSalt", "%1$s had too much salt in the wounds");
        translationBuilder.add("item.archeologic_caverns.cleaver_bonus", " Increases Item Harvest ");
    }

    public void translate(TranslationBuilder translationBuilder, Block block) {
        translationBuilder.add(block, format(BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }
    public void translate(TranslationBuilder translationBuilder, Item item) {
        translationBuilder.add(item, format(BuiltInRegistries.ITEM.getKey(item).getPath()));
    }

    public String format(String key) {
        List<String> splitWord = Arrays.stream(key.split("_")).map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).toList();
        return Strings.join(splitWord, " ");
    }
}
