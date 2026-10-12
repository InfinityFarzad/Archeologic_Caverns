package org.architectum_workshop.archeologic_caverns.mixin.client;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.Identifier;
import org.architectum_workshop.archeologic_caverns.common.util.mixinInterfaces.IShaderOverride;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GameRenderer.class)
public abstract class PostEffectsAccessMixin implements IShaderOverride {

    @Shadow
    protected abstract void setPostEffect(Identifier id);

    @Shadow
    public abstract @Nullable Identifier currentPostEffect();

    @Shadow
    public abstract void clearPostEffect();

    @Override
    public void archeologic_caverns$enable() {

    }

    @Override
    public void archeologic_caverns$setShader(Identifier id) {
        setPostEffect(id);
    }

    @Override
    public void archeologic_caverns$clear_shaders() {
        clearPostEffect();
    }

    @Override
    public Identifier archeologic_caverns$getShader() {
        return currentPostEffect();
    }
}
