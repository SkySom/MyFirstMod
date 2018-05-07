package com.learningtomod.myfirstmod.internal.world;

import net.minecraft.item.ItemStack;

public class Item {
    private ItemStack itemStack;

    public Item(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void reduceStack(int amount) {
        itemStack.shrink(amount);
    }

    public void growStack(int amount) {
        itemStack.grow(amount);
    }
}
