package org.architectum_workshop.archeologic_caverns.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantedCountIncreaseFunction.class)
public abstract class CleaverLoottableModifier {

    @Shadow
    protected abstract boolean hasLimit();

    @Shadow
    @Final
    private int limit;

    @Shadow
    @Final
    private NumberProvider count;

    @Inject(method = "run", at = @At("RETURN"))
    private void archeologic_caverns$overrideLootTables(ItemStack itemStack, LootContext context, CallbackInfoReturnable<ItemStack> cir) {
        Entity entity = context.getOptionalParameter(LootContextParams.ATTACKING_ENTITY);
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getWeaponItem().getItem() instanceof CleaverItem) {
                itemStack.grow(this.count.getInt(context) * 3);
                if (hasLimit()) {
                    itemStack.limitSize(limit);
                }
            }
        }
    }


}
