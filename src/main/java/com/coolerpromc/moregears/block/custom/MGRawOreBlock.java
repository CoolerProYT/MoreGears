package com.coolerpromc.moregears.block.custom;

import net.minecraft.world.level.block.Block;

public class MGRawOreBlock extends Block {
    private final int color;

    public MGRawOreBlock(Properties properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
