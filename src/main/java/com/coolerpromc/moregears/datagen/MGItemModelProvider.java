package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MGItemModelProvider extends ItemModelProvider {
    public MGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreGears.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
