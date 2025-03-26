package com.coolerpromc.moregears.armor;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class MGArmorItem extends Item {
    private final ArmorType armorType;

    public MGArmorItem(ArmorMaterial material, ArmorType armorType, Properties properties) {
        super(properties.humanoidArmor(material, armorType));
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
