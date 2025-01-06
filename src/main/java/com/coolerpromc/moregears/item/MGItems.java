package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreGears.MODID);

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item){
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
