package de._xxniklasxx_08.skytopia.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TimeChangerItem extends Item {

    public TimeChangerItem() {
        super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        player.startUsingItem(hand);
        if(!(level.isClientSide() && hand == InteractionHand.MAIN_HAND)) {
            long time = (level.getDayTime() % 24000L + 24000L) % 24000L;
            if(time >= 13000L && time < 23000L) ((ServerLevel) level).setDayTime(1000L);
            else ((ServerLevel) level).setDayTime(18000L);
        }
        return InteractionResultHolder.consume(player.getItemBySlot(EquipmentSlot.MAINHAND));
    }

    @Override
    public int getUseDuration(@NotNull ItemStack item, @NotNull LivingEntity entity) {
        return 48;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack item) {
        return UseAnim.SPEAR;
    }

}
