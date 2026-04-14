package com.coolerpromc.moregears;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.item.MGCreativeTab;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.MGMenuTypes;

public class CommonClass {
    public static void init() {
        MGBlocks.load();
        MGBlockEntities.load();
        MGRecipes.load();
        MGItems.load();
        MGEntities.load();
        MGCreativeTab.load();
        MGMenuTypes.load();
    }
}