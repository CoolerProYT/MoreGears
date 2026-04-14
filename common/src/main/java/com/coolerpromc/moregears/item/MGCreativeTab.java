package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.platform.Services;
import com.coolerpromc.moregears.platform.util.RegistryHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MGCreativeTab {
    public static final RegistryHandler<CreativeModeTab> MG_TAB = Services.REGISTRY.registerCreativeTab("more_gears", () -> new ItemStack(MGBlocks.ALLOY_SMELTER), Component.translatable("creativetab.moregears"),
            (parameters) -> {
                List<ItemStack> stacks = new ArrayList<>();
                for (Field field : MGBlocks.class.getFields()) {
                    try {
                        if (Supplier.class.isAssignableFrom(field.getType())) {
                            Supplier<?> supplier = (Supplier<?>) field.get(null);
                            if (supplier.get() instanceof Block block) {
                                stacks.add(block.asItem().getDefaultInstance());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                for (Field field : MGItems.class.getFields()) {
                    try {
                        if (Supplier.class.isAssignableFrom(field.getType())) {
                            Supplier<?> supplier = (Supplier<?>) field.get(null);
                            if (supplier.get() instanceof Item item) {
                                stacks.add(item.getDefaultInstance());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return stacks.toArray(ItemStack[]::new);
            });

    public static void load() {
    }
}
