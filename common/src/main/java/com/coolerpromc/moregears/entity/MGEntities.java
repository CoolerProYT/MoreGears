package com.coolerpromc.moregears.entity;

import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.ItemLikeRegistryHandler;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class MGEntities {
    public static final RegistryHandler<EntityType<MGArrowEntity>> COPPER_ARROW = registerArrow("copper_arrow", () -> MGItems.COPPER_ARROW);
    public static final RegistryHandler<EntityType<MGArrowEntity>> BRONZE_ARROW = registerArrow("bronze_arrow", () -> MGItems.BRONZE_ARROW);
    public static final RegistryHandler<EntityType<MGArrowEntity>> STEEL_ARROW = registerArrow("steel_arrow", () -> MGItems.STEEL_ARROW);
    public static final RegistryHandler<EntityType<MGArrowEntity>> RUBY_ARROW = registerArrow("ruby_arrow", () -> MGItems.RUBY_ARROW);
    public static final RegistryHandler<EntityType<MGArrowEntity>> TITANIUM_ARROW = registerArrow("titanium_arrow", () -> MGItems.TITANIUM_ARROW);
    public static final RegistryHandler<EntityType<MGArrowEntity>> ENDERITE_ARROW = registerArrow("enderite_arrow", () -> MGItems.ENDERITE_ARROW);

    public static RegistryHandler<EntityType<MGArrowEntity>> registerArrow(String name, Supplier<ItemLikeRegistryHandler<MGArrowItem>> itemSupplier) {
        return Services.REGISTRY.registerEntity(name, (entityType, level) -> new MGArrowEntity(entityType, level, itemSupplier.get().get().getDefaultInstance()), MobCategory.MISC, builder -> builder.sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20));
    }

    public static void load() {
    }
}
