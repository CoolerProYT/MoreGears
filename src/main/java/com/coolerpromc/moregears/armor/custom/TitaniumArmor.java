package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;

public class TitaniumArmor extends ArmorItem {
    public TitaniumArmor(Type type) {
        super(MGArmorMaterials.TITANIUM_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(type.getMaxDamage(45)));
    }
}
