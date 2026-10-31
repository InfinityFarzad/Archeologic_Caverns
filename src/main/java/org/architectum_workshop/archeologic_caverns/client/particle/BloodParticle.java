package org.architectum_workshop.archeologic_caverns.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.joml.Quaternionf;
import org.jspecify.annotations.Nullable;

public class BloodParticle extends SingleQuadParticle {


    private final SpriteSet sprites;
    private boolean dir;

    protected BloodParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites) {
        super(level, x, y, z, sprites.first());
        this.sprites = sprites;
        this.xd = (Mth.clamp(Mth.abs((float) (random.nextGaussian() / 10.0)),0, 0.05)) * (random.nextBoolean() ? 1 : -1) * (random.nextBoolean() ? 1 : 0) * 2;
        this.zd = (Mth.clamp(Mth.abs((float) (random.nextGaussian() / 10.0)),0, 0.05)) * (random.nextBoolean() ? 1 : -1) * (random.nextBoolean() ? 1 : 0) * 2;
        this.yd = 1;
        this.dir = random.nextBoolean();
        this.roll = (float) random.nextGaussian();
        this.lifetime = 40;
        this.hasPhysics = true;
        this.quadSize = 0.5f;
        this.friction = 1.0f;
        this.gravity = 4.0f;
        this.rCol = 0.8f;
        this.gCol = 0.8f;
        this.bCol = 0.2f;
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(sprites);
        if (!onGround) {
            this.roll += 0.05f * (dir ? -1 : 1);
            this.oRoll = Mth.lerp((float) 1, this.oRoll, this.roll);
        } else {
            this.quadSize = 0.8f;
        }
    }

    @Override
    protected void extractRotatedQuad(QuadParticleRenderState particleTypeRenderState, Camera camera, Quaternionf rotation, float partialTickTime) {
        if (onGround) {
            super.extractRotatedQuad(particleTypeRenderState, camera, new Quaternionf().rotateX((float) Math.toRadians(-90.1f)), partialTickTime);
        } else {
            super.extractRotatedQuad(particleTypeRenderState, camera, rotation, partialTickTime);
        }

    }

    @Override
    protected void extractRotatedQuad(QuadParticleRenderState particleTypeRenderState, Quaternionf rotation, float x, float y, float z, float partialTickTime) {
        particleTypeRenderState.add(this.getLayer(), x, y+0.05f, z, rotation.x, rotation.y, rotation.z, rotation.w, this.getQuadSize(partialTickTime), this.getU0(), this.getU1(), this.getV0(), this.getV1(), ARGB.colorFromFloat(this.alpha, this.rCol, this.gCol, this.bCol), this.getLightCoords(partialTickTime));
    }

    @Environment(value= EnvType.CLIENT)
    public static class Provider
            implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType options, ClientLevel level, double x, double y, double z, double xAux, double yAux, double zAux, RandomSource random) {
            return new BloodParticle(level, x, y, z, sprites);
        }
    }
}
