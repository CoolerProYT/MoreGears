package com.coolerpromc.moregears.entity;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MGEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(MoreGears.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<MGArrowEntity>> ENDERITE_ARROW = ENTITIES.register("enderite_arrow", () -> EntityType.Builder.<MGArrowEntity>of(MGArrowEntity::new, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "enderite_arrow"))));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
