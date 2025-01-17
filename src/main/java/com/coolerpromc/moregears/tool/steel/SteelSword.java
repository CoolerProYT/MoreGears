package com.coolerpromc.moregears.tool.steel;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class SteelSword extends SwordItem {
    private static final UUID modifierId = UUID.fromString("123e4567-e89b-12d3-a456-426614174004");

    public SteelSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World level, Entity entity, int slotId, boolean isSelected) {
        if(!(entity instanceof PlayerEntity player)) return;

        boolean shouldSlow = player.getStackInHand(Hand.MAIN_HAND).getItem() == this || player.getStackInHand(Hand.OFF_HAND).getItem() == this;

        EntityAttributeInstance movementSpeed = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if(movementSpeed == null) return;

        EntityAttributeModifier existingModifier = movementSpeed.getModifier(modifierId);

        if(shouldSlow){
            if(existingModifier == null){
                EntityAttributeModifier speedModifier = new EntityAttributeModifier(
                        modifierId,
                        modifierId.toString(),
                        -0.02f,
                        EntityAttributeModifier.Operation.ADDITION
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(MGTooltip.itemSpecialEffect("Heavy (Walking speed is slower)"));
        tooltip.add(MGTooltip.itemSpecialEffect("Faster attack speed"));
    }
}
