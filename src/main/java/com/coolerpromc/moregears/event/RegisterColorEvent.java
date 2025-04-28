package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGIngot;
import com.coolerpromc.moregears.item.custom.MGRawOre;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MoreGears.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterColorEvent {
    @SubscribeEvent
    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Block event) {
        registerBlockColor(event, getBlocks());
    }

    @SubscribeEvent
    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Item event) {
        registerBlockItemColor(event, getBlocks());
    }

    private static void registerBlockColor(RegisterColorHandlersEvent.Block event, Block... blocks) {
        event.register((blockState, blockAndTintGetter, blockPos, i) -> {
            if (blockState.getBlock() instanceof MGOreBlock mgOreBlock) {
                if (i == 1) {
                    return mgOreBlock.getColor();
                }
            }
            return -1;
        }, blocks);
    }

    private static void registerBlockItemColor(RegisterColorHandlersEvent.Item event, Block... blocks) {
        event.register((itemStack, i) -> {
            if (itemStack.getItem() instanceof BlockItem blockItem) {
                if (blockItem.getBlock() instanceof MGOreBlock mgOreBlock) {
                    if (i == 1) {
                        return mgOreBlock.getColor();
                    }
                }
            }
            return -1;
        }, blocks);
    }

    private static Block[] getBlocks(){
        var blocks = new ArrayList<Block>();

        for (Field field : MGBlocks.class.getFields()){
            try{
                if (Supplier.class.isAssignableFrom(field.getType())){
                    Supplier<?> supplier = (Supplier<?>) field.get(null);
                    if (supplier.get() instanceof MGOreBlock block){
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
}
