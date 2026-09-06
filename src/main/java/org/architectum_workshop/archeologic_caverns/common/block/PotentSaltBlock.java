package org.architectum_workshop.archeologic_caverns.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.architectum_workshop.archeologic_caverns.common.init.ACDamageTypes;

public class PotentSaltBlock extends Block {
    public PotentSaltBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        super.fallOn(level, state, pos, entity, fallDistance);
        if (entity instanceof LivingEntity livingEntity && isDamaged(livingEntity)) {
            livingEntity.hurt(damageSource(entity), damageDegree(livingEntity));
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        super.stepOn(level, pos, onState, entity);
        if (entity instanceof LivingEntity livingEntity && isDamaged(livingEntity)) {
            if (level instanceof ServerLevel serverLevel) {
                livingEntity.hurtServer(serverLevel, damageSource(entity), damageDegree(livingEntity));
            }
        }
    }

    public static DamageSource damageSource(Entity entity) {
        return new DamageSource(entity.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(ACDamageTypes.IN_SALT));
    }

    public static boolean isDamaged(LivingEntity entity) {
        return entity.getHealth() < entity.getMaxHealth();
    }
    public static float damageDegree(LivingEntity entity) {
        return (entity.getMaxHealth() - entity.getHealth()) * 0.5f;
    }
}
