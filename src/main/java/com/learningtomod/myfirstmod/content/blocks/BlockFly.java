package com.learningtomod.myfirstmod.content.blocks;

import com.learningtomod.myfirstmod.internal.content.BlockMethods;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Entity;
import com.learningtomod.myfirstmod.internal.world.Player;

public class BlockFly implements BlockMethods {

    @Override
    public void onRightClicked(Block block, Player player) {

    }

    @Override
    public void onWalkedOn(Block block, Entity entity) {
        entity.setNoGravity(true);
    }

    @Override
    public void onExploded(Block block) {

    }
}
