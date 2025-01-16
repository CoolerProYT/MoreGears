package com.coolerpromc.moregears.armor.custom;

import com.coolerpromc.moregears.armor.MGArmorMaterials;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

public class SteelArmor extends ArmorItem {
    public SteelArmor(ArmorType type, Properties properties) {
        super(MGArmorMaterials.STEEL_ARMOR_MATERIAL, type, properties.durability(type.getDurability(30)));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        // 0 = boots, 1 = leggings, 2 = chestplate, 3 = helmet
        if (!level.isClientSide){
            if (entity instanceof Player player){

            }
        }
    }
}
