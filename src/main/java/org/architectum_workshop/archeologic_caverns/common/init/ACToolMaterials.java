package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public interface ACToolMaterials {

    ToolMaterial CLEAVER_STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2500, 6.0f, 2.0f, 14, ItemTags.IRON_TOOL_MATERIALS);

    static void init() {}
}
