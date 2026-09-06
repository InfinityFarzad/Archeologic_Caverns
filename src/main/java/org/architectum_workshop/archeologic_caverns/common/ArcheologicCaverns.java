package org.architectum_workshop.archeologic_caverns.common;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import org.architectum_workshop.archeologic_caverns.common.init.ACBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ACCreativeTabs;
import org.architectum_workshop.archeologic_caverns.common.init.ACItems;
import org.architectum_workshop.archeologic_caverns.common.init.ACTags;
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

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> ResourceLoader.registerBuiltinPack(id("copper_reforged"), modContainer, Component.literal("Copper Reforged"), PackActivationType.DEFAULT_ENABLED));
	}
}
