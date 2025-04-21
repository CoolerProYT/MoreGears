package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BronzePickaxe extends PickaxeItem {
    public BronzePickaxe(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        boolean underwaterSpeed = stack.getOrDefault(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, false);
        System.out.println("Underwater Speed: " + underwaterSpeed);
        float originalSpeed = super.getDestroySpeed(stack, state);
        return underwaterSpeed ? originalSpeed * 3f : originalSpeed;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player) {
            if (player.isInWater()) {
                player.getMainHandItem().set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
            } else {
                player.getMainHandItem().remove(DataComponents.ENCHANTMENT_GLINT_OVERRIDE);
            }
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
