package de._xxniklasxx_08.skytopia.datagen.generators;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public class SkyTopiaItemModelProvider extends ItemModelProvider {

    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trims = new LinkedHashMap<>();

    public SkyTopiaItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, SkyTopia.MOD_ID, helper);
        trims.put(TrimMaterials.QUARTZ, 0.1F);
        trims.put(TrimMaterials.IRON, 0.2F);
        trims.put(TrimMaterials.NETHERITE, 0.3F);
        trims.put(TrimMaterials.REDSTONE, 0.4F);
        trims.put(TrimMaterials.COPPER, 0.5F);
        trims.put(TrimMaterials.GOLD, 0.6F);
        trims.put(TrimMaterials.EMERALD, 0.7F);
        trims.put(TrimMaterials.DIAMOND, 0.8F);
        trims.put(TrimMaterials.LAPIS, 0.9F);
        trims.put(TrimMaterials.AMETHYST, 1F);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemRegistry.TIME_CHANGER.get());
        basicItem(ItemRegistry.CHOCOLATE.get());
        basicItem(ItemRegistry.RAW_GEMSTONE.get());
        basicItem(ItemRegistry.POLISHED_GEMSTONE.get());
        basicItem(ItemRegistry.RIVET.get());
        basicItem(ItemRegistry.HAMMER.get());
        trimmedArmorItem(ItemRegistry.GEMSTONE_HELMET);
        trimmedArmorItem(ItemRegistry.GEMSTONE_CHESTPLATE);
        trimmedArmorItem(ItemRegistry.GEMSTONE_LEGGINGS);
        trimmedArmorItem(ItemRegistry.GEMSTONE_BOOTS);
    }

    private void trimmedArmorItem(@NotNull RegistryObject<Item> item) {
        if(!(item.get() instanceof ArmorItem armor)) return;
        trims.forEach((material, value) -> {
            String type = switch(armor.getEquipmentSlot()) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "";
            };
            String itemPath = armor.toString();
            String trimPath = "trims/items/" + type + "_trim_" + material.location().getPath();
            String currentTrim = itemPath + "_" + material.location().getPath() + "_trim";
            ResourceLocation itemLocation = ResourceLocation.parse(itemPath);
            ResourceLocation trimLocation = ResourceLocation.parse(trimPath);
            ResourceLocation currentLocation = ResourceLocation.parse(currentTrim);
            existingFileHelper.trackGenerated(trimLocation, PackType.CLIENT_RESOURCES, ".png", "textures");
            getBuilder(currentTrim).parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", itemLocation.getNamespace() + ":item/" + itemLocation.getPath())
                    .texture("layer1", trimLocation);
            this.withExistingParent(item.getId().getPath(), mcLoc("item/generated")).override()
                    .model(new ModelFile.UncheckedModelFile(currentLocation.getNamespace() + ":item/" + currentLocation.getPath()))
                    .predicate(mcLoc("trim_type"), value).end()
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, "item/" + item.getId().getPath()));
        });
    }

}