package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;

public class RubyArmor extends ArmorItem {
    public RubyArmor(Type type) {
        super(MGArmorMaterials.RUBY_ARMOR_MATERIAL, type, new Settings().maxDamage(type.getMaxDamage(28)));
    }
}
