package de._xxniklasxx_08.skytopia.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantingTableBlock.class)
public class EnchantingTableBlockMixin {

    @Inject(method = "useWithoutItem", at = @At("HEAD"), cancellable = true)
    public void interact(BlockState state, @NotNull Level level, BlockPos pos, Player player, BlockHitResult result, @NotNull CallbackInfoReturnable<InteractionResult> info) {
        info.cancel();
        if(level.isClientSide()) info.setReturnValue(InteractionResult.SUCCESS);
        else {
            player.sendSystemMessage(Component.translatable("message.enchanting_table.disabled").withColor(0xff5555));
            info.setReturnValue(InteractionResult.CONSUME);
        }
    }

}