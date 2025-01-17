package com.coolerpromc.moregears.recipe;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MGRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MoreGears.MODID);

    public static final RegistryObject<RecipeSerializer<AlloySmeltingRecipe>> ALLOY_SMELTING_SERIALIZER = SERIALIZERS.register("alloy_smelting", () -> AlloySmeltingRecipe.Serializer.INSTANCE);
    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
