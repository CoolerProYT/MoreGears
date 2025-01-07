package com.coolerpromc.moregears.item.custom;

import net.minecraft.world.item.Item;

public class MGStick extends Item {
    private final int color;

    public MGStick(Properties properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
