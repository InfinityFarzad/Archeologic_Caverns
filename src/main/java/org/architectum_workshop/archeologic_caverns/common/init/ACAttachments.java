package org.architectum_workshop.archeologic_caverns.common.init;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACAttachments {

    AttachmentType<Integer> PLAYER_COMBO_COUNTER =
            AttachmentRegistry.create(
                    ArcheologicCaverns.id("player_combo_counter"),
                    builder -> builder.initializer(() -> 0).persistent(Codec.INT).syncWith(ByteBufCodecs.INT, AttachmentSyncPredicate.all()));
    static void init() {}
}
