package de._xxniklasxx_08.skytopia.worldgen.configured.trees;

import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BasicCherryTreeConfiguration {

    public static @NotNull TreeConfiguration configure() {
         return new TreeConfiguration.TreeConfigurationBuilder(
             BlockStateProvider.simple(Blocks.CHERRY_WOOD),

             new CherryTrunkPlacer(8, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                 .add(ConstantInt.of(1), 1)
                 .add(ConstantInt.of(2), 1)
                 .add(ConstantInt.of(3), 1)
                 .build()
             ), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)),

             BlockStateProvider.simple(Blocks.CHERRY_LEAVES),

             new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5),
                 0.25F, 0.25F, 0.16F, 0.3F),

             new TwoLayersFeatureSize(1, 0, 2)
         ).decorators(List.of(
             new BeehiveDecorator(0.05F)
         )).dirt(BlockStateProvider.simple(Blocks.DIRT)).ignoreVines().build();
    }

}