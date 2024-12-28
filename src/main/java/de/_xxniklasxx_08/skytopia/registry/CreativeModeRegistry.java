package de._xxniklasxx_08.skytopia.registry;

import de._xxniklasxx_08.skytopia.SkyTopia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeRegistry {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkyTopia.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEMS = TABS.register("skytopia_items", () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ItemRegistry.RAW_GEMSTONE.get())).title(Component.translatable("skytopia.tab.items"))
        .displayItems((parameters, output) -> {
            output.accept(ItemRegistry.CHOCOLATE.get());
            output.accept(ItemRegistry.RAW_GEMSTONE.get());
            output.accept(ItemRegistry.RIVET.get());
        }).build());

    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register("skytopia_blocks", () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(BlockRegistry.TRANSMUTATION_BLOCK.get())).title(Component.translatable("skytopia.tab.blocks"))
        .displayItems(((parameters, output) -> {
            output.accept(BlockRegistry.TRANSMUTATION_BLOCK.get());
            output.accept(BlockRegistry.IRON_PLATE_BLOCK.get());
            output.accept(BlockRegistry.GEMSTONE_ORE.get());
        })).build());

    public static final RegistryObject<CreativeModeTab> EQUIPMENT = TABS.register("skytopia_equipment", () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ItemRegistry.GEMSTONE_CHESTPLATE.get())).title(Component.translatable("skytopia.tab.equipment"))
        .displayItems((parameters, output) -> {
            output.accept(ItemRegistry.TIME_CHANGER.get());
            output.accept(ItemRegistry.LIGHTNING_WAND.get());
            output.accept(ItemRegistry.EXPLOSION_WAND.get());
            output.accept(ItemRegistry.HAMMER.get());
            output.accept(ItemRegistry.GEMSTONE_HELMET.get());
            output.accept(ItemRegistry.GEMSTONE_CHESTPLATE.get());
            output.accept(ItemRegistry.GEMSTONE_LEGGINGS.get());
            output.accept(ItemRegistry.GEMSTONE_BOOTS.get());
        }).build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

}
