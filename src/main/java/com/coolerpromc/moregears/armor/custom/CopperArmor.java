package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class CopperArmor extends ArmorItem {
    public CopperArmor(Type type) {
        super(MGArmorMaterials.COPPER, type, new Settings());
    }

    @Override
    public void appendTooltip(ItemStack stack, World context, List<Text> tooltip, TooltipContext type) {
        tooltip.add(MGTooltip.itemSpecialEffect("Immune to lightning strikes when full set is worn"));
    }
}
