package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class EnderiteArmor extends ArmorItem {
    public EnderiteArmor(Type type) {
        super(MGArmorMaterials.ENDERITE, type, new Settings().fireproof());
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World context, List<Text> tooltip, TooltipContext type) {
        tooltip.add(MGTooltip.itemSpecialEffect("Indestructible"));
        tooltip.add(MGTooltip.itemSpecialEffect("No Fall Damage"));
    }
}
