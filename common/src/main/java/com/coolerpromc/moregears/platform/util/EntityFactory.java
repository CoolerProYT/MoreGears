package com.coolerpromc.moregears.platform.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

@FunctionalInterface
    public interface EntityFactory<T extends Entity> {
        @Nullable T create(EntityType<T> type, Level level);
    }