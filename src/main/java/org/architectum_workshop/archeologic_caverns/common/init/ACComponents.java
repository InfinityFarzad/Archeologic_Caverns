package org.architectum_workshop.archeologic_caverns.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACComponents {

    DataComponentType<Float> GREATAXE_SHATTERED = Registry.register(
        BuiltInRegistries.DATA_COMPONENT_TYPE,
            ArcheologicCaverns.id("greeataxe_shattered"),
            DataComponentType.<Float>builder().networkSynchronized(ByteBufCodecs.FLOAT).ignoreSwapAnimation().persistent(Codec.FLOAT).build()
    );

    DataComponentType<Boolean> GREATAXE_CHARGE = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ArcheologicCaverns.id("greeataxe_charge"),
            DataComponentType.<Boolean>builder().networkSynchronized(ByteBufCodecs.BOOL).ignoreSwapAnimation().persistent(Codec.BOOL).build()
    );

    static void init() {}
}
