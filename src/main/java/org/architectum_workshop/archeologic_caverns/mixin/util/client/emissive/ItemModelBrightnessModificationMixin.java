package org.architectum_workshop.archeologic_caverns.mixin.util.client.emissive;

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

// the only reason for the rather overcomplicated name, is so IntelliJ does not give me spelling mistake errors.

@Mixin(CuboidItemModelWrapper.class)
public class ItemModelBrightnessModificationMixin {
    @Inject(method = "update", at = @At("HEAD"))
    private void archeologic_caverns$applyEmissive(ItemStackRenderState output, ItemStack item, ItemModelResolver resolver, ItemDisplayContext displayContext, ClientLevel level, ItemOwner owner, int seed, CallbackInfo ci) {
        ((ItemStackRenderStateInterface) output).archeologic_caverns$setEmissive(item.getOrDefault(ACComponents.EMISSIVE_COMPONENT, false));
    }
}
