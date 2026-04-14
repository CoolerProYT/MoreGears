package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

public class SteelArmor extends MGArmorItem {
    public SteelArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.STEEL_ARMOR_MATERIAL, type, properties.durability(type.getDurability(30)));
    }
}
