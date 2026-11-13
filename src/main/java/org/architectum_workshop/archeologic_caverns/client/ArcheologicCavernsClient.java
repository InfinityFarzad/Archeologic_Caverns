package org.architectum_workshop.archeologic_caverns.client;

import net.akws.chiseled_lib.client.util.RenderUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.ARGB;
import org.architectum_workshop.archeologic_caverns.client.init.ACParticles;
import org.architectum_workshop.archeologic_caverns.client.particle.BloodParticle;
import org.architectum_workshop.archeologic_caverns.client.render.item.AmethystGreataxeModelProperty;
import org.architectum_workshop.archeologic_caverns.client.tint.CleaverBloodTint;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;
import org.architectum_workshop.archeologic_caverns.common.item.impl.ArtifactTooltipImpl;

import java.util.List;

public class ArcheologicCavernsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, _, _, list) -> {
            if (stack.getItem() instanceof CleaverItem) {
                list.add((int) ((long) list.size() -2), Component.translatable("tooltip.archeologic_caverns.cleaver_drop_bonus").withStyle(ChatFormatting.BLUE));
            }
            if (stack.getItem() instanceof ArtifactTooltipImpl artifactTooltip) {
                if (Minecraft.getInstance().hasShiftDown()) {
                    list.add(1, Component.empty());
                    list.add(1, artifactTooltip.getArtifactTooltip(stack, Minecraft.getInstance().player));
                    list.add(1, Component.literal("-...-").withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    list.add(1, Component.translatable("tooltip.archeologic_caverns.artifact_explain", Component.literal("Shift").withStyle(ChatFormatting.GOLD)).withStyle(ChatFormatting.DARK_GRAY));
                }
                list.add(1, RenderUtil.createTextGradient("Cavern Artifact", artifactTooltip.getArtifactColour()).withStyle(ChatFormatting.BOLD));

            }
        });

        RangeSelectItemModelProperties.ID_MAPPER.put(ArcheologicCaverns.id("greataxe_stage"), AmethystGreataxeModelProperty.MAP_CODEC);
        ItemTintSources.ID_MAPPER.put(ArcheologicCaverns.id("bleeding"), CleaverBloodTint.CODEC);
        ParticleProviderRegistry.getInstance().register(ACParticles.BLEEDING_PARTICLE, BloodParticle.Provider::new);
    }

}
