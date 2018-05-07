package com.learningtomod.myfirstmod.content.blocks;

import com.learningtomod.myfirstmod.internal.content.BlockMethods;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Entity;
import com.learningtomod.myfirstmod.internal.world.Player;

public class BlockExplosive implements BlockMethods {
    @Override
    public void onRightClicked(Block block, Player player) {
        block.explode(5);
    }

    @Override
    public void onWalkedOn(Block block, Entity entity) {
        block.explode(5);
    }

    @Override
    public void onExploded(Block block) {
        block.explode(5);
    }
}
