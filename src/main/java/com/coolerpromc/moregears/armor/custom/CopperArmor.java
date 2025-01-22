package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.class_10712;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class CopperArmor extends MGArmorItem {
    public CopperArmor(EquipmentType type, String name) {
        super(MGArmorMaterials.COPPER_ARMOR_MATERIAL, type, new Settings().maxDamage(type.getMaxDamage(15)).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name))));
    }

    @Override
    public void method_67187(ItemStack itemStack, TooltipContext tooltipContext, class_10712 arg, Consumer<Text> tooltip, TooltipType tooltipType) {
        tooltip.accept(MGTooltip.itemSpecialEffect("Immune to lightning strikes when full set is worn"));
    }
}
