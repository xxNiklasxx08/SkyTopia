package de._xxniklasxx_08.skytopia.item.wand;

import de._xxniklasxx_08.skytopia.utils.item.AnimatedItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ExplosionWandItem extends AnimatedItem {

    public ExplosionWandItem() {
        super(new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext content) {
        if(content.getLevel().isClientSide()) return InteractionResult.FAIL;
        BlockPos pos = content.getClickedPos();
        content.getLevel().explode(null, pos.getX(), pos.getY(), pos.getZ(), 7.5F, Level.ExplosionInteraction.TNT);
        return InteractionResult.SUCCESS;
    }

}
