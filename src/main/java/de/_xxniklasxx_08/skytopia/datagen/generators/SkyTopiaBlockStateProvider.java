package de._xxniklasxx_08.skytopia.datagen.generators;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class SkyTopiaBlockStateProvider extends BlockStateProvider {

    public SkyTopiaBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, SkyTopia.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.TRANSMUTATION_BLOCK);
        blockWithItem(BlockRegistry.GEMSTONE_ORE);
    }

    private void blockWithItem(@NotNull RegistryObject<Block> registry) {
        simpleBlockWithItem(registry.get(), cubeAll(registry.get()));
    }

}
