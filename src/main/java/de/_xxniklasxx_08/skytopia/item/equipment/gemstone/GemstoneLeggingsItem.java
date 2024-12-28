package de._xxniklasxx_08.skytopia.item.equipment.gemstone;

import de._xxniklasxx_08.skytopia.item.equipment.SkyTopiaArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class GemstoneLeggingsItem extends ArmorItem {

    public GemstoneLeggingsItem() {
        super(SkyTopiaArmorMaterial.GEMSTONE_MATERIAL, Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(48));
    }

}
