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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@EventBusSubscriber(modid = MoreGears.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterColorEvent {
    @SubscribeEvent
    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Block event) {
        registerBlockColor(event, getBlocks());
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
