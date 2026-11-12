package org.architectum_workshop.archeologic_caverns.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.ARGB;
import org.architectum_workshop.archeologic_caverns.client.init.ACParticles;
import org.architectum_workshop.archeologic_caverns.client.particle.BloodParticle;
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
                list.add(1, gradient("Cavern Artifact",List.of(0x89ecd8, 0x2cf859)).withStyle(ChatFormatting.BOLD));
                if (Minecraft.getInstance().hasShiftDown()) {
                    list.add(1, Component.empty());
                    list.add(1, artifactTooltip.getArtifactTooltip(stack, Minecraft.getInstance().player));
                    list.add(1, Component.literal("-...-").withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    list.add(1, Component.translatable("tooltip.archeologic_caverns.artifact_explain", Component.literal("Shift").withStyle(ChatFormatting.GOLD)).withStyle(ChatFormatting.DARK_GRAY));
                }
            }
        });
        ItemTintSources.ID_MAPPER.put(ArcheologicCaverns.id("bleeding"), CleaverBloodTint.CODEC);
        ParticleProviderRegistry.getInstance().register(ACParticles.BLEEDING_PARTICLE, BloodParticle.Provider::new);
    }

    @SuppressWarnings("SameParameterValue")
    private MutableComponent gradient(String text, List<Integer> colours) {
        List<Character> charList = text.chars()
                .mapToObj(c -> (char) c)
                .toList();

        MutableComponent component = Component.empty();
        int lastColour = colours.getFirst();

        for (int index = 0; index  < charList.size(); index++) {
            int color;
            Character character = charList.get(index);

            if (charList.size() == colours.size()) {
                color = colours.get(index);
            } else {
                float wordProgress = (float) (index + 1) / charList.size();

                float colourIndexUndone = (colours.size()-1) * wordProgress;
                int completeIndex = (int) Math.clamp(colourIndexUndone, 0, colours.size()-1);

                float g = (colourIndexUndone-completeIndex);
                color = ARGB.linearLerp(Math.clamp(g, 0, colours.size()-1), colours.get(completeIndex), colours.get(Math.clamp(completeIndex+1,0, colours.size()-1)));
            }

            component.append(Component.literal(character.toString()).withColor(color));
            if (lastColour != color) {
                lastColour=color;
            }

        }
        return component;
    }

}
