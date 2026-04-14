package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

public class BronzeArmor extends MGArmorItem {
    public BronzeArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.BRONZE_ARMOR_MATERIAL, type, properties.durability(type.getDurability(22)));
    }
}
