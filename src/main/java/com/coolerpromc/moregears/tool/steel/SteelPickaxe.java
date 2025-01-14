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

public class SteelPickaxe extends PickaxeItem {
    private static final ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "steel_pickaxe_slow_speed");
    public SteelPickaxe(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
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
                        -0.02f,
                        AttributeModifier.Operation.ADD_VALUE
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
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        MGTooltip.itemSpecialEffect("Heavy (Walking speed is slower)");
        MGTooltip.itemSpecialEffect("Faster attack speed");
    }
}
