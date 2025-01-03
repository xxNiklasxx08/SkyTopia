package de._xxniklasxx_08.skytopia.worldgen.configured.ore;

import de._xxniklasxx_08.skytopia.registry.BlockRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GemstoneOreConfiguration {

    public static @NotNull OreConfiguration configure() {
        RuleTest replaceableStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> gemstoneOres = List.of(OreConfiguration.target(replaceableStone, BlockRegistry.GEMSTONE_ORE.get().defaultBlockState()));
        return new OreConfiguration(gemstoneOres, 3);
    }

}