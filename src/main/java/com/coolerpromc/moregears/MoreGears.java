package com.coolerpromc.moregears;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.datagen.property.Arrow;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.item.MGCreativeTab;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.AlloySmelterScreen;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreGears.MODID)
public class MoreGears
{
    public static final String MODID = "moregears";

    public MoreGears()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MGEntities.register(modEventBus);
        MGItems.register(modEventBus);
        MGBlocks.register(modEventBus);
        MGBlockEntities.register(modEventBus);
        MGCreativeTab.register(modEventBus);

        MGRecipes.register(modEventBus);
        MGMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        DispenserBlock.registerBehavior(MGItems.COPPER_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
        DispenserBlock.registerBehavior(MGItems.BRONZE_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
        DispenserBlock.registerBehavior(MGItems.STEEL_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
        DispenserBlock.registerBehavior(MGItems.RUBY_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
        DispenserBlock.registerBehavior(MGItems.TITANIUM_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
        DispenserBlock.registerBehavior(MGItems.ENDERITE_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123407_, Position p_123408_, ItemStack p_123409_) {
                net.minecraft.world.entity.projectile.Arrow arrow = new net.minecraft.world.entity.projectile.Arrow(p_123407_, p_123408_.x(), p_123408_.y(), p_123408_.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                MenuScreens.register(MGMenuTypes.ALLOY_SMELTER.get(), AlloySmelterScreen::new);
            });
            Arrow.addBowItemProperties();
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
