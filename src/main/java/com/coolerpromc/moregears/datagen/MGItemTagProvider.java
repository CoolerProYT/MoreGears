package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.item.MGItems;
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
        this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(
                MGItems.COPPER_BOOTS,
                MGItems.COPPER_CHESTPLATE,
                MGItems.COPPER_HELMET,
                MGItems.COPPER_LEGGINGS,
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

        this.getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS,
                MGItems.COPPER_CHESTPLATE,
                MGItems.COPPER_HELMET,
                MGItems.COPPER_LEGGINGS,
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

        this.getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS,
                MGItems.COPPER_CHESTPLATE,
                MGItems.COPPER_HELMET,
                MGItems.COPPER_LEGGINGS,
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

        this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(
                MGItems.COPPER_HELMET,
                MGItems.BRONZE_HELMET,
                MGItems.STEEL_HELMET,
                MGItems.RUBY_HELMET,
                MGItems.TITANIUM_HELMET,
                MGItems.ENDERITE_HELMET
        );

        this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_HELMET,
                MGItems.BRONZE_HELMET,
                MGItems.STEEL_HELMET,
                MGItems.RUBY_HELMET,
                MGItems.TITANIUM_HELMET,
                MGItems.ENDERITE_HELMET
        );

        this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(
                MGItems.COPPER_CHESTPLATE,
                MGItems.BRONZE_CHESTPLATE,
                MGItems.STEEL_CHESTPLATE,
                MGItems.RUBY_CHESTPLATE,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.ENDERITE_CHESTPLATE
        );

        this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_CHESTPLATE,
                MGItems.BRONZE_CHESTPLATE,
                MGItems.STEEL_CHESTPLATE,
                MGItems.RUBY_CHESTPLATE,
                MGItems.TITANIUM_CHESTPLATE,
                MGItems.ENDERITE_CHESTPLATE
        );

        this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(
                MGItems.COPPER_LEGGINGS,
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_LEGGINGS
        );

        this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_LEGGINGS,
                MGItems.BRONZE_LEGGINGS,
                MGItems.STEEL_LEGGINGS,
                MGItems.RUBY_LEGGINGS,
                MGItems.TITANIUM_LEGGINGS,
                MGItems.ENDERITE_LEGGINGS
        );

        this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(
                MGItems.COPPER_BOOTS,
                MGItems.BRONZE_BOOTS,
                MGItems.STEEL_BOOTS,
                MGItems.RUBY_BOOTS,
                MGItems.TITANIUM_BOOTS,
                MGItems.ENDERITE_BOOTS
        );

        this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS,
                MGItems.BRONZE_BOOTS,
                MGItems.STEEL_BOOTS,
                MGItems.RUBY_BOOTS,
                MGItems.TITANIUM_BOOTS,
                MGItems.ENDERITE_BOOTS
        );

        this.getOrCreateTagBuilder(ItemTags.SWORDS).add(
                MGItems.COPPER_SWORD,
                MGItems.BRONZE_SWORD,
                MGItems.STEEL_SWORD,
                MGItems.RUBY_SWORD,
                MGItems.TITANIUM_SWORD,
                MGItems.ENDERITE_SWORD
        );

        this.getOrCreateTagBuilder(ItemTags.PICKAXES).add(
                MGItems.COPPER_PICKAXE,
                MGItems.BRONZE_PICKAXE,
                MGItems.STEEL_PICKAXE,
                MGItems.RUBY_PICKAXE,
                MGItems.TITANIUM_PICKAXE,
                MGItems.ENDERITE_PICKAXE
        );

        this.getOrCreateTagBuilder(ItemTags.SHOVELS).add(
                MGItems.COPPER_SHOVEL,
                MGItems.BRONZE_SHOVEL,
                MGItems.STEEL_SHOVEL,
                MGItems.RUBY_SHOVEL,
                MGItems.TITANIUM_SHOVEL,
                MGItems.ENDERITE_SHOVEL
        );

        this.getOrCreateTagBuilder(ItemTags.AXES).add(
                MGItems.COPPER_AXE,
                MGItems.BRONZE_AXE,
                MGItems.STEEL_AXE,
                MGItems.RUBY_AXE,
                MGItems.TITANIUM_AXE,
                MGItems.ENDERITE_AXE
        );

        this.getOrCreateTagBuilder(ItemTags.HOES).add(
                MGItems.COPPER_HOE,
                MGItems.BRONZE_HOE,
                MGItems.STEEL_HOE,
                MGItems.RUBY_HOE,
                MGItems.TITANIUM_HOE,
                MGItems.ENDERITE_HOE
        );

        this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(
                MGItems.TITANIUM_INGOT,
                MGItems.ENDERITE_INGOT
        );
    }
}
