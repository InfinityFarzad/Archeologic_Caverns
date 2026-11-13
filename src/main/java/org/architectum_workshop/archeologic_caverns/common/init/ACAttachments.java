package org.architectum_workshop.archeologic_caverns.common.init;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.codec.ByteBufCodecs;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.util.datatype.ClimbPos;

public interface ACAttachments {

    AttachmentType<Integer> PLAYER_COMBO_COUNTER =
            AttachmentRegistry.create(
                    ArcheologicCaverns.id("player_combo_counter"),
                    builder -> builder.initializer(() -> 0).persistent(Codec.INT).syncWith(ByteBufCodecs.INT, AttachmentSyncPredicate.all()));


    AttachmentType<ClimbPos> MAIN_HOOK_POS =
            AttachmentRegistry.create(
                    ArcheologicCaverns.id("main_hook_pos"),
                    builder -> builder.syncWith(ClimbPos.STREAM_CODEC, AttachmentSyncPredicate.all())
            );

    AttachmentType<ClimbPos> OFFHAND_HOOK_POS =
            AttachmentRegistry.create(
                    ArcheologicCaverns.id("offhand_hook_pos"),
                    builder -> builder.syncWith(ClimbPos.STREAM_CODEC, AttachmentSyncPredicate.all())
            );


    static void init() {}
}
