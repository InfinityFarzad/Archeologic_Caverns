package org.architectum_workshop.archeologic_caverns.client.tint;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ARGB;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.jspecify.annotations.Nullable;

public record BloodTintType() implements ItemTintSource {
    public static final MapCodec<BloodTintType> CODEC = MapCodec.unit(BloodTintType::new);

    @Override
    public int calculate(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity) {
        if (clientLevel != null && livingEntity instanceof Player player && player.hasAttached(ACAttachments.PLAYER_COMBO_COUNTER)) {
            int f = player.getAttached(ACAttachments.PLAYER_COMBO_COUNTER);

            return ARGB.color(20 * f + 20,0xFFEFD5);
        }

        return ARGB.color(20 * 1 + 20,0xFFEFD5);
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return CODEC;
    }

}
