package de._xxniklasxx_08.skytopia.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GemstoneOreBlock extends Block {

    public GemstoneOreBlock() {
        super(BlockBehaviour.Properties.of().strength(1.5F).requiresCorrectToolForDrops());
    }

}
