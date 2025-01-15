package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class BronzeHoe extends HoeItem {
    public BronzeHoe(ToolMaterial p_42961_, Item.Settings p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        float originalSpeed = super.getMiningSpeed(stack, state);

        PlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null && player.isInsideWaterOrBubbleColumn()){
            return originalSpeed * 2f;
        }

        return originalSpeed;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MGTooltip.itemSpecialEffect("Faster mining under water"));
    }
}
