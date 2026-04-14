package com.coolerpromc.moregears;

import com.coolerpromc.moregears.datagen.property.Arrow;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.event.RegisterMenuEvent;
import com.coolerpromc.moregears.util.MGTooltip;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.recipe.v1.sync.ClientRecipeSynchronizedEvent;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeMap;

import java.util.LinkedList;

public class MoreGearsClient implements ClientModInitializer {
    public static RecipeMap recipeMap;

    @Override
    public void onInitializeClient() {
        RegisterMenuEvent.registerMenu();

        EntityRendererRegistry.register(MGEntities.COPPER_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("copper_arrow")));
        EntityRendererRegistry.register(MGEntities.BRONZE_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("bronze_arrow")));
        EntityRendererRegistry.register(MGEntities.STEEL_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("steel_arrow")));
        EntityRendererRegistry.register(MGEntities.RUBY_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("ruby_arrow")));
        EntityRendererRegistry.register(MGEntities.TITANIUM_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("titanium_arrow")));
        EntityRendererRegistry.register(MGEntities.ENDERITE_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("enderite_arrow")));

        SelectItemModelProperties.ID_MAPPER.put(Identifier.fromNamespaceAndPath(MoreGears.MODID, "select_bow"), Arrow.TYPE);

        ClientRecipeSynchronizedEvent.EVENT.register((client, recipes) -> recipeMap = RecipeMap.create(recipes.recipes()));

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
