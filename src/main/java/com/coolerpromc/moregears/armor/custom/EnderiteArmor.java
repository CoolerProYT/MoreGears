package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.armor.MGArmorItem;
import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

import java.util.function.Consumer;

public class EnderiteArmor extends MGArmorItem {
    public EnderiteArmor(EquipmentType type, String name) {
        super(MGArmorMaterials.ENDERITE_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(Integer.MAX_VALUE).component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreGears.MODID, name))));
    }

    @Override
    public void method_67187(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplayComponent arg, Consumer<Text> tooltip, TooltipType tooltipType) {
        tooltip.accept(MGTooltip.itemSpecialEffect("Indestructible"));
        tooltip.accept(MGTooltip.itemSpecialEffect("No Fall Damage"));
    }
}
