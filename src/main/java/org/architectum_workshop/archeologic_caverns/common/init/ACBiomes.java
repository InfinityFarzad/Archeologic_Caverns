package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import terrablender.api.TerraBlenderApi;

public interface ACBiomes{
    ResourceKey<Biome> AMBER_CAVES = register("amber_caves");

    static ResourceKey<Biome> register(String id) {
        return ResourceKey.create(Registries.BIOME, ArcheologicCaverns.id(id));
    }

    static void init() {}
}
