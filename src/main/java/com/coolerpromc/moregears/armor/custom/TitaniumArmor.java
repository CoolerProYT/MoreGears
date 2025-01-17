package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class TitaniumArmor extends MGArmorItem {
    public TitaniumArmor(EquipmentType type, String name) {
        super(MGArmorMaterials.TITANIUM_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(type.getMaxDamage(45)).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name))));
    }
}
