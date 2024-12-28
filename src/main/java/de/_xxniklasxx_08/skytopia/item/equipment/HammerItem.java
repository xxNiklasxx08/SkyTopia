package de._xxniklasxx_08.skytopia.item.equipment;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;

public class HammerItem extends DiggerItem {

    public HammerItem() {
        super(Tiers.NETHERITE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().stacksTo(1).fireResistant()
                .attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 0, -3.5F)).durability(5).rarity(Rarity.UNCOMMON));
    }

}
