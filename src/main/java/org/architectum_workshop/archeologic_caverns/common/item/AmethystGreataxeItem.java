package org.architectum_workshop.archeologic_caverns.common.item;

import net.akws.chiseled_lib.client.camera.screenshake.ScreenShakeHelper;
import net.akws.chiseled_lib.common.ChiseledLib;
import net.akws.chiseled_lib.common.interfaces.item.CustomAttackItem;
import net.akws.chiseled_lib.common.interfaces.item.CustomEffectsItem;
import net.akws.chiseled_lib.common.interfaces.mixin_interface.TimerInterface;
import net.akws.chiseled_lib.common.util.TimerUtil;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.init.ACComponents;
import org.architectum_workshop.archeologic_caverns.common.init.ACTags;
import org.architectum_workshop.archeologic_caverns.common.item.impl.ArtifactTooltipImpl;
import org.jspecify.annotations.Nullable;

public class AmethystGreataxeItem extends AxeItem implements ArtifactTooltipImpl, CustomEffectsItem, CustomAttackItem {
    public static final Identifier TIMER_ID = ArcheologicCaverns.id("axe_repair_timer");

    public AmethystGreataxeItem(Properties properties, float attackDamage, float attackSpeed) {
        super(new ToolMaterial(BlockTags.INCORRECT_FOR_COPPER_TOOL, 520, 1561, 0.0f, 15, ACTags.Items.AMETHYST_TOOL_REPAIRABLE), attackDamage, attackSpeed, properties.component(ACComponents.GREATAXE_SHATTERED, 0.f).component(ACComponents.GREATAXE_CHARGE, false));
    }

    @Override
    public boolean canDoSweepingAttack(LivingEntity living, ItemStack stack, boolean cooldownPassed, boolean criticalHit, boolean knockbackAttack) {
        return !knockbackAttack && !criticalHit && cooldownPassed;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.get(ACComponents.GREATAXE_SHATTERED) <=0) {
            stack.set(ACComponents.GREATAXE_SHATTERED, 0.f);
            stack.set(ACComponents.GREATAXE_CHARGE, true);
            player.getCooldowns().addCooldown(stack, 15);
        } else {
            stack.set(ACComponents.GREATAXE_SHATTERED, stack.get(ACComponents.GREATAXE_SHATTERED) - 10.f);
        }

        player.playSound(SoundEvents.AMETHYST_BLOCK_PLACE);
        return super.use(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        super.inventoryTick(itemStack, level, owner, slot);
        float i = itemStack.get(ACComponents.GREATAXE_SHATTERED);

        if (i != 40.f && itemStack.getOrDefault(ACComponents.GREATAXE_CHARGE, false)) {
            itemStack.set(ACComponents.GREATAXE_SHATTERED, Math.clamp(i + 8, 0, 40));
            level.playSound(null, owner.getX(), owner.getY(), owner.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.PLAYERS);
            level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK_CRUMBLE, Blocks.AMETHYST_BLOCK.defaultBlockState()), owner.getX(), owner.getY(), owner.getZ(), 2, 2, 2, 2, 2);
        } else {
            itemStack.set(ACComponents.GREATAXE_CHARGE, false);
        }
    }
}
