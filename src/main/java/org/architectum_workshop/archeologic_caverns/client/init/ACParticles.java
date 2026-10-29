package org.architectum_workshop.archeologic_caverns.client.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

import java.util.function.Function;

public interface ACParticles {


    SimpleParticleType BLEEDING_PARTICLE = register("bleeding");


    private static SimpleParticleType register(String id) {
        Function<SimpleParticleType, SimpleParticleType> g = (i) -> {
            Registry.register(BuiltInRegistries.PARTICLE_TYPE, ArcheologicCaverns.id(id), i);
            return i;
        };
        return g.apply(FabricParticleTypes.simple());
    }

    static void init() {}

}
