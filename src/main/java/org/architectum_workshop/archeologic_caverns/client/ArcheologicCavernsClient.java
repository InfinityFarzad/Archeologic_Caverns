package org.architectum_workshop.archeologic_caverns.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import org.architectum_workshop.archeologic_caverns.client.init.ACParticles;
import org.architectum_workshop.archeologic_caverns.client.particle.BloodParticle;
import org.architectum_workshop.archeologic_caverns.client.tint.CleaverBloodTint;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;

public class ArcheologicCavernsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, _, _, list) -> {
            if (stack.getItem() instanceof CleaverItem) {
                list.add(1, Component.translatable("tooltip.archeologic_caverns.cleaver_explain").withStyle(ChatFormatting.DARK_GRAY));
                list.add((int) ((long) list.size() -2), Component.translatable("tooltip.archeologic_caverns.cleaver_drop_bonus").withStyle(ChatFormatting.BLUE));
            }

        });
        ItemTintSources.ID_MAPPER.put(ArcheologicCaverns.id("bleeding"), CleaverBloodTint.CODEC);
        ParticleProviderRegistry.getInstance().register(ACParticles.BLEEDING_PARTICLE, BloodParticle.Provider::new);
    }
}
