package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class MGItemTagGenerator extends ItemTagsProvider {
    public MGItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MoreGears.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                MGItems.COPPER_BOOTS.get(),
                MGItems.COPPER_CHESTPLATE.get(),
                MGItems.COPPER_HELMET.get(),
                MGItems.COPPER_LEGGINGS.get(),
                MGItems.BRONZE_BOOTS.get(),
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.BRONZE_HELMET.get(),
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_BOOTS.get(),
                MGItems.ENDERITE_CHESTPLATE.get(),
                MGItems.ENDERITE_HELMET.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS.get(),
                MGItems.COPPER_CHESTPLATE.get(),
                MGItems.COPPER_HELMET.get(),
                MGItems.COPPER_LEGGINGS.get(),
                MGItems.BRONZE_BOOTS.get(),
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.BRONZE_HELMET.get(),
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_BOOTS.get(),
                MGItems.ENDERITE_CHESTPLATE.get(),
                MGItems.ENDERITE_HELMET.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS.get(),
                MGItems.COPPER_CHESTPLATE.get(),
                MGItems.COPPER_HELMET.get(),
                MGItems.COPPER_LEGGINGS.get(),
                MGItems.BRONZE_BOOTS.get(),
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.BRONZE_HELMET.get(),
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_BOOTS.get(),
                MGItems.ENDERITE_CHESTPLATE.get(),
                MGItems.ENDERITE_HELMET.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.HEAD_ARMOR).add(
                MGItems.COPPER_HELMET.get(),
                MGItems.BRONZE_HELMET.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.ENDERITE_HELMET.get()
        );

        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_HELMET.get(),
                MGItems.BRONZE_HELMET.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.ENDERITE_HELMET.get()
        );

        this.tag(ItemTags.CHEST_ARMOR).add(
                MGItems.COPPER_CHESTPLATE.get(),
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.ENDERITE_CHESTPLATE.get()
        );

        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_CHESTPLATE.get(),
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.ENDERITE_CHESTPLATE.get()
        );

        this.tag(ItemTags.LEG_ARMOR).add(
                MGItems.COPPER_LEGGINGS.get(),
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_LEGGINGS.get(),
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR).add(
                MGItems.COPPER_BOOTS.get(),
                MGItems.BRONZE_BOOTS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.ENDERITE_BOOTS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MGItems.COPPER_BOOTS.get(),
                MGItems.BRONZE_BOOTS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.ENDERITE_BOOTS.get()
        );

        this.tag(ItemTags.SWORDS).add(
                MGItems.COPPER_SWORD.get(),
                MGItems.BRONZE_SWORD.get(),
                MGItems.STEEL_SWORD.get(),
                MGItems.RUBY_SWORD.get(),
                MGItems.TITANIUM_SWORD.get(),
                MGItems.ENDERITE_SWORD.get()
        );

        this.tag(ItemTags.PICKAXES).add(
                MGItems.COPPER_PICKAXE.get(),
                MGItems.BRONZE_PICKAXE.get(),
                MGItems.STEEL_PICKAXE.get(),
                MGItems.RUBY_PICKAXE.get(),
                MGItems.TITANIUM_PICKAXE.get(),
                MGItems.ENDERITE_PICKAXE.get()
        );

        this.tag(ItemTags.SHOVELS).add(
                MGItems.COPPER_SHOVEL.get(),
                MGItems.BRONZE_SHOVEL.get(),
                MGItems.STEEL_SHOVEL.get(),
                MGItems.RUBY_SHOVEL.get(),
                MGItems.TITANIUM_SHOVEL.get(),
                MGItems.ENDERITE_SHOVEL.get()
        );

        this.tag(ItemTags.AXES).add(
                MGItems.COPPER_AXE.get(),
                MGItems.BRONZE_AXE.get(),
                MGItems.STEEL_AXE.get(),
                MGItems.RUBY_AXE.get(),
                MGItems.TITANIUM_AXE.get(),
                MGItems.ENDERITE_AXE.get()
        );

        this.tag(ItemTags.HOES).add(
                MGItems.COPPER_HOE.get(),
                MGItems.BRONZE_HOE.get(),
                MGItems.STEEL_HOE.get(),
                MGItems.RUBY_HOE.get(),
                MGItems.TITANIUM_HOE.get(),
                MGItems.ENDERITE_HOE.get()
        );

        this.tag(ItemTags.TRIM_MATERIALS).add(
                MGItems.TITANIUM_INGOT.get(),
                MGItems.ENDERITE_INGOT.get()
        );
    }
}
