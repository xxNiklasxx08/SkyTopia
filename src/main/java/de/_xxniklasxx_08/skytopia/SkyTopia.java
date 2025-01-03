package de._xxniklasxx_08.skytopia;

import de._xxniklasxx_08.skytopia.registry.BlockRegistry;
import de._xxniklasxx_08.skytopia.registry.CreativeModeRegistry;
import de._xxniklasxx_08.skytopia.registry.EnchantmentEffectRegistry;
import de._xxniklasxx_08.skytopia.registry.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SkyTopia.MOD_ID)
public class SkyTopia {

    public static final String MOD_ID = "skytopia";

    public SkyTopia() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
        EnchantmentEffectRegistry.register(eventBus);
        CreativeModeRegistry.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}