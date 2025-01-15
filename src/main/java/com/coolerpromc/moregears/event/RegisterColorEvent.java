package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class RegisterColorEvent {
    public static void registerColor() {
        registerRawOreColor(getRawOres());
        registerIngotColor(getIngots());
    }

    private static void registerRawOreColor(Item... items) {
        ColorProviderRegistry.ITEM.register((itemStack, i) -> {
            if (itemStack.getItem() instanceof MGRawOre mgRawOre) {
                return mgRawOre.getColor();
            }
            return -1;
        }, items);
    }

    private static void registerIngotColor(Item... items) {
        ColorProviderRegistry.ITEM.register((itemStack, i) -> {
            if (itemStack.getItem() instanceof MGIngot mgIngot) {
                return mgIngot.getColor();
            }
            return -1;
        }, items);
    }

    private static Block[] getBlocks(){
        var blocks = new ArrayList<Block>();

        for (Field field : MGBlocks.class.getFields()){
            try{
                if (Block.class.isAssignableFrom(field.getType())){
                    Block block = (Block) field.get(null);
                    if (block instanceof MGOreBlock) {
                        blocks.add(block);
                    }
                }
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }

        return blocks.toArray(new Block[0]);
    }

    private static Item[] getRawOres(){
        var items = new ArrayList<Item>();

        for (Field field : MGItems.class.getFields()){
            try{
                if (Item.class.isAssignableFrom(field.getType())){
                    Item item = (Item) field.get(null);
                    if (item instanceof MGRawOre){
                        items.add(item);
                    }
                }
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }

        return items.toArray(new Item[0]);
    }

    private static Item[] getIngots(){
        var items = new ArrayList<Item>();

        for (Field field : MGItems.class.getFields()){
            try{
                if (Item.class.isAssignableFrom(field.getType())){
                    Item item = (Item) field.get(null);
                    if (item instanceof MGIngot) {
                        items.add(item);
                    }
                }
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }

        return items.toArray(new Item[0]);
    }
}
