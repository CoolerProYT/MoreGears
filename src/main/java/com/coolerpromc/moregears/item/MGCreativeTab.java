package com.coolerpromc.moregears.item;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.block.MGBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

public class MGCreativeTab {
    public static final ItemGroup MG_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreGears.MODID, "more_gears"),
            FabricItemGroup.builder().icon(() -> new ItemStack(MGItems.COPPER_SWORD))
                    .displayName(Text.translatable("itemGroup.moregears"))
                    .entries((displayContext, entries) -> {
                        for (Field field : MGBlocks.class.getFields()){
                            try{
                                if (Block.class.isAssignableFrom(field.getType())){
                                    Block block = (Block) field.get(null);
                                    entries.add(block);
                                }
                            }
                            catch (IllegalAccessException e){
                                e.printStackTrace();
                            }
                        }

                        for (Field field : MGItems.class.getFields()){
                            try{
                                if (Item.class.isAssignableFrom(field.getType())){
                                    Item item = (Item) field.get(null);
                                    entries.add(item);
                                }
                            }
                            catch (IllegalAccessException e){
                                e.printStackTrace();
                            }
                        }
                    }).build());

    public static void init() {

    }
}
