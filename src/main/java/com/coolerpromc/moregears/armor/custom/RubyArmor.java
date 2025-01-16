package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class RubyArmor extends MGArmorItem {
    public RubyArmor(EquipmentType type, String name) {
        super(MGArmorMaterials.RUBY_ARMOR_MATERIAL, type, new Settings().maxDamage(type.getMaxDamage(28)).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name))));
    }
}
