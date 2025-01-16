package com.coolerpromc.moregears.tool.steel;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class SteelShovel extends ShovelItem {
    private static final Identifier modifierId = Identifier.of(MoreGears.MODID, "steel_shovel_slow_speed");

    public SteelShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World level, Entity entity, int slotId, boolean isSelected) {
        if(!(entity instanceof PlayerEntity player)) return;

        boolean shouldSlow = player.getStackInHand(Hand.MAIN_HAND).getItem() == this || player.getStackInHand(Hand.OFF_HAND).getItem() == this;

        EntityAttributeInstance movementSpeed = player.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
        if(movementSpeed == null) return;

        EntityAttributeModifier existingModifier = movementSpeed.getModifier(modifierId);

        if(shouldSlow){
            if(existingModifier == null){
                EntityAttributeModifier speedModifier = new EntityAttributeModifier(
                        modifierId,
                        -0.02f,
                        EntityAttributeModifier.Operation.ADD_VALUE
                );
                movementSpeed.addTemporaryModifier(speedModifier);
            }
        }else{
            if(existingModifier != null){
                movementSpeed.removeModifier(existingModifier);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(MGTooltip.itemSpecialEffect("Heavy (Walking speed is slower)"));
        tooltip.add(MGTooltip.itemSpecialEffect("Faster attack speed"));
    }
}
