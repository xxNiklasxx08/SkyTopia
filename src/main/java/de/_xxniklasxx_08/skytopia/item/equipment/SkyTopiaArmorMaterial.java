package de._xxniklasxx_08.skytopia.item.equipment;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.ItemRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class SkyTopiaArmorMaterial {

    public static final Holder<ArmorMaterial> GEMSTONE_MATERIAL = register("gemstone", Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
        attribute.put(ArmorItem.Type.BOOTS, 5);
        attribute.put(ArmorItem.Type.LEGGINGS, 8);
        attribute.put(ArmorItem.Type.CHESTPLATE, 10);
        attribute.put(ArmorItem.Type.HELMET, 5);
        attribute.put(ArmorItem.Type.BODY, 15);
    }), 15, 5F, 0.3F, ItemRegistry.RAW_GEMSTONE);

    private static @NotNull Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> protection, int enchant, float thoughness, float knockback, Supplier<Item> ingredient) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name);
        Holder<SoundEvent> sound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredients = () -> Ingredient.of(ingredient.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(protection, enchant, sound, ingredients, layers, thoughness, knockback));
    }

}
