package com.coolerpromc.moregears.tool.bronze;

import com.coolerpromc.moregears.util.MGTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BronzePickaxe extends Item {

    public BronzePickaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        boolean underwaterSpeed = stack.getOrDefault(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, false);
        float originalSpeed = super.getMiningSpeed(stack, state);
        return underwaterSpeed ? originalSpeed * 3f : originalSpeed;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof PlayerEntity player) {
            if (player.isTouchingWater()) {
                player.getMainHandStack().set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
            } else {
                player.getMainHandStack().remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(MGTooltip.itemSpecialEffect("special_effect.moregears.bronze_tools"));
    }
}
