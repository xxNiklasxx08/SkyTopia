package de._xxniklasxx_08.skytopia.utils.item;

import de._xxniklasxx_08.skytopia.SkyTopia;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

import java.util.Optional;

public class AnimatedItemModel<T extends AnimatedItem> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(AnimatedItem item) {
        return ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, "geo/" + getPath(item) + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem item) {
        return ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, "textures/item/" + getPath(item) + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem item) {
        return ResourceLocation.fromNamespaceAndPath(SkyTopia.MOD_ID, "animations/" + getPath(item) + ".animation.json");
    }

    private @NotNull String getPath(AnimatedItem item) {
        Optional<String> optional = BuiltInRegistries.ITEM.wrapAsHolder(item).unwrapKey().map(key -> key.location().getPath());
        return optional.orElse("[undefined]");
    }

}
