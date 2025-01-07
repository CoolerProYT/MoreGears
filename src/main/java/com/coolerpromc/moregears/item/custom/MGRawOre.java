package com.coolerpromc.moregears.item.custom;

import net.minecraft.world.item.Item;

public class MGRawOre extends Item {
    private final int color;

    public MGRawOre(Properties properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
