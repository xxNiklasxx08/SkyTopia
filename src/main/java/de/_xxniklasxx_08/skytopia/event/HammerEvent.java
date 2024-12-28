package de._xxniklasxx_08.skytopia.event;

import de._xxniklasxx_08.skytopia.SkyTopia;
import de._xxniklasxx_08.skytopia.item.equipment.HammerItem;
import de._xxniklasxx_08.skytopia.utils.math.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SkyTopia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HammerEvent {

    private static final Set<BlockPos> MINED = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(@NotNull BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getMainHandItem();
        if(!(item.getItem() instanceof HammerItem hammer)) return;
        if(!(player instanceof ServerPlayer server)) return;
        BlockPos position = event.getPos();
        if(MINED.contains(position)) return;
        for(BlockPos pos : MathUtils.getBlocksToDestroy(1, position, server)) {
            if(pos == position || !(hammer.isCorrectToolForDrops(item, event.getLevel().getBlockState(pos)))) continue;
            MINED.add(pos);
            server.gameMode.destroyBlock(pos);
            MINED.remove(pos);
        }
    }

}
