package com.learningtomod.myfirstmod.internal.content;

import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Entity;
import com.learningtomod.myfirstmod.internal.world.Player;

public interface BlockMethods {
    void onRightClicked(Block block, Player player);

    void onWalkedOn(Block block, Entity entity);

    void onExploded(Block block);

    default boolean useDefaultModel() {
        return true;
    }
}
