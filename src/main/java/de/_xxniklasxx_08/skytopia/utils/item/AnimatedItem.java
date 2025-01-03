package de._xxniklasxx_08.skytopia.utils.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.function.Consumer;

public class AnimatedItem extends Item implements GeoItem {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public AnimatedItem(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            private AnimatedItemRenderer<AnimatedItem> renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(this.renderer == null) this.renderer = new AnimatedItemRenderer<>();
                return this.renderer;
            }

        });
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private PlayState predicate(@NotNull AnimationState<GeoAnimatable> state) {
        state.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

}
