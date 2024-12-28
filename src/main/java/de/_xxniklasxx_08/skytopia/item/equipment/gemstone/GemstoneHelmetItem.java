package de._xxniklasxx_08.skytopia.item.equipment.gemstone;

import de._xxniklasxx_08.skytopia.item.equipment.SkyTopiaArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class GemstoneHelmetItem extends ArmorItem {

    public GemstoneHelmetItem() {
        super(SkyTopiaArmorMaterial.GEMSTONE_MATERIAL, Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(48));
    }

}
