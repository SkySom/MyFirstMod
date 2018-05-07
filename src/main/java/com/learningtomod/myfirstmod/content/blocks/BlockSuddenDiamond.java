package com.learningtomod.myfirstmod.content.blocks;

import com.learningtomod.myfirstmod.content.AllBlocks;
import com.learningtomod.myfirstmod.internal.content.BlockMethods;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Entity;
import com.learningtomod.myfirstmod.internal.world.Player;
import net.minecraft.util.EnumFacing;

public class BlockSuddenDiamond implements BlockMethods {
    @Override
    public void onRightClicked(Block block, Player player) {
        block.setTo(AllBlocks.DIAMOND_BLOCK);
    }

    @Override
    public void onWalkedOn(Block block, Entity entity) {
        block.setTo(AllBlocks.DIAMOND_BLOCK);
        block.getBlockOnSide(EnumFacing.NORTH).setTo(AllBlocks.DIAMOND_BLOCK);
    }

    @Override
    public void onExploded(Block block) {

    }
}
