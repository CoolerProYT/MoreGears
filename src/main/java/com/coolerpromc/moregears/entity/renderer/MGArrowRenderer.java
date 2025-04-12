package com.coolerpromc.moregears.entity.renderer;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.entity.custom.MGArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.util.Identifier;

public class MGArrowRenderer extends ProjectileEntityRenderer<MGArrowEntity, ArrowEntityRenderState> {
    public final Identifier arrowTexture;

    public MGArrowRenderer(EntityRendererFactory.Context context, Identifier arrowTexture) {
        super(context);
        this.arrowTexture = arrowTexture;
    }

    @Override
    public ArrowEntityRenderState createRenderState() {
        return new ArrowEntityRenderState();
    }

    @Override
    protected Identifier getTexture(ArrowEntityRenderState state) {
        return arrowTexture;
    }

    public static Identifier getTextureLocation(String textureName) {
        return Identifier.of(MoreGears.MODID, "textures/entity/projectiles/" + textureName + ".png");
    }
}
