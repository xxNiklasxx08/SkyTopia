package de._xxniklasxx_08.skytopia.registry;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.block.GemstoneOreBlock;
import de._xxniklasxx_08.skytopia.block.TransmutationBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkyTopia.MOD_ID);

    public static final RegistryObject<Block> TRANSMUTATION_BLOCK = registerBlock("transmutation_block", TransmutationBlock::new);
    public static final RegistryObject<Block> GEMSTONE_ORE = registerBlock("gemstone_ore", GemstoneOreBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> object = BLOCKS.register(name, block);
        registerBlockItem(name, object);
        return object;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}
