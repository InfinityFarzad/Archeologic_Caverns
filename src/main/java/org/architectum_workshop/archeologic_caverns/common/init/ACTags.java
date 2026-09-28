package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACTags {

    interface Items {
        TagKey<Item> AMETHYST_TOOL_REPAIRABLE = register("amethyst_tool_repairable");

        static TagKey<Item> register(String name) {
            return TagKey.create(Registries.ITEM, ArcheologicCaverns.id(name));
        }
    }

    interface Blocks {
        TagKey<Block> SALT_REPLACEABLE = register("salt_replaceable");

        static TagKey<Block> register(String name) {
            return TagKey.create(Registries.BLOCK, ArcheologicCaverns.id(name));
        }
    }

    static void init() {}
}
