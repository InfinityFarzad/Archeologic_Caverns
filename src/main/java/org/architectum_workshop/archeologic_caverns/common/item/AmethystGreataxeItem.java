package org.architectum_workshop.archeologic_caverns.common.item;

import net.akws.chiseled_lib.common.interfaces.item.CustomAttackItem;
import net.akws.chiseled_lib.common.interfaces.item.CustomEffectsItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsTags;

public class AmethystGreataxeItem extends AxeItem implements CustomEffectsItem, CustomAttackItem {
    public AmethystGreataxeItem(Properties properties, float attackDamage, float attackSpeed) {
        super(new ToolMaterial(BlockTags.INCORRECT_FOR_COPPER_TOOL, 520,1561, 0.0f, 15, ArcheologicCavernsTags.Items.AMETHYST_TOOL_REPAIRABLE), attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean canDoSweepingAttack(ItemStack stack, boolean cooldownPassed, boolean criticalHit, boolean knockbackAttack) {
        return true;
    }
}
