package de._xxniklasxx_08.skytopia.item.equipment.gemstone;

import de._xxniklasxx_08.skytopia.item.equipment.SkyTopiaArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class GemstoneBootsItem extends ArmorItem {

    public GemstoneBootsItem() {
        super(SkyTopiaArmorMaterial.GEMSTONE_MATERIAL, Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(48));
    }

}
