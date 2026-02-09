package com.coolerpromc.moregears.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.MaceItem;
import net.minecraft.item.ToolMaterial;

import java.util.List;

public class MGMaceItem extends MaceItem {
    public MGMaceItem(Settings properties) {
        super(properties.maxCount(1));
    }

    public static AttributeModifiersComponent createAttributes(ToolMaterial toolMaterial, float speed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, toolMaterial.attackDamageBonus() * 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, speed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public static ToolComponent createToolProperties(ToolMaterial toolMaterial) {
        return new ToolComponent(List.of(), toolMaterial.speed(), 2, false);
    }
}
