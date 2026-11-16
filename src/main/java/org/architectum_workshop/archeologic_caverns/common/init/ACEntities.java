package org.architectum_workshop.archeologic_caverns.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.architectum_workshop.archeologic_caverns.common.ArcheologicCaverns;
import org.architectum_workshop.archeologic_caverns.common.entity.AxeShardEntity;

public interface ACEntities {

    EntityType<AxeShardEntity> AXE_SHARD = register(
            "axe_shard",
            EntityType.Builder.<AxeShardEntity>of(AxeShardEntity::new, MobCategory.MISC)
                    .sized(0.75f, 0.75f)
    );

    static  <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, ArcheologicCaverns.id(name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    static void buildAttributes() {

    }

    static void init() {}
}
