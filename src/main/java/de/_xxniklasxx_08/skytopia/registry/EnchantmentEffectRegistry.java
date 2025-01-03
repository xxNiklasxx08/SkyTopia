package de._xxniklasxx_08.skytopia.registry;

import com.mojang.serialization.MapCodec;
import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.enchantment.LightningEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentEffectRegistry {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> EFFECTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, SkyTopia.MOD_ID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> LIGHTNING = EFFECTS.register("lightning_effect", () -> LightningEffect.CODEC);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

}