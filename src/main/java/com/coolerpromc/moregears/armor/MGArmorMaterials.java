package com.coolerpromc.moregears.armor;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum MGArmorMaterials implements ArmorMaterial{
    COPPER("copper", 15, new int[]{2, 4, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)),
    BRONZE("bronze", 22, new int[]{3, 5, 7, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(MGTags.Items.INGOTS_BRONZE)),
    STEEL("steel", 30, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.5f, 0, () -> Ingredient.of(MGTags.Items.INGOTS_STEEL)),
    RUBY("ruby", 28, new int[]{3, 6, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1f, 0, () -> Ingredient.of(MGTags.Items.GEMS_RUBY)),
    TITANIUM("titanium", 45, new int[]{4, 7, 9, 4}, 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 4f, 0.5f, () -> Ingredient.of(MGTags.Items.INGOTS_TITANIUM)),
    ENDERITE("enderite", Integer.MAX_VALUE, new int[]{5, 8, 10, 5}, 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 5f, 1f, () -> Ingredient.of(MGTags.Items.INGOTS_ENDERITE))
    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    MGArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }
    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }
    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }
    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    @Override
    public String getName() {
        return MoreGears.MODID + ":" + this.name;
    }
    @Override
    public float getToughness() {
        return this.toughness;
    }
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
