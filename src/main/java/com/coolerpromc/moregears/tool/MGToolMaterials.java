package com.coolerpromc.moregears.tool;

import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum MGToolMaterials implements ToolMaterial {
    COPPER_TIER(1, 200, 5f, 1.5f, 20, () -> Ingredient.fromTag(ConventionalItemTags.COPPER_INGOTS)),
    BRONZE_TIER(2, 700, 7f, 2.5f, 13, () -> Ingredient.fromTag(MGTags.Items.INGOTS_BRONZE)),
    STEEL_TIER (3, 1300, 8f, 3f, 12, () -> Ingredient.fromTag(MGTags.Items.INGOTS_STEEL)),
    RUBY_TIER(3, 1000, 7.5f, 2.75f, 11, () -> Ingredient.fromTag(MGTags.Items.GEMS_RUBY)),
    TITANIUM_TIER(5, 3000, 12.0f, 6f, 18, () -> Ingredient.fromTag(MGTags.Items.INGOTS_TITANIUM)),
    ENDERITE_TIER(6, Integer.MAX_VALUE, 18.0f, 9f, 24, () -> Ingredient.fromTag(MGTags.Items.INGOTS_ENDERITE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    MGToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
