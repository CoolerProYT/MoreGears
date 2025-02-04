package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TitaniumArmor extends ArmorItem {
    public TitaniumArmor(Type type) {
        super(MGArmorMaterials.TITANIUM_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(type.getMaxDamage(45)));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("special_effect.moregears.fire_resistance"));
    }
}
