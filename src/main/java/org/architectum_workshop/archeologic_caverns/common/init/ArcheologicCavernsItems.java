package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.item.AmethystGreataxeItem;
import org.architectum_workshop.archeologic_caverns.common.item.DripstoneDrillItem;

import java.util.function.Function;

public interface ArcheologicCavernsItems {

    Item AMETHYST_GREATAXE = register("amethyst_greataxe", AmethystGreataxeItem::new, new Item.Properties());

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
