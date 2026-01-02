package com.coolerpromc.moregears.item.custom;

import net.minecraft.item.Item;

public class MGNugget extends Item {
    private final int color;

    public MGNugget(Settings properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}