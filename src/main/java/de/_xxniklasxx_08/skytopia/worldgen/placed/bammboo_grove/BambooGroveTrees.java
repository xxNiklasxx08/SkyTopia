package de._xxniklasxx_08.skytopia.worldgen.placed.bammboo_grove;

import net.minecraft.core.Vec3i;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BambooGroveTrees {

    public static @NotNull List<PlacementModifier> placed() {
        List<PlacementModifier> placements = new ArrayList<>();
        placements.add(CountPlacement.of(BiasedToBottomInt.of(3, 9)));
        placements.add(new InSquarePlacement());
        // TODO: surface_water_depth_filter
        placements.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE));
        placements.add(BiomeFilter.biome());
        placements.add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.CHERRY_SAPLING.defaultBlockState(), Vec3i.ZERO)));
        return placements;
    }

}