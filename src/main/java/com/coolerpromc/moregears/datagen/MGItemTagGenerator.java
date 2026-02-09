package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.util.MGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MGItemTagGenerator extends ItemTagsProvider {
    public MGItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MoreGears.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
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
                MGItems.BRONZE_HELMET.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.ENDERITE_HELMET.get()
        );

        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_HELMET.get(),
                MGItems.STEEL_HELMET.get(),
                MGItems.RUBY_HELMET.get(),
                MGItems.TITANIUM_HELMET.get(),
                MGItems.ENDERITE_HELMET.get()
        );

        this.tag(ItemTags.CHEST_ARMOR).add(
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.ENDERITE_CHESTPLATE.get()
        );

        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_CHESTPLATE.get(),
                MGItems.STEEL_CHESTPLATE.get(),
                MGItems.RUBY_CHESTPLATE.get(),
                MGItems.TITANIUM_CHESTPLATE.get(),
                MGItems.ENDERITE_CHESTPLATE.get()
        );

        this.tag(ItemTags.LEG_ARMOR).add(
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_LEGGINGS.get(),
                MGItems.STEEL_LEGGINGS.get(),
                MGItems.RUBY_LEGGINGS.get(),
                MGItems.TITANIUM_LEGGINGS.get(),
                MGItems.ENDERITE_LEGGINGS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR).add(
                MGItems.BRONZE_BOOTS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.ENDERITE_BOOTS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MGItems.BRONZE_BOOTS.get(),
                MGItems.STEEL_BOOTS.get(),
                MGItems.RUBY_BOOTS.get(),
                MGItems.TITANIUM_BOOTS.get(),
                MGItems.ENDERITE_BOOTS.get()
        );

        this.tag(ItemTags.SWORDS).add(
                MGItems.BRONZE_SWORD.get(),
                MGItems.STEEL_SWORD.get(),
                MGItems.RUBY_SWORD.get(),
                MGItems.TITANIUM_SWORD.get(),
                MGItems.ENDERITE_SWORD.get()
        );

        this.tag(ItemTags.PICKAXES).add(
                MGItems.BRONZE_PICKAXE.get(),
                MGItems.STEEL_PICKAXE.get(),
                MGItems.RUBY_PICKAXE.get(),
                MGItems.TITANIUM_PICKAXE.get(),
                MGItems.ENDERITE_PICKAXE.get()
        );

        this.tag(ItemTags.SHOVELS).add(
                MGItems.BRONZE_SHOVEL.get(),
                MGItems.STEEL_SHOVEL.get(),
                MGItems.RUBY_SHOVEL.get(),
                MGItems.TITANIUM_SHOVEL.get(),
                MGItems.ENDERITE_SHOVEL.get()
        );

        this.tag(ItemTags.AXES).add(
                MGItems.BRONZE_AXE.get(),
                MGItems.STEEL_AXE.get(),
                MGItems.RUBY_AXE.get(),
                MGItems.TITANIUM_AXE.get(),
                MGItems.ENDERITE_AXE.get()
        );

        this.tag(ItemTags.HOES).add(
                MGItems.BRONZE_HOE.get(),
                MGItems.STEEL_HOE.get(),
                MGItems.RUBY_HOE.get(),
                MGItems.TITANIUM_HOE.get(),
                MGItems.ENDERITE_HOE.get()
        );

        this.tag(MGTags.Items.INGOTS_BRONZE)
                .add(MGItems.BRONZE_INGOT.get());

        this.tag(MGTags.Items.INGOTS_STEEL)
                .add(MGItems.STEEL_INGOT.get());

        this.tag(MGTags.Items.INGOTS_TITANIUM)
                .add(MGItems.TITANIUM_INGOT.get());

        this.tag(MGTags.Items.INGOTS_ENDERITE)
                .add(MGItems.ENDERITE_INGOT.get());

        this.tag(MGTags.Items.GEMS_RUBY)
                .add(MGItems.RUBY_INGOT.get());

        this.tag(ItemTags.ARROWS).add(
                MGItems.COPPER_ARROW.get(),
                MGItems.BRONZE_ARROW.get(),
                MGItems.STEEL_ARROW.get(),
                MGItems.RUBY_ARROW.get(),
                MGItems.TITANIUM_ARROW.get(),
                MGItems.ENDERITE_ARROW.get()
        );

        this.tag(ItemTags.BOW_ENCHANTABLE).add(
                MGItems.COPPER_BOW.get(),
                MGItems.BRONZE_BOW.get(),
                MGItems.STEEL_BOW.get(),
                MGItems.RUBY_BOW.get(),
                MGItems.TITANIUM_BOW.get(),
                MGItems.ENDERITE_BOW.get()
        );

        this.tag(ItemTags.TRIM_MATERIALS).add(
                MGItems.TIN_INGOT.get(),
                MGItems.BRONZE_INGOT.get(),
                MGItems.STEEL_INGOT.get(),
                MGItems.RUBY_INGOT.get(),
                MGItems.TITANIUM_INGOT.get(),
                MGItems.ENDERITE_INGOT.get()
        );

        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(
                MGItems.COPPER_BOW.get(),
                MGItems.BRONZE_BOW.get(),
                MGItems.STEEL_BOW.get(),
                MGItems.RUBY_BOW.get(),
                MGItems.TITANIUM_BOW.get(),
                MGItems.TITANIUM_MACE.get()
        );

        this.tag(ItemTags.MACE_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.get(),
                MGItems.ENDERITE_MACE.get()
        );

        this.tag(ItemTags.WEAPON_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.get(),
                MGItems.ENDERITE_MACE.get()
        );

        this.tag(ItemTags.SPEARS).add(
                MGItems.BRONZE_SPEAR.get(),
                MGItems.STEEL_SPEAR.get(),
                MGItems.RUBY_SPEAR.get(),
                MGItems.TITANIUM_SPEAR.get(),
                MGItems.ENDERITE_SPEAR.get()
        );

        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(
                MGItems.TITANIUM_MACE.get(),
                MGItems.ENDERITE_MACE.get()
        );

        this.tag(Tags.Items.TOOLS_MACE).add(
                MGItems.TITANIUM_MACE.get(),
                MGItems.ENDERITE_MACE.get()
        );

        this.tag(Tags.Items.MELEE_WEAPON_TOOLS).add(
                MGItems.BRONZE_SPEAR.get(),
                MGItems.STEEL_SPEAR.get(),
                MGItems.RUBY_SPEAR.get(),
                MGItems.TITANIUM_SPEAR.get(),
                MGItems.ENDERITE_SPEAR.get(),
                MGItems.TITANIUM_MACE.get(),
                MGItems.ENDERITE_MACE.get()
        );
    }
}
