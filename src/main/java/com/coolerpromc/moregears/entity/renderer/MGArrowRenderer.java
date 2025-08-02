package com.coolerpromc.moregears.entity.renderer;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class MGArrowRenderer extends ProjectileEntityRenderer<MGArrowEntity> {
    public final Identifier arrowTexture;

    public MGArrowRenderer(EntityRendererFactory.Context p_174399_, Identifier arrowTexture) {
        super(p_174399_);
        this.arrowTexture = arrowTexture;
    }

    public static Identifier getTextureLocation(String textureName) {
        return Identifier.of(MoreGears.MODID, "textures/entity/projectiles/" + textureName + ".png");
    }

    @Override
    public Identifier getTexture(MGArrowEntity entity) {
        return arrowTexture;
    }
}