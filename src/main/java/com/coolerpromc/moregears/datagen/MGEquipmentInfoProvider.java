package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MGEquipmentInfoProvider implements DataProvider {
    private final DataOutput.PathResolver outputType;

    public MGEquipmentInfoProvider(DataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        this.outputType = dataOutput.getResolver(DataOutput.OutputType.RESOURCE_PACK, "equipment");
    }

    private void add(BiConsumer<Identifier, EquipmentModel> registrar) {
        register(registrar, "copper");
        register(registrar, "bronze");
        register(registrar, "steel");
        register(registrar, "ruby");
        register(registrar, "titanium");
        register(registrar, "enderite");
    }

    private void register(BiConsumer<Identifier, EquipmentModel> registrar, String path){
        Identifier resourceLocation = Identifier.of(MoreGears.MODID, path);

        registrar.accept(resourceLocation, EquipmentModel.builder()
                .addLayers(EquipmentModel.LayerType.HUMANOID, new EquipmentModel.Layer(resourceLocation))
                .addLayers(EquipmentModel.LayerType.HUMANOID_LEGGINGS, new EquipmentModel.Layer(resourceLocation)).build()
        );
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Map<Identifier, EquipmentModel> map = new HashMap<>();
        this.add((name, info) -> {
            if (map.putIfAbsent(name, info) != null) {
                throw new IllegalStateException("Tried to register equipment client info twice for id: " + name);
            }
        });
        return DataProvider.writeAllToPath(writer, EquipmentModel.CODEC, this.outputType, map);
    }

    @Override
    public String getName() {
        return "Equipment Client Infos: " + MoreGears.MODID;
    }
}
