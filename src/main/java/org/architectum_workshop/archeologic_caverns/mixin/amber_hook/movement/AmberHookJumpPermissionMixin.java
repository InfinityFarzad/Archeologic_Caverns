package org.architectum_workshop.archeologic_caverns.mixin.amber_hook.movement;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.architectum_workshop.archeologic_caverns.common.util.AmberHookUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class AmberHookJumpPermissionMixin {

    @Shadow
    public ServerPlayer player;

    @WrapOperation(method = "handleMovePlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ServerboundMovePlayerPacket;isOnGround()Z"))
    private boolean archeologic_caverns$allowClimbJumps(ServerboundMovePlayerPacket instance, Operation<Boolean> original) {
        return AmberHookUtil.isUsingAmberHook(this.player) || original.call(instance);
    }

}
