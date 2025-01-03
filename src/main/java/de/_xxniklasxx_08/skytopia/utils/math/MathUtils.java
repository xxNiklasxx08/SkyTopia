package de._xxniklasxx_08.skytopia.utils.math;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    public static @NotNull List<BlockPos> getBlocksToDestroy(int range, BlockPos center, @NotNull ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        BlockHitResult result = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1F).add(player.getViewVector(1F).scale(6F))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if(result.getType() == HitResult.Type.MISS) return positions;

        if(result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) {
            for(int x = -range; x <= range; x++) for(int z = -range; z <= range; z++) {
                BlockPos pos = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                positions.add(pos);
            }
        }

        if(result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) {
            for(int x = -range; x <= range; x++) for(int y = -range; y <= range; y++) {
                BlockPos pos = new BlockPos(center.getX() + x, center.getY() + y, center.getZ());
                positions.add(pos);
            }
        }

        if(result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) {
            for(int y = -range; y <= range; y++) for(int z = -range; z <= range; z++) {
                BlockPos pos = new BlockPos(center.getX(), center.getY() + y, center.getZ() + z);
                positions.add(pos);
            }
        }

        return positions;
    }

}
