package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BronzeShovel extends ShovelItem {
    public BronzeShovel(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
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
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        MGTooltip.itemSpecialEffect("Faster mining under water");
    }
}
