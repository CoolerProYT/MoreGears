package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Field;
import java.util.function.Supplier;

public class MGCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreGears.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MG_TAB = CREATIVE_MOD_TABS.register("more_gears",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MGBlocks.ALLOY_SMELTER))
                    .title(Component.translatable("creativetab.moregears"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (Field field : MGBlocks.class.getFields()){
                            try{
                                if (Supplier.class.isAssignableFrom(field.getType())){
                                    Supplier<?> supplier = (Supplier<?>) field.get(null);
                                    if (supplier.get() instanceof Block block){
                                        output.accept(block);
                                    }
                                }
                            }
                            catch (IllegalAccessException e){
                                e.printStackTrace();
                            }
                        }

                        for (Field field : MGItems.class.getFields()){
                            try{
                                if (Supplier.class.isAssignableFrom(field.getType())){
                                    Supplier<?> supplier = (Supplier<?>) field.get(null);
                                    if (supplier.get() instanceof Item item){
                                        output.accept(item);
                                    }
                                }
                            }
                            catch (IllegalAccessException e){
                                e.printStackTrace();
                            }
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
