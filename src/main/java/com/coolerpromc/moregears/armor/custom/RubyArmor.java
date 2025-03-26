package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

public class RubyArmor extends MGArmorItem {
    public RubyArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.RUBY_ARMOR_MATERIAL, type, properties.durability(type.getDurability(28)));
    }
}
