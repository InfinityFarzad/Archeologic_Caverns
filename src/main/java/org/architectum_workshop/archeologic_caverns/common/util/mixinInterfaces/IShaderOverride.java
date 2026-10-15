package org.architectum_workshop.archeologic_caverns.common.util.mixinInterfaces;

import net.minecraft.resources.Identifier;

public interface IShaderOverride {
    void archeologic_caverns$setShader(Identifier id);

    Identifier archeologic_caverns$getShader();

    void archeologic_caverns$clear_shaders();

    void archeologic_caverns$enable();
}
