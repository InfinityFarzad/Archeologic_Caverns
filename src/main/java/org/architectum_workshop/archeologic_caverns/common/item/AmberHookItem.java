package org.architectum_workshop.archeologic_caverns.common.item;

import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.architectum_workshop.archeologic_caverns.common.util.AmberHookUtil;
import org.architectum_workshop.archeologic_caverns.common.util.datatype.ClimbPos;
import org.jspecify.annotations.Nullable;

public class AmberHookItem extends Item {
    public AmberHookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        HitResult result = player.pick(4.0f, 1.f, false);
        if (result.getType() == HitResult.Type.BLOCK && !AmberHookUtil.isUsingAmberHook(player)) {
            BlockHitResult blockHitResult = (BlockHitResult)result;
            ClimbPos climbPos = new ClimbPos(blockHitResult.getBlockPos(), result.getLocation());
            AmberHookUtil.storeHookPos(player, hand, climbPos);

            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }

        return super.use(level, player, hand);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.TRIDENT;
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) {
        return 72000;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if (owner instanceof ServerPlayer player) {
            if (AmberHookUtil.isUsingAmberHook(player)) {
                ClimbPos pos = AmberHookUtil.getCurrentHookPos(player, InteractionHand.MAIN_HAND);
                Vec3 to = player.position().vectorTo(pos.hangPos()).normalize();

                double distance = player.position().distanceTo(pos.hangPos());
                double f = distance / 3f;
                Vec3 wa;


                if (distance > 0.8) {
                     wa = to.multiply(f,f,f);
                } else {
                     wa = Vec3.ZERO;
                }
                player.needsSync=true;
                player.setDeltaMovement(wa);
                player.connection.send(new ClientboundSetEntityMotionPacket(player.getId(), wa));

            }
        }

        super.inventoryTick(itemStack, level, owner, slot);
    }
}
