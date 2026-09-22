package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EchoiteArmor extends MGArmorItem {
    private static final Map<UUID, Integer> lastSeenDarknessDuration = new ConcurrentHashMap<>();

    public EchoiteArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.ECHOITE_ARMOR_MATERIAL, type, properties.durability(type.getDurability(37)));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (slot != EquipmentSlot.HEAD) return;
        if (!(entity instanceof LivingEntity livingEntity)) return;

        MobEffectInstance darkness = livingEntity.getEffect(MobEffects.DARKNESS);
        if (darkness == null || !isFullSetWorn(livingEntity)) {
            lastSeenDarknessDuration.remove(livingEntity.getUUID());
            return;
        }

        int currentDuration = darkness.getDuration();
        Integer lastDuration = lastSeenDarknessDuration.get(livingEntity.getUUID());

        if (lastDuration == null || currentDuration > lastDuration) {
            int halvedDuration = currentDuration / 2;
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, halvedDuration, darkness.getAmplifier(), darkness.isAmbient(), darkness.isVisible()));
            lastSeenDarknessDuration.put(livingEntity.getUUID(), halvedDuration);
        } else {
            lastSeenDarknessDuration.put(livingEntity.getUUID(), currentDuration);
        }
    }

    private static boolean isFullSetWorn(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.FEET).getItem() == MGItems.ECHOITE_BOOTS.get() &&
                entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == MGItems.ECHOITE_LEGGINGS.get() &&
                entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == MGItems.ECHOITE_CHESTPLATE.get() &&
                entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == MGItems.ECHOITE_HELMET.get();
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.echo_ward"));
    }
}
