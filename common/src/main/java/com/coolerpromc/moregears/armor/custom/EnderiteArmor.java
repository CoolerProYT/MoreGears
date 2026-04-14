package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class EnderiteArmor extends MGArmorItem {
    public EnderiteArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.ENDERITE_ARMOR_MATERIAL, type, properties.fireResistant().durability(Integer.MAX_VALUE).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot p_401900_) {
        // 0 = boots, 1 = leggings, 2 = chestplate, 3 = helmet
        if (!level.isClientSide()){
            if (entity instanceof Player player){
                if(player.isOnFire()|| player.isInLava()){
                    player.extinguishFire();
                }
            }
        }
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.indestructible"));
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.no_fall_damage"));
    }
}
