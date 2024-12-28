package de._xxniklasxx_08.skytopia.utils.item;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer<T extends AnimatedItem> extends GeoItemRenderer<T> {

    public AnimatedItemRenderer() {
        super(new AnimatedItemModel<>());
    }

}
