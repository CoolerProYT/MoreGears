package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Consumer;

public class TitaniumArmor extends MGArmorItem {
    public TitaniumArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.TITANIUM_ARMOR_MATERIAL, type, properties.fireResistant().durability(type.getDurability(45)));
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.fire_resistance"));

    }
}
