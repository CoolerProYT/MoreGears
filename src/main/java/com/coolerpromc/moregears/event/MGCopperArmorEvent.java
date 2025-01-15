package com.coolerpromc.moregears.event;

import com.coolerpromc.moregears.item.MGItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Objects;

public class MGCopperArmorEvent {
    public static void preventLightningBolt() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof PlayerEntity player){
                assert MinecraftClient.getInstance().world != null;
                if ((Objects.equals(damageSource.getType(), MinecraftClient.getInstance().world.getDamageSources().lightningBolt().getType()))){
                    return !isCopperArmor(player);
                }
            }
            return true;
        });
    }

    private static boolean isCopperArmor(PlayerEntity player){
        List<ItemStack> armor = player.getInventory().armor;
        return armor.get(0).getItem() == MGItems.COPPER_BOOTS &&
                armor.get(1).getItem() == MGItems.COPPER_LEGGINGS &&
                armor.get(2).getItem() == MGItems.COPPER_CHESTPLATE &&
                armor.get(3).getItem() == MGItems.COPPER_HELMET;
    }
}
