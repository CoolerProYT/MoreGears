package com.coolerpromc.moregears;

import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.event.MGCopperArmorEvent;
import com.coolerpromc.moregears.event.MGEnderiteArmorEvent;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.platform.NeoForgeRegistryHelper;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.util.Arrow;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

@Mod(MoreGears.MODID)
public class MoreGears
{
    public static final String MODID = "moregears";

    public MoreGears(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        CommonClass.init();
        NeoForgeRegistryHelper.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        DispenserBlock.registerProjectileBehavior(MGItems.COPPER_ARROW);
        DispenserBlock.registerProjectileBehavior(MGItems.BRONZE_ARROW);
        DispenserBlock.registerProjectileBehavior(MGItems.STEEL_ARROW);
        DispenserBlock.registerProjectileBehavior(MGItems.RUBY_ARROW);
        DispenserBlock.registerProjectileBehavior(MGItems.TITANIUM_ARROW);
        DispenserBlock.registerProjectileBehavior(MGItems.ENDERITE_ARROW);
    }

    @SubscribeEvent
    public void onOnDatapackSync(OnDatapackSyncEvent event) {
        event.sendRecipes(MGRecipes.ALLOY_SMELTING_TYPE.get());
    }

    @SubscribeEvent
    public void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        if (!MGCopperArmorEvent.preventLightningBolt(event.getEntity(), event.getEntity().damageSources().lightningBolt())){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event) {
        if (!MGEnderiteArmorEvent.onPlayerHurt(event.getEntity(), event.getEntity().level().damageSources().fall())){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent.Pre event) {
        if (!MGEnderiteArmorEvent.onPlayerHurt(event.getEntity(), event.getSource())){
            event.setNewDamage(0);
        }
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(MGEntities.COPPER_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("copper_arrow")));
            event.registerEntityRenderer(MGEntities.BRONZE_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("bronze_arrow")));
            event.registerEntityRenderer(MGEntities.STEEL_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("steel_arrow")));
            event.registerEntityRenderer(MGEntities.RUBY_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("ruby_arrow")));
            event.registerEntityRenderer(MGEntities.TITANIUM_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("titanium_arrow")));
            event.registerEntityRenderer(MGEntities.ENDERITE_ARROW.get(), context -> new MGArrowRenderer(context, MGArrowRenderer.getTextureLocation("enderite_arrow")));
        }

        @SubscribeEvent
        public static void onRegisterSelectItemModelProperty(RegisterSelectItemModelPropertyEvent event) {
            event.register(Constants.id("select_bow"), Arrow.TYPE);
        }
    }
}