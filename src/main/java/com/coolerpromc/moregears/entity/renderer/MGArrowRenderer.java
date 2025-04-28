package com.coolerpromc.moregears.entity.renderer;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.custom.MGArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class MGArrowRenderer extends ArrowRenderer<MGArrowEntity> {
    public final ResourceLocation arrowTexture;

    public MGArrowRenderer(EntityRendererProvider.Context p_174399_, ResourceLocation arrowTexture) {
        super(p_174399_);
        this.arrowTexture = arrowTexture;
    }

    public static ResourceLocation getTextureLocation(String textureName) {
        return ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "textures/entity/projectiles/" + textureName + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(MGArrowEntity mgArrowEntity) {
        return arrowTexture;
    }
}