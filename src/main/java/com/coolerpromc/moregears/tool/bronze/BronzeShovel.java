package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class BronzeShovel extends ShovelItem {
    public BronzeShovel(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
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
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
