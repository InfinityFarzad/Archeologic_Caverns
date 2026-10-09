package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;

public interface ACSounds {

    SoundEvent CLEAVER_SLASH = register("cleaver_slash");

    static SoundEvent register(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, ArcheologicCaverns.id(id), SoundEvent.createVariableRangeEvent(ArcheologicCaverns.id(id)));
    }

    static void init() {}
}
