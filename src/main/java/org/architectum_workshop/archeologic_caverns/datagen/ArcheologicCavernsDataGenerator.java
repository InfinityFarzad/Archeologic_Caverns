package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ArcheologicCavernsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ArcheologicCavernsModelProvider::new);
		pack.addProvider(ArcheologicCavernsBlockTagProvider::new);
		pack.addProvider(ArcheologicCavernsRecipeGenerator::new);
		pack.addProvider(ArcheologicCavernsBlockLootTableProvider::new);
		pack.addProvider(ArcheologicCavernsItemTagProvider::new);
	}
}
