package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BronzePickaxe extends PickaxeItem {
    public BronzePickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        float originalSpeed = super.getMiningSpeedMultiplier(stack, state);

        PlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null && player.isInsideWaterOrBubbleColumn()){
            return originalSpeed * 2f;
        }

        return originalSpeed;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(MGTooltip.itemSpecialEffect("Faster mining under water"));
    }
}
