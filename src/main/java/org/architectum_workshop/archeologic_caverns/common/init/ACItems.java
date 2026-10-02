package org.architectum_workshop.archeologic_caverns.common.init;

import net.akws.chiseled_lib.common.item.component.ItemHighlightComponent;
import net.akws.chiseled_lib.common.registries.ChiseledLibComponents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.block.Block;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.item.AmethystGreataxeItem;
import org.architectum_workshop.archeologic_caverns.common.item.DripstoneDrillItem;
import org.architectum_workshop.archeologic_caverns.common.item.ItemOfTrueGaynessItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ACItems {

    List<Item> TRANSLATED_ITEMS = new ArrayList<>();

    Item AMETHYST_GREATAXE = register("amethyst_axe", properties -> new AmethystGreataxeItem(properties, 9,-3.2f), new Item.Properties().component(ChiseledLibComponents.ITEM_HIGHLIGHT, new ItemHighlightComponent(0xFFb38ef3, true)));
    Item DRIPSTONE_DRILL = register("dripstone_drill", DripstoneDrillItem::new, new Item.Properties());
    Item AMBER = register("amber", Item::new, new Item.Properties().component(ACComponents.EMISSIVE_COMPONENT, true));
    Item ITEM_OF_TRUE_GAYNESS = register("item_of_true_gayness", ItemOfTrueGaynessItem::new,  new Item.Properties().component(ChiseledLibComponents.ITEM_HIGHLIGHT, new ItemHighlightComponent(0xb38df3, true)).component(ACComponents.EMISSIVE_COMPONENT, true));

    Item SHINEWICH = register("shinewich", Item::new, new Item.Properties().food(ACFoods.SHINEWICH, Consumable.builder().sound(Holder.direct(SoundEvents.SCULK_CATALYST_BREAK)).build()).component(ACComponents.EMISSIVE_COMPONENT, true));
    Item PLATE_OF_NAILS = register("plate_of_nails", Item::new, new Item.Properties().food(ACFoods.NAILS, Consumable.builder().sound(Holder.direct(SoundEvents.CHAIN_HIT)).build()).usingConvertsTo(Items.BOWL));
    Item CUPRIC_STEW = register("cupric_stew", Item::new, new Item.Properties().food(ACFoods.CUPRIC, Consumable.builder().sound(Holder.direct(SoundEvents.MOSS_PLACE)).build()).usingConvertsTo(Items.BOWL));

    static <T extends Item> T register(String name, Function<Item.Properties, T> factory, Item.Properties itemProperties) {
        ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, ArcheologicCaverns.id(name));
        T item = factory.apply(itemProperties.setId(resourceKey));
        Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
        TRANSLATED_ITEMS.add(item);
        return item;
    }

    static void init() {
        ArcheologicCaverns.LOGGER.info("Registering Items for Archeologic Caverns");
    }
}
