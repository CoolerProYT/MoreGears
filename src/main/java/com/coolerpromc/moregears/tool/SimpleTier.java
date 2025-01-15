package com.coolerpromc.moregears.tool;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public class SimpleTier implements ToolMaterial {
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    public SimpleTier(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return uses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return speed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamageBonus;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantability() {
        return enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}