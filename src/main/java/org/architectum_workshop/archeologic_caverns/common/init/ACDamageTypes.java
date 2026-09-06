package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageType;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACDamageTypes {

    ResourceKey<DamageType> IN_SALT = ResourceKey.create(Registries.DAMAGE_TYPE, ArcheologicCaverns.id("in_salt"));

    static void bootstrap(final BootstrapContext<DamageType> context) {
        context.register(IN_SALT, new DamageType("inSalt", 0.1F, DamageEffects.POKING));
    }
}
