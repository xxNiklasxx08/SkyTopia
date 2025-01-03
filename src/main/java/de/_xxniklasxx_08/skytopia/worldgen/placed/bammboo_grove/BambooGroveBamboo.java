package de._xxniklasxx_08.skytopia.worldgen.placed.bammboo_grove;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BambooGroveBamboo {

    public static @NotNull List<PlacementModifier> placed() {
        List<PlacementModifier> placement = new ArrayList<>();

        placement.add(NoiseThresholdCountPlacement.of(-0.8, 1, 3));
        placement.add(new InSquarePlacement());
        placement.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
        placement.add(BiomeFilter.biome());

        return placement;
    }

}