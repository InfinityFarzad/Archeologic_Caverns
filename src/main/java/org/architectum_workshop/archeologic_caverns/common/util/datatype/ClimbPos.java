package org.architectum_workshop.archeologic_caverns.common.util.datatype;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.phys.Vec3;

public record ClimbPos(BlockPos pos, Vec3 hangPos) {
    public static Codec<ClimbPos> CODEC = RecordCodecBuilder.create(i -> i.group(BlockPos.CODEC.fieldOf("pos").forGetter(ClimbPos::pos), Vec3.CODEC.fieldOf("hang_pos").forGetter(ClimbPos::hangPos)).apply(i, ClimbPos::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, ClimbPos> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            ClimbPos::pos,
            Vec3.STREAM_CODEC,
            ClimbPos::hangPos,
            ClimbPos::new
    );
}
