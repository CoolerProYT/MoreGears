package com.coolerpromc.moregears.util;

import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public record Arrow() implements SelectItemModelProperty<MGArrowItem.MGArrowType> {
    public static final Codec<MGArrowItem.MGArrowType> VALUE_CODEC = MGArrowItem.MGArrowType.CODEC;
    public static final Type<Arrow, MGArrowItem.MGArrowType> TYPE = Type.create(MapCodec.unit(new Arrow()), VALUE_CODEC);

    @Override
    public @Nullable MGArrowItem.MGArrowType get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i, ItemDisplayContext itemDisplayContext) {
        if (livingEntity == null) return null;

        if (itemStack.getItem() instanceof BowItem) {
            ItemStack arrowStack = livingEntity instanceof Player player ? player.getProjectile(itemStack) : ItemStack.EMPTY;

            if (arrowStack.getItem() instanceof MGArrowItem arrowItem) {
                if (arrowItem == MGItems.COPPER_ARROW.get()){
                    return MGArrowItem.MGArrowType.COPPER;
                } else if (arrowItem == MGItems.BRONZE_ARROW.get()) {
                    return MGArrowItem.MGArrowType.BRONZE;
                } else if (arrowItem == MGItems.STEEL_ARROW.get()) {
                    return MGArrowItem.MGArrowType.STEEL;
                } else if (arrowItem == MGItems.RUBY_ARROW.get()) {
                    return MGArrowItem.MGArrowType.RUBY;
                } else if (arrowItem == MGItems.TITANIUM_ARROW.get()) {
                    return MGArrowItem.MGArrowType.TITANIUM;
                } else if (arrowItem == MGItems.ENDERITE_ARROW.get()) {
                    return MGArrowItem.MGArrowType.ENDERITE;
                }
            }
        }

        return null;
    }

    @Override
    public Codec<MGArrowItem.MGArrowType> valueCodec() {
        return VALUE_CODEC;
    }

    @Override
    public Type<? extends SelectItemModelProperty<MGArrowItem.MGArrowType>, MGArrowItem.MGArrowType> type() {
        return TYPE;
    }
}