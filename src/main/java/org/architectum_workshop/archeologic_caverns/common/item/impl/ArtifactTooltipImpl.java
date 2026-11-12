package org.architectum_workshop.archeologic_caverns.common.item.impl;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface ArtifactTooltipImpl {
    default Component getArtifactTooltip(ItemStack stack, Player player) {
        return Component.empty();
    }
}
