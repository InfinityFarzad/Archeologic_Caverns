package org.architectum_workshop.archeologic_caverns.common;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsBlocks;
import org.architectum_workshop.archeologic_caverns.common.init.ArcheologicCavernsCreativeTabs;
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

	}


}
