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

public class BigCherryTreeConfiguration {

    public static @NotNull TreeConfiguration configure() {
        return new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(Blocks.CHERRY_WOOD),

            new CherryTrunkPlacer(9, 3, 1, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                .add(ConstantInt.of(1), 1)
                .add(ConstantInt.of(2), 1)
                .add(ConstantInt.of(3), 1)
                .build()
            ), UniformInt.of(2, 6), UniformInt.of(-6, -3), UniformInt.of(-1, 0)),

            BlockStateProvider.simple(Blocks.CHERRY_LEAVES),

            new CherryFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), ConstantInt.of(4),
                0F, 0.33F, 0.33F, 0.34F),

            new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(List.of(
            new BeehiveDecorator(0.05F)
        )).ignoreVines().build();
    }

}