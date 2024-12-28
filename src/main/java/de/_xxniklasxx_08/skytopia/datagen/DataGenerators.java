package de._xxniklasxx_08.skytopia.datagen;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.datagen.generators.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SkyTopia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        BlockTagsProvider blockTags = new SkyTopiaBlockTagProvider(output, provider, helper);

        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SkyTopiaItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new SkyTopiaRecipeProvider(output, provider));
        generator.addProvider(event.includeClient(), new SkyTopiaItemModelProvider(output, helper));
        generator.addProvider(event.includeServer(), new SkyTopiaBlockStateProvider(output, helper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(SkyTopiaLootTableProvider::new, LootContextParamSets.BLOCK)), provider));
        generator.addProvider(event.includeServer(), new SkyTopiaDatapackEntryProvider(output, provider));
    }

}
