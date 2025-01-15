package com.coolerpromc.moregears.block.custom;

import net.minecraft.block.Block;

public class MGOreBlock extends Block {
    private final int color;

    public MGOreBlock(Settings properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}