package org.architectum_workshop.archeologic_caverns.common.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.DripstoneClusterFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DripstoneClusterConfiguration;

public class AmberSpikes extends DripstoneClusterFeature {
    public AmberSpikes(Codec<DripstoneClusterConfiguration> codec) {
        super(codec);
    }
}
