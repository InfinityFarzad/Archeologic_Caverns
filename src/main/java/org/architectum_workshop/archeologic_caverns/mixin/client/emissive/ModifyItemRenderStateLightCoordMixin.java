package org.architectum_workshop.archeologic_caverns.mixin.client.emissive;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.util.LightCoordsUtil;
import org.architectum_workshop.archeologic_caverns.common.util.mixinInterfaces.ItemStackRenderStateInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStackRenderState.class)
public class ModifyItemRenderStateLightCoordMixin implements ItemStackRenderStateInterface {
    @Unique
    private boolean archeologic_caverns$isEmissive = false;

    @WrapOperation(method = "submit", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/item/ItemStackRenderState$LayerRenderState;submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;III)V"))
    private void archeologic_Caverns$causeEmission(ItemStackRenderState.LayerRenderState instance, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, int outlineColor, Operation<Void> original) {
        if (archeologic_caverns$isEmissive) {
            original.call(instance, poseStack, submitNodeCollector, LightCoordsUtil.FULL_BRIGHT, overlayCoords, outlineColor);
        } else {
            original.call(instance, poseStack, submitNodeCollector, lightCoords, overlayCoords, outlineColor);
        }
    }

    @Override
    public void setEmissive(boolean value) {
        archeologic_caverns$isEmissive = value;
    }
}
