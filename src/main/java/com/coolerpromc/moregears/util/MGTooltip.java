package com.coolerpromc.moregears.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

public class MGTooltip {
    public static Component itemSpecialEffect(String effect){
        return Component.literal(effect).withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));
    }
}
