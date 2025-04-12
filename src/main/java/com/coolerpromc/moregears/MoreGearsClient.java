package com.coolerpromc.moregears;

import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.entity.renderer.MGArrowRenderer;
import com.coolerpromc.moregears.event.RegisterMenuEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoreGearsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegisterMenuEvent.registerMenu();

        // Register entity renderers
        EntityRendererRegistry.register(MGEntities.COPPER_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("copper_arrow")));
        EntityRendererRegistry.register(MGEntities.BRONZE_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("bronze_arrow")));
        EntityRendererRegistry.register(MGEntities.STEEL_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("steel_arrow")));
        EntityRendererRegistry.register(MGEntities.RUBY_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("ruby_arrow")));
        EntityRendererRegistry.register(MGEntities.TITANIUM_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("titanium_arrow")));
        EntityRendererRegistry.register(MGEntities.ENDERITE_ARROW, ctx -> new MGArrowRenderer(ctx, MGArrowRenderer.getTextureLocation("enderite_arrow")));
    }
}
