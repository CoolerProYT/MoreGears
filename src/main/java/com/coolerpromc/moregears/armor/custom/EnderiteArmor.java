package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class EnderiteArmor extends ArmorItem {
    public EnderiteArmor(Type type) {
        super(MGArmorMaterials.ENDERITE_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(Integer.MAX_VALUE).component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("special_effect.moregears.indestructible"));
        tooltip.add(MGTooltip.itemSpecialEffect("special_effect.moregears.no_fall_damage"));
    }
}
