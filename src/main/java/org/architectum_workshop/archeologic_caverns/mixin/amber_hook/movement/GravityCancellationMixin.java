package org.architectum_workshop.archeologic_caverns.mixin.amber_hook.movement;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.architectum_workshop.archeologic_caverns.common.util.AmberHookUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class GravityCancellationMixin {
    @Inject(at = @At("RETURN"), method = "getEffectiveGravity", cancellable = true)
    private void archeologic_caverns$cancel_gravity(CallbackInfoReturnable<Double> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object)this;
        if (livingEntity instanceof Player player) {
            if (AmberHookUtil.isUsingAmberHook(player)) {
                cir.setReturnValue(0.0);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "jumpFromGround")
    private void archeologic_caverns$cancelHooking(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object)this;
        if (livingEntity instanceof Player player && AmberHookUtil.isUsingAmberHook(player)) {
            //player.stopUsingItem();
        }
    }
}
