package com.learningtomod.myfirstmod.internal.content;

import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Item;
import com.learningtomod.myfirstmod.internal.world.Player;

public interface ItemMethods {
    void onRightClickBlock(Item item, Block block, Player player);

    void onRightClick(Item item, Player player);
}
