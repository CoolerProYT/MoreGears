package com.coolerpromc.moregears.entity.renderer;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class MGArrowRenderer extends ArrowRenderer<MGArrowEntity, ArrowRenderState> {
    public final Identifier arrowTexture;

    public MGArrowRenderer(EntityRendererProvider.Context p_174399_, Identifier arrowTexture) {
        super(p_174399_);
        this.arrowTexture = arrowTexture;
    }

    protected Identifier getTextureLocation(ArrowRenderState p_364566_) {
        return arrowTexture;
    }

    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }

    public static Identifier getTextureLocation(String textureName) {
        return Identifier.fromNamespaceAndPath(MoreGears.MODID, "textures/entity/projectiles/" + textureName + ".png");
    }
}
