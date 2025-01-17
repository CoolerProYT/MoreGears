package com.coolerpromc.moregears.datagen;

import com.coolerpromc.moregears.MoreGears;
import com.coolerpromc.moregears.item.MGItems;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class MGItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public MGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreGears.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        final ResourceLocation RAW_ORE = textureLoc("template_raw_ore");
        final ResourceLocation INGOT = textureLoc("template_ingot");
        final ResourceLocation GEM = textureLoc("template_gem");

        withExistingTexture(MGItems.RAW_TIN, RAW_ORE);
        withExistingTexture(MGItems.RAW_RUBY, RAW_ORE);
        withExistingTexture(MGItems.RAW_TITANIUM, RAW_ORE);
        withExistingTexture(MGItems.RAW_ENDERITE, RAW_ORE);

        withExistingTexture(MGItems.TIN_INGOT, INGOT);
        withExistingTexture(MGItems.BRONZE_INGOT, INGOT);
        withExistingTexture(MGItems.STEEL_INGOT, INGOT);
        withExistingTexture(MGItems.RUBY_INGOT, GEM);
        withExistingTexture(MGItems.TITANIUM_INGOT, INGOT);
        withExistingTexture(MGItems.ENDERITE_INGOT, INGOT);

        trimmedArmorItem(MGItems.COPPER_HELMET);
        trimmedArmorItem(MGItems.COPPER_CHESTPLATE);
        trimmedArmorItem(MGItems.COPPER_LEGGINGS);
        trimmedArmorItem(MGItems.COPPER_BOOTS);

        trimmedArmorItem(MGItems.BRONZE_HELMET);
        trimmedArmorItem(MGItems.BRONZE_CHESTPLATE);
        trimmedArmorItem(MGItems.BRONZE_LEGGINGS);
        trimmedArmorItem(MGItems.BRONZE_BOOTS);

        trimmedArmorItem(MGItems.STEEL_HELMET);
        trimmedArmorItem(MGItems.STEEL_CHESTPLATE);
        trimmedArmorItem(MGItems.STEEL_LEGGINGS);
        trimmedArmorItem(MGItems.STEEL_BOOTS);

        trimmedArmorItem(MGItems.RUBY_HELMET);
        trimmedArmorItem(MGItems.RUBY_CHESTPLATE);
        trimmedArmorItem(MGItems.RUBY_LEGGINGS);
        trimmedArmorItem(MGItems.RUBY_BOOTS);

        trimmedArmorItem(MGItems.TITANIUM_HELMET);
        trimmedArmorItem(MGItems.TITANIUM_CHESTPLATE);
        trimmedArmorItem(MGItems.TITANIUM_LEGGINGS);
        trimmedArmorItem(MGItems.TITANIUM_BOOTS);

        trimmedArmorItem(MGItems.ENDERITE_HELMET);
        trimmedArmorItem(MGItems.ENDERITE_CHESTPLATE);
        trimmedArmorItem(MGItems.ENDERITE_LEGGINGS);
        trimmedArmorItem(MGItems.ENDERITE_BOOTS);

        basicItem(MGItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(MGItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());

        handheldItem(MGItems.COPPER_SWORD);
        handheldItem(MGItems.COPPER_SHOVEL);
        handheldItem(MGItems.COPPER_PICKAXE);
        handheldItem(MGItems.COPPER_AXE);
        handheldItem(MGItems.COPPER_HOE);

        handheldItem(MGItems.BRONZE_SWORD);
        handheldItem(MGItems.BRONZE_SHOVEL);
        handheldItem(MGItems.BRONZE_PICKAXE);
        handheldItem(MGItems.BRONZE_AXE);
        handheldItem(MGItems.BRONZE_HOE);

        handheldItem(MGItems.STEEL_SWORD);
        handheldItem(MGItems.STEEL_SHOVEL);
        handheldItem(MGItems.STEEL_PICKAXE);
        handheldItem(MGItems.STEEL_AXE);
        handheldItem(MGItems.STEEL_HOE);

        handheldItem(MGItems.RUBY_SWORD);
        handheldItem(MGItems.RUBY_SHOVEL);
        handheldItem(MGItems.RUBY_PICKAXE);
        handheldItem(MGItems.RUBY_AXE);
        handheldItem(MGItems.RUBY_HOE);

        handheldItem(MGItems.TITANIUM_SWORD);
        handheldItem(MGItems.TITANIUM_SHOVEL);
        handheldItem(MGItems.TITANIUM_PICKAXE);
        handheldItem(MGItems.TITANIUM_AXE);
        handheldItem(MGItems.TITANIUM_HOE);

        handheldItem(MGItems.ENDERITE_SWORD);
        handheldItem(MGItems.ENDERITE_SHOVEL);
        handheldItem(MGItems.ENDERITE_PICKAXE);
        handheldItem(MGItems.ENDERITE_AXE);
        handheldItem(MGItems.ENDERITE_HOE);
    }

    private <T extends Item> void withExistingTexture(RegistryObject<T> item, ResourceLocation texture){
        withExistingParent("item/" + item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", texture)
                .element().from(0, 0, 0).to(16, 16, 16)
                .face(Direction.DOWN).texture("#layer0").tintindex(0).end()
                .face(Direction.UP).texture("#layer0").tintindex(0).end()
                .face(Direction.NORTH).texture("#layer0").tintindex(0).end()
                .face(Direction.SOUTH).texture("#layer0").tintindex(0).end()
                .face(Direction.WEST).texture("#layer0").tintindex(0).end()
                .face(Direction.EAST).texture("#layer0").tintindex(0).end()
                .end();
    }

    private <T extends Item> ItemModelBuilder handheldItem(RegistryObject<T> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MoreGears.MODID,"item/" + item.getId().getPath()));
    }

    private ResourceLocation textureLoc(String location){
        return this.modLoc("item/" + location);
    }

    private <T extends Item> void trimmedArmorItem(RegistryObject<T> itemRegistryObject) {
        final String MOD_ID = MoreGears.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
