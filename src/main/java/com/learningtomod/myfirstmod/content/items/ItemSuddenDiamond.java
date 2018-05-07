package com.learningtomod.myfirstmod.content.items;

import com.learningtomod.myfirstmod.content.AllBlocks;
import com.learningtomod.myfirstmod.internal.content.ItemMethods;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Item;
import com.learningtomod.myfirstmod.internal.world.Player;

public class ItemSuddenDiamond implements ItemMethods {
    @Override
    public void onRightClickBlock(Item item, Block block, Player player) {
        block.setTo(AllBlocks.DIAMOND_BLOCK);
        item.reduceStack(1);
    }

    @Override
    public void onRightClick(Item item, Player player) {

    }
}
