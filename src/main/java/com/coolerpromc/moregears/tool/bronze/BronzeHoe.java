package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BronzeHoe extends HoeItem {
    public BronzeHoe(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        boolean underwaterSpeed = stack.getOrDefault(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, false);
        System.out.println("Underwater Speed: " + underwaterSpeed);
        float originalSpeed = super.getDestroySpeed(stack, state);
        return underwaterSpeed ? originalSpeed * 3f : originalSpeed;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel serverLevel, Entity entity, @Nullable EquipmentSlot p_401900_) {
        if (entity instanceof Player player) {
            if (player.isInWater()) {
                player.getMainHandItem().set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
            } else {
                player.getMainHandItem().remove(DataComponents.ENCHANTMENT_GLINT_OVERRIDE);
            }
        }
        super.inventoryTick(itemStack, serverLevel, entity, p_401900_);
    }


    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        p_399884_.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
