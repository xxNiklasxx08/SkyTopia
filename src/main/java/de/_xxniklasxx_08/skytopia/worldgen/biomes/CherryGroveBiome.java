package de._xxniklasxx_08.skytopia.worldgen.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeSpecialEffectsBuilder;
import org.jetbrains.annotations.NotNull;

public class CherryGroveBiome {

    public static @NotNull Biome create(HolderGetter<PlacedFeature> placed, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeSpecialEffects effects = BiomeSpecialEffectsBuilder.create(12638463, 6141935, 6141935, 8103167)
            .grassColorOverride(8050773)
            .foliageColorOverride(12181596)
            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
            .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE))
            .build();

        MobSpawnSettings spawn = new MobSpawnSettings.Builder()
            .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 1, 8, 8))
            .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 2, 6))
            .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 2, 4))
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 95, 4, 4))
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 100, 4, 4))
            .addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6))
            .build();

        BiomeGenerationSettings settings = new BiomeGenerationSettings.Builder(placed, carvers)
            .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
            .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
            .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_DIRT)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_GRAVEL)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_TUFF)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_LOWER)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_UPPER)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_LOWER)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_UPPER)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_LOWER)
            .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_UPPER)
            .build();

        return new Biome.BiomeBuilder()
            .temperature(0.8F)
            .downfall(0.8F)
            .hasPrecipitation(true)
            .specialEffects(effects)
            .mobSpawnSettings(spawn)
            .generationSettings(settings)
            .build();
    }

}