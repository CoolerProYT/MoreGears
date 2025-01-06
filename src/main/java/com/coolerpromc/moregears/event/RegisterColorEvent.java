package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.custom.MGOreBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = MoreGears.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterColorEvent {
    @SubscribeEvent
    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Block event) {
        registerBlockColor(event,
                MGBlocks.TIN_ORE.get(),
                MGBlocks.RUBY_ORE.get()
        );
    }

    @SubscribeEvent
    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Item event) {
        registerBlockItemColor(event,
                MGBlocks.TIN_ORE.get(),
                MGBlocks.RUBY_ORE.get()
        );
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
}
