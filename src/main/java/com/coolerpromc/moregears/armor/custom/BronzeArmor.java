package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class BronzeArmor extends ArmorItem {
    public BronzeArmor(Type type) {
        super(MGArmorMaterials.BRONZE, type, new Settings());
    }
}
