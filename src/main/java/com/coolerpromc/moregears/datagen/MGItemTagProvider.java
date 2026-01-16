package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class MGItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MGItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(
                MGItems.BRONZE_BOOTS,
                MGItems.BRONZE_CHESTPLATE,
                MGItems.BRONZE_HELMET,
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_BOOTS,
                MGItems.STEEL_CHESTPLATE,
                MGItems.STEEL_HELMET,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_BOOTS,
                MGItems.RUBY_CHESTPLATE,
                MGItems.RUBY_HELMET,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_BOOTS,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.TITANIUM_HELMET,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_BOOTS,
                MGItems.ENDERITE_CHESTPLATE,
                MGItems.ENDERITE_HELMET,
                MGItems.ENDERITE_LEGGINGS
        );

        this.valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS,
                MGItems.BRONZE_CHESTPLATE,
                MGItems.BRONZE_HELMET,
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_BOOTS,
                MGItems.STEEL_CHESTPLATE,
                MGItems.STEEL_HELMET,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_BOOTS,
                MGItems.RUBY_CHESTPLATE,
                MGItems.RUBY_HELMET,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_BOOTS,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.TITANIUM_HELMET,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_BOOTS,
                MGItems.ENDERITE_CHESTPLATE,
                MGItems.ENDERITE_HELMET,
                MGItems.ENDERITE_LEGGINGS
        );

        this.valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS,
                MGItems.BRONZE_CHESTPLATE,
                MGItems.BRONZE_HELMET,
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_BOOTS,
                MGItems.STEEL_CHESTPLATE,
                MGItems.STEEL_HELMET,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_BOOTS,
                MGItems.RUBY_CHESTPLATE,
                MGItems.RUBY_HELMET,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_BOOTS,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.TITANIUM_HELMET,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_BOOTS,
                MGItems.ENDERITE_CHESTPLATE,
                MGItems.ENDERITE_HELMET,
                MGItems.ENDERITE_LEGGINGS
        );

        this.valueLookupBuilder(ItemTags.HEAD_ARMOR).add(
                MGItems.BRONZE_HELMET,
                MGItems.STEEL_HELMET,
                MGItems.RUBY_HELMET,
                MGItems.TITANIUM_HELMET,
                MGItems.ENDERITE_HELMET
        );

        this.valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_HELMET,
                MGItems.STEEL_HELMET,
                MGItems.RUBY_HELMET,
                MGItems.TITANIUM_HELMET,
                MGItems.ENDERITE_HELMET
        );

        this.valueLookupBuilder(ItemTags.CHEST_ARMOR).add(
                MGItems.BRONZE_CHESTPLATE,
                MGItems.STEEL_CHESTPLATE,
                MGItems.RUBY_CHESTPLATE,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.ENDERITE_CHESTPLATE
        );

        this.valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_CHESTPLATE,
                MGItems.STEEL_CHESTPLATE,
                MGItems.RUBY_CHESTPLATE,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.ENDERITE_CHESTPLATE
        );

        this.valueLookupBuilder(ItemTags.LEG_ARMOR).add(
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_LEGGINGS
        );

        this.valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_LEGGINGS
        );

        this.valueLookupBuilder(ItemTags.FOOT_ARMOR).add(
                MGItems.BRONZE_BOOTS,
                MGItems.STEEL_BOOTS,
                MGItems.RUBY_BOOTS,
                MGItems.TITANIUM_BOOTS,
                MGItems.ENDERITE_BOOTS
        );

        this.valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS,
                MGItems.STEEL_BOOTS,
                MGItems.RUBY_BOOTS,
                MGItems.TITANIUM_BOOTS,
                MGItems.ENDERITE_BOOTS
        );

        this.valueLookupBuilder(ItemTags.SWORDS).add(
                MGItems.BRONZE_SWORD,
                MGItems.STEEL_SWORD,
                MGItems.RUBY_SWORD,
                MGItems.TITANIUM_SWORD,
                MGItems.ENDERITE_SWORD
        );

        this.valueLookupBuilder(ItemTags.PICKAXES).add(
                MGItems.BRONZE_PICKAXE,
                MGItems.STEEL_PICKAXE,
                MGItems.RUBY_PICKAXE,
                MGItems.TITANIUM_PICKAXE,
                MGItems.ENDERITE_PICKAXE
        );

        this.valueLookupBuilder(ItemTags.SHOVELS).add(
                MGItems.BRONZE_SHOVEL,
                MGItems.STEEL_SHOVEL,
                MGItems.RUBY_SHOVEL,
                MGItems.TITANIUM_SHOVEL,
                MGItems.ENDERITE_SHOVEL
        );

        this.valueLookupBuilder(ItemTags.AXES).add(
                MGItems.BRONZE_AXE,
                MGItems.STEEL_AXE,
                MGItems.RUBY_AXE,
                MGItems.TITANIUM_AXE,
                MGItems.ENDERITE_AXE
        );

        this.valueLookupBuilder(ItemTags.HOES).add(
                MGItems.BRONZE_HOE,
                MGItems.STEEL_HOE,
                MGItems.RUBY_HOE,
                MGItems.TITANIUM_HOE,
                MGItems.ENDERITE_HOE
        );

        this.valueLookupBuilder(MGTags.Items.INGOTS_BRONZE)
                .add(MGItems.BRONZE_INGOT);

        this.valueLookupBuilder(MGTags.Items.INGOTS_STEEL)
                .add(MGItems.STEEL_INGOT);

        this.valueLookupBuilder(MGTags.Items.INGOTS_TITANIUM)
                .add(MGItems.TITANIUM_INGOT);

        this.valueLookupBuilder(MGTags.Items.INGOTS_ENDERITE)
                .add(MGItems.ENDERITE_INGOT);

        this.valueLookupBuilder(MGTags.Items.GEMS_RUBY)
                .add(MGItems.RUBY_INGOT);

        this.valueLookupBuilder(ItemTags.ARROWS).add(
                MGItems.COPPER_ARROW,
                MGItems.BRONZE_ARROW,
                MGItems.STEEL_ARROW,
                MGItems.RUBY_ARROW,
                MGItems.TITANIUM_ARROW,
                MGItems.ENDERITE_ARROW
        );

        this.valueLookupBuilder(ItemTags.BOW_ENCHANTABLE).add(
                MGItems.COPPER_BOW,
                MGItems.BRONZE_BOW,
                MGItems.STEEL_BOW,
                MGItems.RUBY_BOW,
                MGItems.TITANIUM_BOW,
                MGItems.ENDERITE_BOW
        );

        this.valueLookupBuilder(ItemTags.TRIM_MATERIALS).add(
                MGItems.TIN_INGOT,
                MGItems.BRONZE_INGOT,
                MGItems.STEEL_INGOT,
                MGItems.RUBY_INGOT,
                MGItems.TITANIUM_INGOT,
                MGItems.ENDERITE_INGOT
        );

        this.valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(
                MGItems.COPPER_BOW,
                MGItems.BRONZE_BOW,
                MGItems.STEEL_BOW,
                MGItems.RUBY_BOW,
                MGItems.TITANIUM_BOW
        );
    }
}
