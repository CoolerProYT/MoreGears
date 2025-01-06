package com.coolerpromc.moregears.block.custom;

import net.minecraft.world.level.block.Block;

public class MGOreBlock extends Block {
    private final int color;

    public MGOreBlock(Properties properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
