package org.architectum_workshop.archeologic_caverns.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.AltItemRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.architectum_workshop.archeologic_caverns.client.tint.BloodTintType;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACItems;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;
import org.architectum_workshop.archeologic_caverns.common.util.mixinInterfaces.IShaderOverride;
import org.architectum_workshop.archeologic_caverns.mixin.client.PostEffectsAccessMixin;

import java.util.Objects;

public class ArcheologicCavernsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, flag, list) -> {
            if (stack.getItem() instanceof CleaverItem) {
                list.add(1, Component.literal("Effect:").withStyle(ChatFormatting.GRAY));
                list.add(2,Component.translatable("item.archeologic_caverns.cleaver_bonus").withStyle(ChatFormatting.DARK_GRAY));

            }
        });
        ItemTintSources.ID_MAPPER.put(ArcheologicCaverns.id("blood_chud"), BloodTintType.CODEC);
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            Player player = client.player;
            if (player != null && client.player.isHolding(ACItems.CLEAVER)) {
               // effectAccess.archeologic_caverns$clear_shaders();
                ((IShaderOverride) client.gameRenderer).archeologic_caverns$setShader(ArcheologicCaverns.id("bleeding"));
            } else {
                if (((IShaderOverride) client.gameRenderer).archeologic_caverns$getShader() != null && Objects.equals(((IShaderOverride) client.gameRenderer).archeologic_caverns$getShader(), ArcheologicCaverns.id("bleeding"))) {
                    ((IShaderOverride) client.gameRenderer).archeologic_caverns$clear_shaders();
                }

            }
            //

        });
    }
}
