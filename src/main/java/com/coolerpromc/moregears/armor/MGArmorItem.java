package com.coolerpromc.moregears.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class MGArmorItem extends ArmorItem {
    private final ArmorType armorType;

    public MGArmorItem(ArmorMaterial material, ArmorType armorType, Properties properties) {
        super(material, armorType, properties);
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
