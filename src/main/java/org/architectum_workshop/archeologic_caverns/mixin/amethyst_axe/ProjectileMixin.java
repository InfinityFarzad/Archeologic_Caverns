package org.architectum_workshop.archeologic_caverns.mixin.amethyst_axe;

import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import org.architectum_workshop.archeologic_caverns.common.entity.AxeShardEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractArrow.class)
public class ProjectileMixin {

    @Inject(at = @At("HEAD"), method = "shouldFall", cancellable = true)
    private void archeologic_caverns$shouldFall(CallbackInfoReturnable<Boolean> cir) {
        AbstractArrow arrow = (AbstractArrow) (Object)this;
        if (arrow instanceof AxeShardEntity axeShardEntity && axeShardEntity.isInTarget) {
            cir.setReturnValue(false);
        }
    }

}
