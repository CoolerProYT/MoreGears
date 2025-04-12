package com.coolerpromc.moregears;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.item.MGCreativeTab;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(MoreGears.MODID)
public class MoreGears
{
    public static final String MODID = "moregears";

    public MoreGears(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        MGEntities.register(modEventBus);
        MGItems.register(modEventBus);
        MGBlocks.register(modEventBus);
        MGBlockEntities.register(modEventBus);
        MGCreativeTab.register(modEventBus);

        MGRecipes.register(modEventBus);
        MGMenuTypes.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }

        @SubscribeEvent
        public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(MGEntities.COPPER_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("copper_arrow")));
            event.registerEntityRenderer(MGEntities.BRONZE_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("bronze_arrow")));
            event.registerEntityRenderer(MGEntities.STEEL_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("steel_arrow")));
            event.registerEntityRenderer(MGEntities.RUBY_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("ruby_arrow")));
            event.registerEntityRenderer(MGEntities.TITANIUM_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("titanium_arrow")));
            event.registerEntityRenderer(MGEntities.ENDERITE_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("enderite_arrow")));
        }
    }
}
