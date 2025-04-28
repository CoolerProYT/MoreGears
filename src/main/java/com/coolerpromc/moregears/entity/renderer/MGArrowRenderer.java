package com.coolerpromc.moregears.entity.renderer;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;

public class MGArrowRenderer extends ProjectileEntityRenderer<MGArrowEntity, ProjectileEntityRenderState> {
    public final Identifier arrowTexture;

    public MGArrowRenderer(EntityRendererFactory.Context p_174399_, Identifier arrowTexture) {
        super(p_174399_);
        this.arrowTexture = arrowTexture;
    }

    @Override
    protected Identifier getTexture(ProjectileEntityRenderState p_364566_) {
        return arrowTexture;
    }

    public ProjectileEntityRenderState createRenderState() {
        return new ProjectileEntityRenderState();
    }

    public static Identifier getTextureLocation(String textureName) {
        return Identifier.of(MoreGears.MODID, "textures/entity/projectiles/" + textureName + ".png");
    }
}