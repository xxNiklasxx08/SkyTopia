package de._xxniklasxx_08.skytopia.datagen.generators;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.worldgen.BiomeModifiers;
import de._xxniklasxx_08.skytopia.worldgen.Biomes;
import de._xxniklasxx_08.skytopia.worldgen.ConfiguredFeatures;
import de._xxniklasxx_08.skytopia.worldgen.PlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SkyTopiaDatapackEntryProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::bootstrap)
        .add(Registries.BIOME, Biomes::bootstrap);

    public SkyTopiaDatapackEntryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SkyTopia.MOD_ID));
    }

}
