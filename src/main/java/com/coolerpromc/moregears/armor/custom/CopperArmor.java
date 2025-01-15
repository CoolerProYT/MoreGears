package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class CopperArmor extends ArmorItem {
    public CopperArmor(Type type) {
        super(MGArmorMaterials.COPPER_ARMOR_MATERIAL, type, new Settings().maxDamage(type.getMaxDamage(15)));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("Immune to lightning strikes when full set is worn"));
    }
}
