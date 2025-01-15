package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;

public class SteelArmor extends ArmorItem {
    public SteelArmor(Type type) {
        super(MGArmorMaterials.STEEL_ARMOR_MATERIAL, type, new Settings().maxDamage(type.getMaxDamage(30)));
    }
}
