package de._xxniklasxx_08.skytopia.datagen.generators;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SkyTopiaItemTagProvider extends ItemTagsProvider {

    public SkyTopiaItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blocks, @Nullable ExistingFileHelper helper) {
        super(output, provider, blocks, SkyTopia.MOD_ID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
            .add(ItemRegistry.GEMSTONE_HELMET.get())
            .add(ItemRegistry.GEMSTONE_CHESTPLATE.get())
            .add(ItemRegistry.GEMSTONE_LEGGINGS.get())
            .add(ItemRegistry.GEMSTONE_BOOTS.get());
    }

}
