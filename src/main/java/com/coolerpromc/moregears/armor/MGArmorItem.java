package com.coolerpromc.moregears.armor;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

public class MGArmorItem extends Item {
    private final EquipmentType type;

    public MGArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(settings.armor(material, type));
        this.type = type;
    }

    public EquipmentType getType() {
        return type;
    }
}
