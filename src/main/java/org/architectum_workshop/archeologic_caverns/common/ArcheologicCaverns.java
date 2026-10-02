package org.architectum_workshop.archeologic_caverns.common;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.architectum_workshop.archeologic_caverns.common.init.*;
import org.architectum_workshop.archeologic_caverns.common.worldgen.feature.SaltClusterFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcheologicCaverns implements ModInitializer {
	public static final String MOD_ID = "archeologic_caverns";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
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

		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(BiomeTags.IS_OCEAN)),
				GenerationStep.Decoration.RAW_GENERATION,
				ACPlacedFeatures.SALT_PLACED_FEATURE);


		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> ResourceLoader.registerBuiltinPack(id("copper_reforged"), modContainer, Component.literal("Copper Reforged"), PackActivationType.DEFAULT_ENABLED));
	}
}
