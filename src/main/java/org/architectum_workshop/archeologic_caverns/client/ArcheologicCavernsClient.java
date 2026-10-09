package org.architectum_workshop.archeologic_caverns.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.AltItemRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.network.chat.Component;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;

public class ArcheologicCavernsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, flag, list) -> {
            if (stack.getItem() instanceof CleaverItem) {
                list.add(1, Component.literal("Effect:").withStyle(ChatFormatting.GRAY));
                list.add(2,Component.translatable("item.archeologic_caverns.cleaver_bonus").withStyle(ChatFormatting.DARK_GRAY));

            }
        });
    }
}
