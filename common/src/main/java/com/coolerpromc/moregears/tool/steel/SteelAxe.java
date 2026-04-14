package com.coolerpromc.moregears.tool.steel;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class SteelAxe extends AxeItem {
    private static final Identifier modifierId = Identifier.fromNamespaceAndPath(MoreGears.MODID, "steel_axe_slow_speed");

    public SteelAxe(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
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
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.heavy"));
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.faster_attack_speed"));
    }
}
