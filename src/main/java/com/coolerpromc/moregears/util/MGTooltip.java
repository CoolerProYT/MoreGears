package com.coolerpromc.moregears.util;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class MGTooltip {
    public static Text itemSpecialEffect(String effect){
        return Text.literal(effect).fillStyle(Style.EMPTY.withColor(Formatting.GRAY));
    }
}
