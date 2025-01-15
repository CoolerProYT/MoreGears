package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTooltip;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class EnderiteArmor extends ArmorItem {
    public EnderiteArmor(Type type) {
        super(MGArmorMaterials.ENDERITE_ARMOR_MATERIAL, type, new Settings().fireproof().maxDamage(Integer.MAX_VALUE).component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("Indestructible"));
        tooltip.add(MGTooltip.itemSpecialEffect("No Fall Damage"));
    }
}
