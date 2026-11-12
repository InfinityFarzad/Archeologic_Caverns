package org.architectum_workshop.archeologic_caverns.common.item;

import net.akws.chiseled_lib.common.interfaces.item.CustomAttackItem;
import net.akws.chiseled_lib.common.interfaces.item.CustomEffectsItem;
import net.akws.chiseled_lib.common.util.TimerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import org.architectum_workshop.archeologic_caverns.client.init.ACParticles;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.item.impl.ArtifactTooltipImpl;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.jspecify.annotations.Nullable;

public class CleaverItem extends AxeItem implements CustomAttackItem, CustomEffectsItem, ArtifactTooltipImpl {

    public static final Identifier PLAYER_COMBO_ID = ArcheologicCaverns.id("cleaver_combo_timer");

    public CleaverItem(ToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline, Properties properties) {
        super(material, attackDamageBaseline, attackSpeedBaseline, properties.durability(1200).tool(material, BlockTags.MINEABLE_WITH_AXE, attackDamageBaseline, attackSpeedBaseline, 1.0f));
    }
    @Override
    public void onFullAttack(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (attacker instanceof Player player) {
            int currentCombo = CleaverUtil.getCombo(player);

            player.setAttached(ACAttachments.PLAYER_COMBO_COUNTER, Math.min(currentCombo + 1, 12));
            if (!player.level().isClientSide() && !target.isInvulnerable()) {
                TimerUtil.addTimerToPlayer(player, PLAYER_COMBO_ID, CleaverUtil.calculateTimer(player));
                if (currentCombo+1 == 8) {
                    player.playSound(SoundEvents.CREAKING_DEATH);
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        super.inventoryTick(itemStack, level, owner, slot);
        if (owner instanceof Player living) {
            CleaverUtil.modifyDamage(3, living, itemStack);
        }
    }

    @Override
    public boolean canDoSweepingAttack(ItemStack stack, boolean cooldownPassed, boolean criticalHit, boolean knockbackAttack) {
        return false;
    }

    @Override
    public ParticleOptions critParticles(ItemStack stack) {
        return ACParticles.BLEEDING_PARTICLE;
    }

    @Override
    public Component getArtifactTooltip(ItemStack stack, Player player) {
        return Component.translatable("tooltip.archeologic_caverns.cleaver_explain").withStyle(ChatFormatting.GRAY);
    }
}
