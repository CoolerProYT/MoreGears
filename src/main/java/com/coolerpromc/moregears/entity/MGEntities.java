package com.coolerpromc.moregears.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MGEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(MoreGears.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> COPPER_ARROW = registerArrow("copper_arrow", MGItems.COPPER_ARROW);
    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> BRONZE_ARROW = registerArrow("bronze_arrow", MGItems.BRONZE_ARROW);
    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> STEEL_ARROW = registerArrow("steel_arrow", MGItems.STEEL_ARROW);
    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> RUBY_ARROW = registerArrow("ruby_arrow", MGItems.RUBY_ARROW);
    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> TITANIUM_ARROW = registerArrow("titanium_arrow", MGItems.TITANIUM_ARROW);
    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> ENDERITE_ARROW = registerArrow("enderite_arrow", MGItems.ENDERITE_ARROW);

    public static DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> registerArrow(String name, DeferredItem<MGArrowItem> item) {
        return ENTITIES.registerEntityType(name, (entityType, level) -> new MGArrowEntity(entityType, level, item.toStack(1)), MobCategory.MISC, builder -> builder.sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20));
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
