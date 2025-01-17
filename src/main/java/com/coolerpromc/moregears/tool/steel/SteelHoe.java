package com.coolerpromc.moregears.tool.steel;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.UUID;

public class SteelHoe extends HoeItem {
    private static final UUID modifierId = UUID.fromString("123e4567-e89b-12d3-a456-426614174001");

    public SteelHoe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(!(entity instanceof Player player)) return;

        boolean shouldSlow = player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == this || player.getItemInHand(InteractionHand.OFF_HAND).getItem() == this;

        AttributeInstance movementSpeed = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if(movementSpeed == null) return;

        AttributeModifier existingModifier = movementSpeed.getModifier(modifierId);

        if(shouldSlow){
            if(existingModifier == null){
                AttributeModifier speedModifier = new AttributeModifier(
                        modifierId,
                        modifierId.toString(),
                        -0.02f,
                        AttributeModifier.Operation.ADDITION
                );
                movementSpeed.addTransientModifier(speedModifier);
            }
        }else{
            if(existingModifier != null){
                movementSpeed.removeModifier(existingModifier);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(MGTooltip.itemSpecialEffect("Heavy (Walking speed is slower)"));
        tooltipComponents.add(MGTooltip.itemSpecialEffect("Faster attack speed"));
    }
}
