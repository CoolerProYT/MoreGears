package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class BronzePickaxe extends Item {

    public BronzePickaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        float originalSpeed = super.getMiningSpeed(stack, state);

        PlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null && player.isTouchingWater()){
            return originalSpeed * 2f;
        }

        return originalSpeed;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
