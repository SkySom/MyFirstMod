package com.learningtomod.myfirstmod.content.items;

import com.learningtomod.myfirstmod.internal.content.ItemMethods;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Item;
import com.learningtomod.myfirstmod.internal.world.Player;

public class ItemFly implements ItemMethods {
    @Override
    public void onRightClickBlock(Item item, Block block, Player player) {

    }

    @Override
    public void onRightClick(Item item, Player player) {
        player.setNoGravity(!player.getNoGravity());
    }
}
