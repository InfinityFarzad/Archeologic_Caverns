package org.architectum_workshop.archeologic_caverns.common.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import org.architectum_workshop.archeologic_caverns.common.init.ACAttachments;
import org.architectum_workshop.archeologic_caverns.common.init.ACItems;
import org.architectum_workshop.archeologic_caverns.common.util.datatype.ClimbPos;

public class AmberHookUtil {

    public static ClimbPos getCurrentHookPos(Player player, InteractionHand hand) {
        if (hand == null || player == null) {
            return null;
        }

        return hand == InteractionHand.OFF_HAND ? player.getAttached(ACAttachments.OFFHAND_HOOK_POS) : player.getAttached(ACAttachments.MAIN_HOOK_POS);
    }

    public static void storeHookPos(Player player, InteractionHand hand, ClimbPos pos) {
        player.setAttached(hand == InteractionHand.MAIN_HAND ? ACAttachments.MAIN_HOOK_POS : ACAttachments.OFFHAND_HOOK_POS, pos);
    }

    public static boolean isUsingAmberHook(Player player) {
        return player.isUsingItem() && player.getUseItem().getItem() == ACItems.AMBER_HOOK;
    }

}
