package de._xxniklasxx_08.skytopia.registry;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.enchantment.LightningEffect;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import org.jetbrains.annotations.NotNull;

public class EnchantmentRegistry {

    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = registerKey("lightning_striker");

    public static void bootstrap(@NotNull BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        register(context, LIGHTNING_STRIKER, Enchantment.enchantment(Enchantment.definition(
            items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
            items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
            5,
            1,
            Enchantment.dynamicCost(5, 8),
            Enchantment.dynamicCost(25, 8),
            2,
            EquipmentSlotGroup.MAINHAND)).exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
            .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new LightningEffect())
        );
    }

    private static void register(@NotNull BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.@NotNull Builder builder) {
        context.register(key, builder.build(key.location()));
    }

    private static @NotNull ResourceKey<Enchantment> registerKey(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name));
    }

}