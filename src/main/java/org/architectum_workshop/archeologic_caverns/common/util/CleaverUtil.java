package org.architectum_workshop.archeologic_caverns.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;

public class CleaverUtil {
    public static float offsetCalculateModifier(float max, float value) {
        return 1 - Math.abs(Math.clamp(value, 0, max) / max);
    }

    public static float calculateModifier(float max, float value) {
        return Math.abs(Math.clamp(value, 0, max) / max);
    }

    public static void renderCleaverOverlay(GuiGraphicsExtractor graphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player != null) {
            int comboCount = player.getAttachedOrElse(ACAttachments.PLAYER_COMBO_COUNTER, 0);
            float modifier = calculateModifier(9, comboCount);
            if (modifier > 0) {
                graphics.blit(RenderPipelines.VIGNETTE, Identifier.withDefaultNamespace("textures/misc/vignette.png"), 0, 0, 0.0f, 0.0f, graphics.guiWidth(), graphics.guiHeight(), graphics.guiWidth(), graphics.guiHeight(), ARGB.colorFromFloat(1, 0, modifier * 10, modifier * 10));
            }
        }
    }

    public static void modifyDamage(float damage, Player player, ItemStack stack) {
        int f = player.getAttachedOrSet(ACAttachments.PLAYER_COMBO_COUNTER, 0);
        ItemAttributeModifiers modifiers = stack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.builder().build());
        stack.set(DataComponents.ATTRIBUTE_MODIFIERS, modifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(ArcheologicCaverns.id("extra_cleaver_damage"), Math.floor(damage * (CleaverUtil.calculateModifier(9, f)) * 10) / 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND));
    }

}
