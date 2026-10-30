package org.architectum_workshop.archeologic_caverns.common;

import net.akws.chiseled_lib.common.system.timer.TimerTimeoutEvent;
import net.akws.chiseled_lib.common.util.TimerUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.architectum_workshop.archeologic_caverns.client.init.ACParticles;
import org.architectum_workshop.archeologic_caverns.common.init.*;
import org.architectum_workshop.archeologic_caverns.common.item.CleaverItem;
import org.architectum_workshop.archeologic_caverns.common.util.CleaverUtil;
import org.architectum_workshop.archeologic_caverns.common.worldgen.CaveRegions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

import java.util.List;
import java.util.UUID;

public class ArcheologicCaverns implements ModInitializer {
    public static final String MOD_ID = "archeologic_caverns";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    //public static final List<UUID> uuids = List.of(UUID.fromString("74942ff65f8d4492b723dc82755e3440"), UUID.fromString(""), UUID.fromString(""), UUID.fromString(""), UUID.fromString(""), UUID.fromString(""));


    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ACBlocks.init();
        ACCreativeTabs.init();
        ACItems.init();
        ACTags.init();
        ACFeatures.init();
        ACComponents.init();
        ACAttachments.init();
        ACSounds.init();
        ACToolMaterials.init();
        ACBiomes.init();
        ACParticles.init();

        TimerTimeoutEvent.EVENT.register((player, id) -> {
            if (id.equals(CleaverItem.PLAYER_COMBO_ID)) {
                int currentCombo = player.getAttachedOrSet(ACAttachments.PLAYER_COMBO_COUNTER, 0);
                if (!player.level().isClientSide() && currentCombo > 0) {
                    TimerUtil.addTimerToPlayer(player, CleaverItem.PLAYER_COMBO_ID, Math.clamp(80 * CleaverUtil.offsetCalculateModifier(15, currentCombo), 8, 80));
                    player.modifyAttached(ACAttachments.PLAYER_COMBO_COUNTER, (o) -> Math.max(o - 1, 0));
                }
            }
        });
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(BiomeTags.IS_OCEAN)),
                GenerationStep.Decoration.RAW_GENERATION,
                ACPlacedFeatures.SALT_PLACED_FEATURE);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld().and(BiomeSelectors.includeByKey(ACBiomes.AMBER_CAVES)),
                GenerationStep.Decoration.RAW_GENERATION,
                ACPlacedFeatures.AMBER_COLUMN_PLACED_FEATURE
        );


        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> ResourceLoader.registerBuiltinPack(id("copper_reforged"), modContainer, Component.literal("Copper Reforged"), PackActivationType.DEFAULT_ENABLED));
    }

}
