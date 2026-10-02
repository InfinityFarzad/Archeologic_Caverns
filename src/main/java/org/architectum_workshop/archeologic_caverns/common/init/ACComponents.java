package org.architectum_workshop.archeologic_caverns.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACComponents {
    DataComponentType<Boolean> EMISSIVE_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ArcheologicCaverns.id("emissive_component"),
            DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build()
    );

    static void init() {}
}
