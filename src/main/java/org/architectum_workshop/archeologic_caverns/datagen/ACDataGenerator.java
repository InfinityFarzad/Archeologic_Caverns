package org.architectum_workshop.archeologic_caverns.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.architectum_workshop.archeologic_caverns.common.init.ACDamageTypes;

public class ACDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ACModelProvider::new);
		pack.addProvider(ACBlockTagProvider::new);
		pack.addProvider(ACRecipeGenerator::new);
		pack.addProvider(ACBlockLootTableProvider::new);
		pack.addProvider(ACItemTagProvider::new);

		pack.addProvider(ACDynamicRegistries::new);
		pack.addProvider(ACLanguageProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.DAMAGE_TYPE, ACDamageTypes::bootstrap);
	}
}
