package com.coolerpromc.moregears.recipe.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.dynamic.Codecs;

import java.util.Objects;
import java.util.Optional;

public final class SizedIngredient {
    public static final Codec<SizedIngredient> NESTED_CODEC = RecordCodecBuilder.create((instance) -> instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter(SizedIngredient::ingredient), optionalFieldAlwaysWrite(Codecs.POSITIVE_INT, "count", 1).forGetter(SizedIngredient::count)).apply(instance, SizedIngredient::new));
    public static final PacketCodec<RegistryByteBuf, SizedIngredient> STREAM_CODEC;
    private final Ingredient ingredient;
    private final int count;

    public static SizedIngredient of(ItemConvertible item, int count) {
        return new SizedIngredient(Ingredient.ofItem(item), count);
    }

    public SizedIngredient(Ingredient ingredient, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        } else {
            this.ingredient = ingredient;
            this.count = count;
        }
    }

    public Ingredient ingredient() {
        return this.ingredient;
    }

    public int count() {
        return this.count;
    }

    public boolean test(ItemStack stack) {
        return this.ingredient.test(stack) && stack.getCount() >= this.count;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof SizedIngredient)) {
            return false;
        } else {
            SizedIngredient other = (SizedIngredient)o;
            return this.count == other.count && this.ingredient.equals(other.ingredient);
        }
    }

    public int hashCode() {
        return Objects.hash(this.ingredient, this.count);
    }

    public String toString() {
        return this.count + "x " + this.ingredient;
    }

    static {
        STREAM_CODEC = PacketCodec.tuple(Ingredient.PACKET_CODEC, SizedIngredient::ingredient, PacketCodecs.VAR_INT, SizedIngredient::count, SizedIngredient::new);
    }

    public static <T> MapCodec<T> optionalFieldAlwaysWrite(Codec<T> codec, String name, T defaultValue) {
        return codec.optionalFieldOf(name).xmap((o) -> o.orElse(defaultValue), Optional::of);
    }
}
