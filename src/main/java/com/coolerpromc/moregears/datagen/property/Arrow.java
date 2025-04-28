package com.coolerpromc.moregears.datagen.property;

import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.render.item.property.select.SelectProperty;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.jetbrains.annotations.Nullable;

public record Arrow() implements SelectProperty<MGArrowItem.MGArrowType> {
    public static final Codec<MGArrowItem.MGArrowType> VALUE_CODEC = MGArrowItem.MGArrowType.CODEC;
    public static final SelectProperty.Type<Arrow, MGArrowItem.MGArrowType> TYPE = SelectProperty.Type.create(MapCodec.unit(new Arrow()), VALUE_CODEC);

    @Override
    public @Nullable MGArrowItem.MGArrowType getValue(ItemStack itemStack, @Nullable ClientWorld clientLevel, @Nullable LivingEntity livingEntity, int i, ModelTransformationMode itemDisplayContext) {
        if (livingEntity == null) return null;

        if (itemStack.getItem() instanceof BowItem) {
            ItemStack arrowStack = livingEntity instanceof PlayerEntity player ? player.getProjectileType(itemStack) : ItemStack.EMPTY;

            if (arrowStack.getItem() instanceof MGArrowItem arrowItem) {
                if (arrowItem == MGItems.COPPER_ARROW){
                    return MGArrowItem.MGArrowType.COPPER;
                } else if (arrowItem == MGItems.BRONZE_ARROW) {
                    return MGArrowItem.MGArrowType.BRONZE;
                } else if (arrowItem == MGItems.STEEL_ARROW) {
                    return MGArrowItem.MGArrowType.STEEL;
                } else if (arrowItem == MGItems.RUBY_ARROW) {
                    return MGArrowItem.MGArrowType.RUBY;
                } else if (arrowItem == MGItems.TITANIUM_ARROW) {
                    return MGArrowItem.MGArrowType.TITANIUM;
                } else if (arrowItem == MGItems.ENDERITE_ARROW) {
                    return MGArrowItem.MGArrowType.ENDERITE;
                }
            }
        }

        return null;
    }

    @Override
    public Type<? extends SelectProperty<MGArrowItem.MGArrowType>, MGArrowItem.MGArrowType> getType() {
        return TYPE;
    }
}