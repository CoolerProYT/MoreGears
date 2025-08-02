package com.coolerpromc.moregears.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class MGEntities {
    public static final EntityType<MGArrowEntity> COPPER_ARROW = registerArrow("copper_arrow", () -> MGItems.COPPER_ARROW);
    public static final EntityType<MGArrowEntity> BRONZE_ARROW = registerArrow("bronze_arrow", () -> MGItems.BRONZE_ARROW);
    public static final EntityType<MGArrowEntity> STEEL_ARROW = registerArrow("steel_arrow", () -> MGItems.STEEL_ARROW);
    public static final EntityType<MGArrowEntity> RUBY_ARROW = registerArrow("ruby_arrow", () -> MGItems.RUBY_ARROW);
    public static final EntityType<MGArrowEntity> TITANIUM_ARROW = registerArrow("titanium_arrow", () -> MGItems.TITANIUM_ARROW);
    public static final EntityType<MGArrowEntity> ENDERITE_ARROW = registerArrow("enderite_arrow", () -> MGItems.ENDERITE_ARROW);

    public static EntityType<MGArrowEntity> registerArrow(String name, Supplier<Item> item) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MoreGears.MODID, name));

        return Registry.register(Registries.ENTITY_TYPE, key,
                EntityType.Builder.<MGArrowEntity>create((type, world) -> new MGArrowEntity(type, world, item.get().getDefaultStack()), SpawnGroup.MISC)
                        .dimensions(0.5F, 0.5F)
                        .maxTrackingRange(4)
                        .trackingTickInterval(20)
                        .build(name));
    }

    public static void init() {

    }
}