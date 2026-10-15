package org.architectum_workshop.archeologic_caverns.mixin.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class CleaverComboOverlayMixin {
    @Inject(method = "extractCameraOverlays", at = @At("HEAD"))
    private void archeologic_caverns$applyCleaverOverlay(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        CleaverUtil.renderCleaverOverlay(graphics);
    }
}
