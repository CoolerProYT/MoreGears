package com.coolerpromc.moregears.mixin;

import com.coolerpromc.moregears.Constants;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin extends Player {
    public AbstractClientPlayerMixin(Level world, GameProfile gameProfile) {
        super(world, gameProfile);
    }

    @Inject(method = "getFieldOfViewModifier", at = @At(value = "TAIL"), cancellable = true)
    private void getFovMultiplierMixin(boolean firstPerson, float effectScale, CallbackInfoReturnable<Float> cir) {
        AbstractClientPlayer self = (AbstractClientPlayer)(Object)this;
        Item item = self.getActiveItem().getItem();
        ItemStack itemStack = self.getActiveItem();
        if (this.isUsingItem() && item instanceof BowItem bowItem && item.builtInRegistryHolder().key().identifier().getNamespace().equals(Constants.MODID)) {
            int i = bowItem.getUseDuration(itemStack, this) - self.getUseItemRemainingTicks();
            float g = (float)i / 20.0f;
            g = g > 1.0f ? 1.0f : g * g;
            effectScale *= 1.0f - g * 0.15f;
            cir.setReturnValue(Mth.lerp(Minecraft.getInstance().options.fovEffectScale().get().floatValue(), 1.0f, effectScale));
        }
    }
}