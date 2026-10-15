package org.architectum_workshop.archeologic_caverns.client.particle;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class BloodParticle extends SingleQuadParticle {
    protected BloodParticle(ClientLevel level, double x, double y, double z, TextureAtlasSprite sprite) {
        super(level, x, y, z, sprite);
    }

    @Override
    public void extract(QuadParticleRenderState particleTypeRenderState, Camera camera, float partialTickTime) {
        super.extract(particleTypeRenderState, camera, partialTickTime);

    }

    @Override
    protected Layer getLayer() {
        return Layer.OPAQUE;
    }


}
