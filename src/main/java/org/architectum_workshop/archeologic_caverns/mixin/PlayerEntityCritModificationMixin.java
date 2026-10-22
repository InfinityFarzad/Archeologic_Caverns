package org.architectum_workshop.archeologic_caverns.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerEntityCritModificationMixin {

    @Shadow
    protected abstract void playServerSideSound(SoundEvent sound);

    @Inject(method = "canCriticalAttack", at = @At("HEAD"), cancellable = true)
    private void archeologic_caverns$modifyCrit(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player) (Object)this;
        if (archeologic_caverns$isCleaverCrit(player)) {
            cir.setReturnValue(true);
        }

    }

    // move to chiseledlib in the next update
    @Inject(method = "attackVisualEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;playServerSideSound(Lnet/minecraft/sounds/SoundEvent;)V"))
    private void archeologic_caverns$modifyCritSound(Entity entity, boolean criticalAttack, boolean sweepAttack, boolean fullStrengthAttack, boolean stabAttack, float magicBoost, CallbackInfo ci) {
        Player player = (Player) (Object)this;
        if (archeologic_caverns$isCleaverCrit(player)) {
            this.playServerSideSound(SoundEvents.CREAKING_DEACTIVATE);
        }
    }

    @Unique
    private boolean archeologic_caverns$isCleaverCrit(Player player) {
        return player.getWeaponItem().getItem() instanceof CleaverItem && CleaverUtil.getCombo(player) >= 8;
    }

}
