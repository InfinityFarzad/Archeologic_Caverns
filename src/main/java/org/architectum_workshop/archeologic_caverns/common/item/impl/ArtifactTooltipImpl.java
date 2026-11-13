package org.architectum_workshop.archeologic_caverns.common.item.impl;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface ArtifactTooltipImpl {
    default Component getArtifactTooltip(ItemStack stack, Player player) {
        return Component.empty();
    }

    default List<Integer> getArtifactColour() {
        return List.of(0x89ecd8, 0x2cf859);
    }
}
