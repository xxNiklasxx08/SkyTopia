package de._xxniklasxx_08.skytopia.block;

import de._xxniklasxx_08.skytopia.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class TransmutationBlock extends Block {

    public TransmutationBlock() {
        super(BlockBehaviour.Properties.of().strength(2F).requiresCorrectToolForDrops());
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult result) {
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1F, 1F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        if(level.isClientSide()) return;
        if(entity instanceof Player player) player.hurt(level.damageSources().magic(), 10F);
        else if(entity instanceof ItemEntity item) {
            if(item.getItem().getItem() != ItemRegistry.RAW_GEMSTONE.get()) return;
            item.setItem(new ItemStack(Items.DIAMOND, item.getItem().getCount()));
        }
    }

}
