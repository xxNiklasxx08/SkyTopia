package de._xxniklasxx_08.skytopia.worldgen;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.utils.worldgen.OrePlacement;
import de._xxniklasxx_08.skytopia.worldgen.placed.bammboo_grove.BambooGroveBamboo;
import de._xxniklasxx_08.skytopia.worldgen.placed.bammboo_grove.BambooGroveTrees;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlacedFeatures {

    public static final ResourceKey<PlacedFeature> GEMSTONE_ORE_PLACED = registerKey("gemstone_ore_placed");
    public static final ResourceKey<PlacedFeature> BASIC_CHERRY_TREE_PLACED = registerKey("basic_cherry_tree_placed");
    public static final ResourceKey<PlacedFeature> BIG_CHERRY_TREE_PLACED = registerKey("big_cherry_tree_placed");
    public static final ResourceKey<PlacedFeature> BAMBOO_PLACED = registerKey("bamboo_placed");

    public static void bootstrap(@NotNull BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, GEMSTONE_ORE_PLACED, features.getOrThrow(ConfiguredFeatures.GEMSTONE_ORE),
            OrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, BASIC_CHERRY_TREE_PLACED, features.getOrThrow(ConfiguredFeatures.BASIC_CHERRY_TREE), BambooGroveTrees.placed());
        register(context, BIG_CHERRY_TREE_PLACED, features.getOrThrow(ConfiguredFeatures.BIG_CHERRY_TREE), BambooGroveTrees.placed());

        register(context, BAMBOO_PLACED, features.getOrThrow(VegetationFeatures.BAMBOO_SOME_PODZOL), BambooGroveBamboo.placed());
    }

    private static void register(@NotNull BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    private static @NotNull ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name));
    }

}