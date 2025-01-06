package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MGCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreGears.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MG_TAB = CREATIVE_MOD_TABS.register("more_gears",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MGBlocks.TIN_ORE))
                    .title(Component.translatable("creativetab.moregears"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MGBlocks.TIN_ORE);
                        output.accept(MGBlocks.RUBY_ORE);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
