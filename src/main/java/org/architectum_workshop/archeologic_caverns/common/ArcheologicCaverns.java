package org.architectum_workshop.archeologic_caverns.common;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsCreativeTabs;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsItems;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsTags;
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
		ArcheologicCavernsBlocks.init();
		ArcheologicCavernsCreativeTabs.init();
		ArcheologicCavernsItems.init();
		ArcheologicCavernsTags.init();

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> ResourceLoader.registerBuiltinPack(id("copper_reforged"), modContainer, Component.literal("Copper Reforged"), PackActivationType.DEFAULT_ENABLED));
	}
}
