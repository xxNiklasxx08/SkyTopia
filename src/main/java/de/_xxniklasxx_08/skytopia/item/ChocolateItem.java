package de._xxniklasxx_08.skytopia.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ChocolateItem extends Item {

    public ChocolateItem() {
        super(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3F)
                .alwaysEdible().usingConvertsTo(Items.PAPER).build()));
    }

}
