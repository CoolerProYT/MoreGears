package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MGEquipmentInfoProvider implements DataProvider {
    private final PackOutput.PathProvider outputType;

    public MGEquipmentInfoProvider(PackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        this.outputType = dataOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private void add(BiConsumer<Identifier, EquipmentClientInfo> registrar) {
        register(registrar, "bronze");
        register(registrar, "steel");
        register(registrar, "ruby");
        register(registrar, "titanium");
        register(registrar, "enderite");
    }

    private void register(BiConsumer<Identifier, EquipmentClientInfo> registrar, String path){
        Identifier resourceLocation = Identifier.fromNamespaceAndPath(MoreGears.MODID, path);

        registrar.accept(resourceLocation, EquipmentClientInfo.builder()
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(resourceLocation))
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(resourceLocation)).build()
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        Map<Identifier, EquipmentClientInfo> map = new HashMap<>();
        this.add((name, info) -> {
            if (map.putIfAbsent(name, info) != null) {
                throw new IllegalStateException("Tried to register equipment client info twice for id: " + name);
            }
        });
        return DataProvider.saveAll(writer, EquipmentClientInfo.CODEC, this.outputType, map);
    }

    @Override
    public String getName() {
        return "Equipment Client Infos: " + MoreGears.MODID;
    }
}
