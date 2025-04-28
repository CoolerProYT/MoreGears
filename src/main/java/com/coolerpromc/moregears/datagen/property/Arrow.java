package com.coolerpromc.moregears.datagen.property;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Arrow {
    public static final float COPPER = 0.1f;
    public static final float BRONZE = 0.2f;
    public static final float STEEL = 0.3f;
    public static final float RUBY = 0.4f;
    public static final float TITANIUM = 0.5f;
    public static final float ENDERITE = 0.6f;

    public static void addBowItemProperties(){
        ItemProperties.register(Items.BOW, ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.COPPER_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.BRONZE_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.STEEL_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.RUBY_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.TITANIUM_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ItemProperties.register(MGItems.ENDERITE_BOW.get(), ResourceLocation.fromNamespaceAndPath(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));

        makeCustomBow(MGItems.COPPER_BOW.get());
        makeCustomBow(MGItems.BRONZE_BOW.get());
        makeCustomBow(MGItems.STEEL_BOW.get());
        makeCustomBow(MGItems.RUBY_BOW.get());
        makeCustomBow(MGItems.TITANIUM_BOW.get());
        makeCustomBow(MGItems.ENDERITE_BOW.get());
    }

    private static float getValue(ItemStack itemStack, LivingEntity livingEntity){
        ItemStack arrowStack = livingEntity instanceof Player player ? player.getProjectile(itemStack) : ItemStack.EMPTY;

        if (arrowStack.getItem() instanceof MGArrowItem arrowItem) {
            if (arrowItem == MGItems.COPPER_ARROW.get()){
                return COPPER;
            } else if (arrowItem == MGItems.BRONZE_ARROW.get()) {
                return BRONZE;
            } else if (arrowItem == MGItems.STEEL_ARROW.get()) {
                return STEEL;
            } else if (arrowItem == MGItems.RUBY_ARROW.get()) {
                return RUBY;
            } else if (arrowItem == MGItems.TITANIUM_ARROW.get()) {
                return TITANIUM;
            } else if (arrowItem == MGItems.ENDERITE_ARROW.get()) {
                return ENDERITE;
            }
        }
        return 0.0f;
    }

    private static void makeCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }
}