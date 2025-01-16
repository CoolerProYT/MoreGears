package com.coolerpromc.moregears.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

public class MGArmorItem extends ArmorItem {
    private final EquipmentType type;

    public MGArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
        this.type = type;
    }

    public EquipmentType getType() {
        return type;
    }
}
