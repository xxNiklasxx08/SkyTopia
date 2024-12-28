package de._xxniklasxx_08.skytopia.utils.worldgen;

import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public class OrePlacement {

    public static @NotNull @Unmodifiable List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier range) {
        return List.of(count, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    public static @NotNull @Unmodifiable List<PlacementModifier> commonOrePlacement(int count, PlacementModifier range) {
        return orePlacement(CountPlacement.of(count), range);
    }

    public static @NotNull @Unmodifiable List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier range) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), range);
    }

}