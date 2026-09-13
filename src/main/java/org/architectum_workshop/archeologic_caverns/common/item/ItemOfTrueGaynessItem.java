package org.architectum_workshop.archeologic_caverns.common.item;

import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class ItemOfTrueGaynessItem extends Item {
    public ItemOfTrueGaynessItem(Properties properties) {
        super(properties);
    }
    public int color = 0;

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        color += 1000;
        super.inventoryTick(itemStack, level, owner, slot);
    }
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.sendOverlayMessage(Component.literal("You are not gay enough to use this item.").withColor(color));
        return InteractionResult.SUCCESS;
    }
}
