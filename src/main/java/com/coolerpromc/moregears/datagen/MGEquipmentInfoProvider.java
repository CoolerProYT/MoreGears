package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MGEquipmentInfoProvider implements DataProvider {
    private final PackOutput.PathProvider path;

    public MGEquipmentInfoProvider(PackOutput output) {
        this.path = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private void add(BiConsumer<Identifier, EquipmentClientInfo> registrar) {
        register(registrar, "copper");
        register(registrar, "bronze");
        register(registrar, "steel");
        register(registrar, "ruby");
        register(registrar, "titanium");
        register(registrar, "enderite");
    }

    private void register(BiConsumer<Identifier, EquipmentClientInfo> registrar, String path){
        Identifier identifier = Identifier.fromNamespaceAndPath(MoreGears.MODID, path);

        registrar.accept(identifier, EquipmentClientInfo.builder()
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(identifier))
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(identifier)).build()
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        Map<Identifier, EquipmentClientInfo> map = new HashMap<>();
        this.add((name, info) -> {
            if (map.putIfAbsent(name, info) != null) {
                throw new IllegalStateException("Tried to register equipment client info twice for id: " + name);
            }
        });
        return DataProvider.saveAll(cachedOutput, EquipmentClientInfo.CODEC, this.path, map);
    }

    @Override
    public String getName() {
        return "Equipment Client Infos: " + MoreGears.MODID;
    }
}
