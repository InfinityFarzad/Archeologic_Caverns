package org.architectum_workshop.archeologic_caverns.mixin.client.emissive;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.CuboidItemModelWrapper;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.architectum_workshop.archeologic_caverns.common.init.ACComponents;
import org.architectum_workshop.archeologic_caverns.common.util.mixinInterfaces.ItemStackRenderStateInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CuboidItemModelWrapper.class)
public class ApplyEmissivenessMixin {
    @Inject(method = "update", at = @At("HEAD"))
    private void archeologic_caverns$applyEmissive(ItemStackRenderState output, ItemStack item, ItemModelResolver resolver, ItemDisplayContext displayContext, ClientLevel level, ItemOwner owner, int seed, CallbackInfo ci) {
        ((ItemStackRenderStateInterface)output).setEmissive(item.getOrDefault(ACComponents.EMISSIVE_COMPONENT, false));
    }
}
