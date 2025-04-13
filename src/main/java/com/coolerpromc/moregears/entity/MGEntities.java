package com.coolerpromc.moregears.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.entity.custom.MGArrowEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MGEntities {
    public static final EntityType<MGArrowEntity> COPPER_ARROW = registerArrow("copper_arrow");
    public static final EntityType<MGArrowEntity> BRONZE_ARROW = registerArrow("bronze_arrow");
    public static final EntityType<MGArrowEntity> STEEL_ARROW = registerArrow("steel_arrow");
    public static final EntityType<MGArrowEntity> RUBY_ARROW = registerArrow("ruby_arrow");
    public static final EntityType<MGArrowEntity> TITANIUM_ARROW = registerArrow("titanium_arrow");
    public static final EntityType<MGArrowEntity> ENDERITE_ARROW = registerArrow("enderite_arrow");

    public static EntityType<MGArrowEntity> registerArrow(String name) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MoreGears.MODID, name));

        return Registry.register(Registries.ENTITY_TYPE, key,
                EntityType.Builder.<MGArrowEntity>create(MGArrowEntity::new, SpawnGroup.MISC)
                        .dimensions(0.5F, 0.5F)
                        .maxTrackingRange(4)
                        .trackingTickInterval(20)
                        .build(key));
    }

    public static void init() {

    }
}
