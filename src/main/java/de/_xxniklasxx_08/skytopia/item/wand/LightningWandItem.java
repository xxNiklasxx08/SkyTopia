package de._xxniklasxx_08.skytopia.item.wand;

import de._xxniklasxx_08.skytopia.utils.item.AnimatedItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class LightningWandItem extends AnimatedItem {

    public LightningWandItem() {
        super(new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        if(context.getLevel().isClientSide()) return InteractionResult.FAIL;
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(context.getLevel());
        if(bolt != null) {
            bolt.moveTo(context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
            context.getLevel().addFreshEntity(bolt);
        }
        return InteractionResult.SUCCESS;
    }

}
