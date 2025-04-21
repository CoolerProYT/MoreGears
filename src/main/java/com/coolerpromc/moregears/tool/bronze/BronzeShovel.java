package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class BronzeShovel extends ShovelItem {

    public BronzeShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        boolean underwaterSpeed = stack.getOrDefault(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, false);
        float originalSpeed = super.getMiningSpeed(stack, state);
        return underwaterSpeed ? originalSpeed * 3f : originalSpeed;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (player.isInsideWaterOrBubbleColumn()) {
                player.getMainHandStack().set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
            } else {
                player.getMainHandStack().remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
