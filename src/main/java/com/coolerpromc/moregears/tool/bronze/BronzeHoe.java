package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BronzeHoe extends HoeItem {
    public BronzeHoe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float originalSpeed = super.getDestroySpeed(stack, state);

        Player player = Minecraft.getInstance().player;
        if(player != null && player.isInWater()){
            return originalSpeed * 2f;
        }

        return originalSpeed;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(MGTooltip.itemSpecialEffect("Faster mining under water"));
    }
}
