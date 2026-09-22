package com.coolerpromc.moregears.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;

public class MGShieldItem extends ShieldItem {
    public MGShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getName(ItemStack itemStack) {
        DyeColor baseColor = itemStack.get(DataComponents.BASE_COLOR);
        if (baseColor == null) {
            return super.getName(itemStack);
        }

        return Component.translatable(this.getDescriptionId() + ".colored", Component.translatable("color.minecraft." + baseColor.getName()));
    }
}
