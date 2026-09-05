package org.architectum_workshop.archeologic_caverns.common.init;

import net.akws.chiseled_lib.common.item.component.ItemHighlightComponent;
import net.akws.chiseled_lib.common.registries.ChiseledLibComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.AttackRange;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.item.AmethystGreataxeItem;
import org.architectum_workshop.archeologic_caverns.common.item.DripstoneDrillItem;

import java.util.function.Function;

public interface ArcheologicCavernsItems {

    Item AMETHYST_GREATAXE = register("amethyst_axe", properties -> new AmethystGreataxeItem(properties, 9,-3.2f), new Item.Properties().component(ChiseledLibComponents.ITEM_HIGHLIGHT, new ItemHighlightComponent(0xFFb38ef3, true)));

    Item DRIPSTONE_DRILL = register("dripstone_drill", DripstoneDrillItem::new, new Item.Properties());

    static <T extends Item> T register(String name, Function<Item.Properties, T> factory, Item.Properties itemProperties) {
        ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, ArcheologicCaverns.id(name));
        T item = factory.apply(itemProperties.setId(resourceKey));
        Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
        return item;
    }

    static void init() {
        ArcheologicCaverns.LOGGER.info("Registering Items for Archeologic Caverns");
    }
}
