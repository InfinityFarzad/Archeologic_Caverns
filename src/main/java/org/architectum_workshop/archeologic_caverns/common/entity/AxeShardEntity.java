package org.architectum_workshop.archeologic_caverns.common.entity;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.architectum_workshop.archeologic_caverns.common.init.ACEntities;

public class AxeShardEntity extends AbstractArrow {

    private int timeLeft = 60;
    private Entity target = null;
    public boolean isInTarget = false;

    public AxeShardEntity(EntityType<AxeShardEntity> axeShardEntityEntityType, Level level) {
        super(axeShardEntityEntityType, level);
    }

    public AxeShardEntity(ServerLevel level, LivingEntity owner, ItemStack stack) {
        super(ACEntities.AXE_SHARD, owner, level, stack, null);
        this.setOwner(owner);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        isInTarget = true;
        target=hitResult.getEntity();
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        onBreak(hitResult.getLocation());
    }

    private void onBreak(Vec3 pos) {
        spawnBlockBreakParticles(pos, 4);
        this.level().playSound(null, pos.x, pos.y, pos.z, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS);
        if (target!=null && owner!=null) {
            if (level() instanceof ServerLevel level) {
                target.hurtServer(level, this.owner.getEntity(level, Entity.class).damageSources().generic(), 0.5f);
            }
        }

        this.discard();
    }

    private void spawnBlockBreakParticles(Vec3 pos, int particleCount) {
        var particle = new BlockParticleOption(ParticleTypes.BLOCK_CRUMBLE, Blocks.AMETHYST_BLOCK.defaultBlockState());

        for (int i = 0; i < particleCount; i++) {
            this.level().addParticle(particle, pos.x, pos.y, pos.z, random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1), random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1), random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1));
        }
        if (level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(particle, pos.x, pos.y, pos.z, particleCount, random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1), random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1), random.nextGaussian()/20.0 * (random.nextBoolean() ? 1 : -1), 1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (target!=null) {
            this.setDeltaMovement(target.getDeltaMovement());
            this.timeLeft--;

            if (target instanceof LivingEntity living) {
                if (living.isDeadOrDying()) {
                    this.discard();
                }
            }

        }

    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.AMETHYST_SHARD);
    }

}
