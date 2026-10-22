package org.architectum_workshop.archeologic_caverns.common.item;

import net.akws.chiseled_lib.common.interfaces.item.CustomAttackItem;
import net.akws.chiseled_lib.common.interfaces.item.CustomEffectsItem;
import net.akws.chiseled_lib.common.util.TimerUtil;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Weapon;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.jspecify.annotations.Nullable;

public class CleaverItem extends AxeItem implements CustomAttackItem, CustomEffectsItem {

    public static final Identifier PLAYER_COMBO_ID = ArcheologicCaverns.id("cleaver_combo_timer");

    public CleaverItem(ToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline, Properties properties) {
        super(material, attackDamageBaseline, attackSpeedBaseline, properties.durability(1200));
    }

    @Override
    public void onFullAttack(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (attacker instanceof Player player) {
            int currentCombo = CleaverUtil.getCombo(player);

            player.setAttached(ACAttachments.PLAYER_COMBO_COUNTER, Math.min(currentCombo + 1, 12));
            if (!player.level().isClientSide() && !target.isInvulnerable()) {
                TimerUtil.addTimerToPlayer(player, PLAYER_COMBO_ID, CleaverUtil.calculateTimer(player, stack));
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
}
