package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BronzePickaxe extends PickaxeItem {
    public BronzePickaxe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        boolean underwaterSpeed = stack.getOrCreateTag().getBoolean("UnderwaterSpeed");
        float originalSpeed = super.getDestroySpeed(stack, state);
        return underwaterSpeed ? originalSpeed * 3f : originalSpeed;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        if (player != null && player.isInWater()) {
            player.getMainHandItem().getOrCreateTag().putBoolean("UnderwaterSpeed", true);
        } else {
            assert player != null;
            player.getMainHandItem().getOrCreateTag().remove("UnderwaterSpeed");
        }
        return super.onBlockStartBreak(itemstack, pos, player);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
