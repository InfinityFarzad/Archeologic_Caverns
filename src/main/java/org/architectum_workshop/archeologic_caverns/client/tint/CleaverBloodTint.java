package org.architectum_workshop.archeologic_caverns.client.tint;


import com.mojang.serialization.MapCodec;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.jetbrains.annotations.Nullable;

public record CleaverBloodTint() implements ItemTintSource {
    public static final MapCodec<CleaverBloodTint> CODEC = MapCodec.unit(CleaverBloodTint::new);

    @Override
    public int calculate(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity) {
        if (clientLevel != null && livingEntity instanceof Player player && player.hasAttached(ACAttachments.PLAYER_COMBO_COUNTER)) {
            int f = player.getAttachedOrElse(ACAttachments.PLAYER_COMBO_COUNTER,0);
            return ARGB.linearLerp(CleaverUtil.calculateModifier(5,f), -1, ARGB.color(255,0,0));
        }

        return -1;
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return CODEC;
    }

}
