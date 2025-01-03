package de._xxniklasxx_08.skytopia.worldgen;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.worldgen.configured.trees.BasicCherryTreeConfiguration;
import de._xxniklasxx_08.skytopia.worldgen.configured.ore.GemstoneOreConfiguration;
import de._xxniklasxx_08.skytopia.worldgen.configured.trees.BigCherryTreeConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GEMSTONE_ORE = registerKey("gemstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BASIC_CHERRY_TREE = registerKey("basic_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_CHERRY_TREE = registerKey("big_cherry_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, GEMSTONE_ORE, Feature.ORE, GemstoneOreConfiguration.configure());
        register(context, BASIC_CHERRY_TREE, Feature.TREE, BasicCherryTreeConfiguration.configure());
        register(context, BIG_CHERRY_TREE, Feature.TREE, BigCherryTreeConfiguration.configure());
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
        @NotNull BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static @NotNull ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name));
    }

}