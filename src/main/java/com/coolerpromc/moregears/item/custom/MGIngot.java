package com.coolerpromc.moregears.item.custom;

import net.minecraft.item.Item;

public class MGIngot extends Item {
    private final int color;

    public MGIngot(Settings properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}