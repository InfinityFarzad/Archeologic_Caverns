package org.architectum_workshop.archeologic_caverns.client.render.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.architectum_workshop.archeologic_caverns.common.init.ACComponents;
import org.jspecify.annotations.Nullable;

@Environment(value= EnvType.CLIENT)
public record AmethystGreataxeModelProperty() implements RangeSelectItemModelProperty
{
    public static final MapCodec<AmethystGreataxeModelProperty> MAP_CODEC = MapCodec.unit(AmethystGreataxeModelProperty::new);

    @Override
    public float get(ItemStack itemStack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
        float stage = itemStack.getOrDefault(ACComponents.GREATAXE_SHATTERED, 0.f);
        return Mth.floor(Mth.clamp(stage / 10, 0, 4));
    }

    public MapCodec<AmethystGreataxeModelProperty> type() {
        return MAP_CODEC;
    }
}

