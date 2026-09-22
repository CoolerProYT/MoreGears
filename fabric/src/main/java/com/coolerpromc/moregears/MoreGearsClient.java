package com.coolerpromc.moregears;

import com.coolerpromc.moregears.util.Arrow;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.entity.renderer.MGThrownTridentRenderer;
import com.coolerpromc.moregears.item.special.MGShieldSpecialRenderer;
import com.coolerpromc.moregears.item.special.MGTridentSpecialRenderer;
import com.coolerpromc.moregears.event.RegisterMenuEvent;
import com.coolerpromc.moregears.util.MGTooltip;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.recipe.v1.sync.ClientRecipeSynchronizedEvent;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.recipe.sync.SynchronizedRecipesImpl;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperties;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeMap;

import java.util.LinkedList;

public class MoreGearsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegisterMenuEvent.registerMenu();

        EntityRendererRegistry.register(MGEntities.COPPER_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("copper_arrow")));
        EntityRendererRegistry.register(MGEntities.BRONZE_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("bronze_arrow")));
        EntityRendererRegistry.register(MGEntities.STEEL_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("steel_arrow")));
        EntityRendererRegistry.register(MGEntities.RUBY_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("ruby_arrow")));
        EntityRendererRegistry.register(MGEntities.TITANIUM_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("titanium_arrow")));
        EntityRendererRegistry.register(MGEntities.ENDERITE_ARROW.get(), ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("enderite_arrow")));

        EntityRendererRegistry.register(MGEntities.ENDERITE_TRIDENT.get(), ctx -> new MGThrownTridentRenderer(ctx, MGThrownTridentRenderer.getTextureLocation("enderite_trident")));

        SelectItemModelProperties.ID_MAPPER.put(Constants.id("select_bow"), Arrow.TYPE);

        SpecialModelRenderers.ID_MAPPER.put(MGShieldSpecialRenderer.TYPE_ID, MGShieldSpecialRenderer.Unbaked.MAP_CODEC);
        SpecialModelRenderers.ID_MAPPER.put(MGTridentSpecialRenderer.TYPE_ID, MGTridentSpecialRenderer.Unbaked.MAP_CODEC);

        ClientRecipeSynchronizedEvent.EVENT.register((client, recipes) -> {
            SynchronizedRecipesImpl impl = (SynchronizedRecipesImpl) recipes;
            CommonClientClass.recipeMap = new RecipeMap(impl.byType(), impl.byKey());
        });

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.is(Items.COPPER_HELMET) || itemStack.is(Items.COPPER_CHESTPLATE) || itemStack.is(Items.COPPER_LEGGINGS) || itemStack.is(Items.COPPER_BOOTS)) {
                LinkedList<Component> tooltips = new LinkedList<>(list);
                tooltips.add(1, MGTooltip.itemSpecialEffect("special_effect.moregears.copper_armor"));
                list.clear();
                list.addAll(tooltips);
            }
        });
    }
}
