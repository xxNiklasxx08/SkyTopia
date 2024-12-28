package de._xxniklasxx_08.skytopia.registry;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.item.*;
import de._xxniklasxx_08.skytopia.item.equipment.HammerItem;
import de._xxniklasxx_08.skytopia.item.equipment.gemstone.*;
import de._xxniklasxx_08.skytopia.item.wand.ExplosionWandItem;
import de._xxniklasxx_08.skytopia.item.wand.LightningWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkyTopia.MOD_ID);

    public static final RegistryObject<Item> TIME_CHANGER = ITEMS.register("time_changer", TimeChangerItem::new);
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", ChocolateItem::new);
    public static final RegistryObject<Item> RAW_GEMSTONE = ITEMS.register("raw_gemstone", RawGemstoneItem::new);
    public static final RegistryObject<Item> POLISHED_GEMSTONE = ITEMS.register("polished_gemstone", PolishedGemstoneItem::new);
    public static final RegistryObject<Item> RIVET = ITEMS.register("rivet", RivetItem::new);
    public static final RegistryObject<Item> GEMSTONE_HELMET = ITEMS.register("gemstone_helmet", GemstoneHelmetItem::new);
    public static final RegistryObject<Item> GEMSTONE_CHESTPLATE = ITEMS.register("gemstone_chestplate", GemstoneChestplateItem::new);
    public static final RegistryObject<Item> GEMSTONE_LEGGINGS = ITEMS.register("gemstone_leggings", GemstoneLeggingsItem::new);
    public static final RegistryObject<Item> GEMSTONE_BOOTS = ITEMS.register("gemstone_boots", GemstoneBootsItem::new);
    public static final RegistryObject<Item> LIGHTNING_WAND = ITEMS.register("lightning_wand", LightningWandItem::new);
    public static final RegistryObject<Item> EXPLOSION_WAND = ITEMS.register("explosion_wand", ExplosionWandItem::new);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", HammerItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}