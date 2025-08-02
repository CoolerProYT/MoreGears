package com.coolerpromc.moregears.datagen.property;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.item.custom.MGArrowItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Arrow {
    public static final float COPPER = 0.1f;
    public static final float BRONZE = 0.2f;
    public static final float STEEL = 0.3f;
    public static final float RUBY = 0.4f;
    public static final float TITANIUM = 0.5f;
    public static final float ENDERITE = 0.6f;

    public static void addBowItemProperties(){
        ModelPredicateProviderRegistry.register(Items.BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.COPPER_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.BRONZE_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.STEEL_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.RUBY_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.TITANIUM_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));
        ModelPredicateProviderRegistry.register(MGItems.ENDERITE_BOW, Identifier.of(MoreGears.MODID, "select_arrow"), (itemStack, clientLevel, livingEntity, i) -> getValue(itemStack, livingEntity));

        makeCustomBow(MGItems.COPPER_BOW);
        makeCustomBow(MGItems.BRONZE_BOW);
        makeCustomBow(MGItems.STEEL_BOW);
        makeCustomBow(MGItems.RUBY_BOW);
        makeCustomBow(MGItems.TITANIUM_BOW);
        makeCustomBow(MGItems.ENDERITE_BOW);
    }

    private static float getValue(ItemStack itemStack, LivingEntity livingEntity){
        ItemStack arrowStack = livingEntity instanceof PlayerEntity player ? player.getProjectileType(itemStack) : ItemStack.EMPTY;

        if (arrowStack.getItem() instanceof MGArrowItem arrowItem) {
            if (arrowItem == MGItems.COPPER_ARROW){
                return COPPER;
            } else if (arrowItem == MGItems.BRONZE_ARROW) {
                return BRONZE;
            } else if (arrowItem == MGItems.STEEL_ARROW) {
                return STEEL;
            } else if (arrowItem == MGItems.RUBY_ARROW) {
                return RUBY;
            } else if (arrowItem == MGItems.TITANIUM_ARROW) {
                return TITANIUM;
            } else if (arrowItem == MGItems.ENDERITE_ARROW) {
                return ENDERITE;
            }
        }
        return 0.0f;
    }

    private static void makeCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getActiveItem() != p_344163_ ? 0.0F : (float)(p_344163_.getMaxUseTime(p_344165_) - p_344165_.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getActiveItem() == p_174630_ ? 1.0F : 0.0F
        );
    }
}