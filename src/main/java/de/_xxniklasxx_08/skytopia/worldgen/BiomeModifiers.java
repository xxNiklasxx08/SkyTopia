package de._xxniklasxx_08.skytopia.worldgen;

import de._xxniklasxx_08.skytopia.SkyTopia;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class BiomeModifiers {

    public static final ResourceKey<BiomeModifier> GEMSTONE_ORE_MODIFIER = registerKey("gemstone_ore_modifier");

    public static void bootstrap(@NotNull BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biome = context.lookup(Registries.BIOME);

        context.register(GEMSTONE_ORE_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biome.getOrThrow(BiomeTags.IS_OVERWORLD),
            HolderSet.direct(placed.getOrThrow(PlacedFeatures.GEMSTONE_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static @NotNull ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, name));
    }

}