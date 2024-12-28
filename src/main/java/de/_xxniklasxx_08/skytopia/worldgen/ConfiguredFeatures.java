package de._xxniklasxx_08.skytopia.worldgen;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GEMSTONE_ORE = registerKey("gemstone_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest replaceableStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> gemstoneOres = List.of(OreConfiguration.target(replaceableStone, BlockRegistry.GEMSTONE_ORE.get().defaultBlockState()));

        register(context, GEMSTONE_ORE, Feature.ORE, new OreConfiguration(gemstoneOres, 3));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
        @NotNull BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static @NotNull ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name));
    }

}