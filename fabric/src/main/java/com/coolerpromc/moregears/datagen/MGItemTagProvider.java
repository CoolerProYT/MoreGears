package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class MGItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public MGItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.builder(ItemTags.TRIMMABLE_ARMOR).add(
                MGItems.BRONZE_BOOTS.key(),
                MGItems.BRONZE_CHESTPLATE.key(),
                MGItems.BRONZE_HELMET.key(),
                MGItems.BRONZE_LEGGINGS.key(),
                MGItems.STEEL_BOOTS.key(),
                MGItems.STEEL_CHESTPLATE.key(),
                MGItems.STEEL_HELMET.key(),
                MGItems.STEEL_LEGGINGS.key(),
                MGItems.RUBY_BOOTS.key(),
                MGItems.RUBY_CHESTPLATE.key(),
                MGItems.RUBY_HELMET.key(),
                MGItems.RUBY_LEGGINGS.key(),
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_BOOTS.key(),
                MGItems.ENDERITE_CHESTPLATE.key(),
                MGItems.ENDERITE_HELMET.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );

        this.builder(ItemTags.ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS.key(),
                MGItems.BRONZE_CHESTPLATE.key(),
                MGItems.BRONZE_HELMET.key(),
                MGItems.BRONZE_LEGGINGS.key(),
                MGItems.STEEL_BOOTS.key(),
                MGItems.STEEL_CHESTPLATE.key(),
                MGItems.STEEL_HELMET.key(),
                MGItems.STEEL_LEGGINGS.key(),
                MGItems.RUBY_BOOTS.key(),
                MGItems.RUBY_CHESTPLATE.key(),
                MGItems.RUBY_HELMET.key(),
                MGItems.RUBY_LEGGINGS.key(),
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_BOOTS.key(),
                MGItems.ENDERITE_CHESTPLATE.key(),
                MGItems.ENDERITE_HELMET.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );

        this.builder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS.key(),
                MGItems.BRONZE_CHESTPLATE.key(),
                MGItems.BRONZE_HELMET.key(),
                MGItems.BRONZE_LEGGINGS.key(),
                MGItems.STEEL_BOOTS.key(),
                MGItems.STEEL_CHESTPLATE.key(),
                MGItems.STEEL_HELMET.key(),
                MGItems.STEEL_LEGGINGS.key(),
                MGItems.RUBY_BOOTS.key(),
                MGItems.RUBY_CHESTPLATE.key(),
                MGItems.RUBY_HELMET.key(),
                MGItems.RUBY_LEGGINGS.key(),
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_BOOTS.key(),
                MGItems.ENDERITE_CHESTPLATE.key(),
                MGItems.ENDERITE_HELMET.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );

        this.builder(ItemTags.HEAD_ARMOR).add(
                MGItems.BRONZE_HELMET.key(),
                MGItems.STEEL_HELMET.key(),
                MGItems.RUBY_HELMET.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.ENDERITE_HELMET.key()
        );

        this.builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_HELMET.key(),
                MGItems.STEEL_HELMET.key(),
                MGItems.RUBY_HELMET.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.ENDERITE_HELMET.key()
        );

        this.builder(ItemTags.CHEST_ARMOR).add(
                MGItems.BRONZE_CHESTPLATE.key(),
                MGItems.STEEL_CHESTPLATE.key(),
                MGItems.RUBY_CHESTPLATE.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.ENDERITE_CHESTPLATE.key()
        );

        this.builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_CHESTPLATE.key(),
                MGItems.STEEL_CHESTPLATE.key(),
                MGItems.RUBY_CHESTPLATE.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.ENDERITE_CHESTPLATE.key()
        );

        this.builder(ItemTags.LEG_ARMOR).add(
                MGItems.BRONZE_LEGGINGS.key(),
                MGItems.STEEL_LEGGINGS.key(),
                MGItems.RUBY_LEGGINGS.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );

        this.builder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_LEGGINGS.key(),
                MGItems.STEEL_LEGGINGS.key(),
                MGItems.RUBY_LEGGINGS.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );

        this.builder(ItemTags.FOOT_ARMOR).add(
                MGItems.BRONZE_BOOTS.key(),
                MGItems.STEEL_BOOTS.key(),
                MGItems.RUBY_BOOTS.key(),
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.ENDERITE_BOOTS.key()
        );

        this.builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS.key(),
                MGItems.STEEL_BOOTS.key(),
                MGItems.RUBY_BOOTS.key(),
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.ENDERITE_BOOTS.key()
        );

        this.builder(ItemTags.SWORDS).add(
                MGItems.BRONZE_SWORD.key(),
                MGItems.STEEL_SWORD.key(),
                MGItems.RUBY_SWORD.key(),
                MGItems.TITANIUM_SWORD.key(),
                MGItems.ENDERITE_SWORD.key()
        );

        this.builder(ItemTags.PICKAXES).add(
                MGItems.BRONZE_PICKAXE.key(),
                MGItems.STEEL_PICKAXE.key(),
                MGItems.RUBY_PICKAXE.key(),
                MGItems.TITANIUM_PICKAXE.key(),
                MGItems.ENDERITE_PICKAXE.key()
        );

        this.builder(ItemTags.SHOVELS).add(
                MGItems.BRONZE_SHOVEL.key(),
                MGItems.STEEL_SHOVEL.key(),
                MGItems.RUBY_SHOVEL.key(),
                MGItems.TITANIUM_SHOVEL.key(),
                MGItems.ENDERITE_SHOVEL.key()
        );

        this.builder(ItemTags.AXES).add(
                MGItems.BRONZE_AXE.key(),
                MGItems.STEEL_AXE.key(),
                MGItems.RUBY_AXE.key(),
                MGItems.TITANIUM_AXE.key(),
                MGItems.ENDERITE_AXE.key()
        );

        this.builder(ItemTags.HOES).add(
                MGItems.BRONZE_HOE.key(),
                MGItems.STEEL_HOE.key(),
                MGItems.RUBY_HOE.key(),
                MGItems.TITANIUM_HOE.key(),
                MGItems.ENDERITE_HOE.key()
        );

        this.builder(MGTags.Items.INGOTS_BRONZE)
                .add(MGItems.BRONZE_INGOT.key());

        this.builder(MGTags.Items.INGOTS_STEEL)
                .add(MGItems.STEEL_INGOT.key());

        this.builder(MGTags.Items.INGOTS_TITANIUM)
                .add(MGItems.TITANIUM_INGOT.key());

        this.builder(MGTags.Items.INGOTS_ENDERITE)
                .add(MGItems.ENDERITE_INGOT.key());

        this.builder(MGTags.Items.GEMS_RUBY)
                .add(MGItems.RUBY_INGOT.key());

        this.builder(ItemTags.ARROWS).add(
                MGItems.COPPER_ARROW.key(),
                MGItems.BRONZE_ARROW.key(),
                MGItems.STEEL_ARROW.key(),
                MGItems.RUBY_ARROW.key(),
                MGItems.TITANIUM_ARROW.key(),
                MGItems.ENDERITE_ARROW.key()
        );

        this.builder(ItemTags.BOW_ENCHANTABLE).add(
                MGItems.COPPER_BOW.key(),
                MGItems.BRONZE_BOW.key(),
                MGItems.STEEL_BOW.key(),
                MGItems.RUBY_BOW.key(),
                MGItems.TITANIUM_BOW.key(),
                MGItems.ENDERITE_BOW.key()
        );

        this.builder(ItemTags.TRIM_MATERIALS).add(
                MGItems.TIN_INGOT.key(),
                MGItems.BRONZE_INGOT.key(),
                MGItems.STEEL_INGOT.key(),
                MGItems.RUBY_INGOT.key(),
                MGItems.TITANIUM_INGOT.key(),
                MGItems.ENDERITE_INGOT.key()
        );

        this.builder(ItemTags.DURABILITY_ENCHANTABLE).add(
                MGItems.COPPER_BOW.key(),
                MGItems.BRONZE_BOW.key(),
                MGItems.STEEL_BOW.key(),
                MGItems.RUBY_BOW.key(),
                MGItems.TITANIUM_BOW.key(),
                MGItems.TITANIUM_MACE.key()
        );

        this.builder(ItemTags.MACE_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.key(),
                MGItems.ENDERITE_MACE.key()
        );

        this.builder(ItemTags.WEAPON_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.key(),
                MGItems.ENDERITE_MACE.key()
        );

        this.builder(ItemTags.SPEARS).add(
                MGItems.BRONZE_SPEAR.key(),
                MGItems.STEEL_SPEAR.key(),
                MGItems.RUBY_SPEAR.key(),
                MGItems.TITANIUM_SPEAR.key(),
                MGItems.ENDERITE_SPEAR.key()
        );

        this.builder(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.key(),
                MGItems.ENDERITE_MACE.key()
        );

        this.builder(ConventionalItemTags.MACE_TOOLS).add(
                MGItems.TITANIUM_MACE.key(),
                MGItems.ENDERITE_MACE.key()
        );

        this.builder(ConventionalItemTags.MELEE_WEAPON_TOOLS).add(
                MGItems.BRONZE_SPEAR.key(),
                MGItems.STEEL_SPEAR.key(),
                MGItems.RUBY_SPEAR.key(),
                MGItems.TITANIUM_SPEAR.key(),
                MGItems.ENDERITE_SPEAR.key(),
                MGItems.TITANIUM_MACE.key(),
                MGItems.ENDERITE_MACE.key()
        );

        this.builder(ItemTags.PIGLIN_SAFE_ARMOR).add(
                MGItems.TITANIUM_BOOTS.key(),
                MGItems.TITANIUM_CHESTPLATE.key(),
                MGItems.TITANIUM_HELMET.key(),
                MGItems.TITANIUM_LEGGINGS.key(),
                MGItems.ENDERITE_BOOTS.key(),
                MGItems.ENDERITE_CHESTPLATE.key(),
                MGItems.ENDERITE_HELMET.key(),
                MGItems.ENDERITE_LEGGINGS.key()
        );
    }
}
