package com.coolerpromc.moregears.item.custom;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

import java.util.List;

public class MGMaceItem extends MaceItem {
    public MGMaceItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial toolMaterial, float speed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, toolMaterial.attackDamageBonus() * 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, speed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public static Tool createToolProperties(ToolMaterial toolMaterial) {
        return new Tool(List.of(), toolMaterial.speed(), 2, false);
    }
}
