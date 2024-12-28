package de._xxniklasxx_08.skytopia.datagen.generators;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SkyTopiaBlockTagProvider extends BlockTagsProvider {

    public SkyTopiaBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, SkyTopia.MOD_ID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BlockRegistry.TRANSMUTATION_BLOCK.get())
            .add(BlockRegistry.IRON_PLATE_BLOCK.get())
            .add(BlockRegistry.GEMSTONE_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(BlockRegistry.TRANSMUTATION_BLOCK.get())
            .add(BlockRegistry.GEMSTONE_ORE.get());
    }

}