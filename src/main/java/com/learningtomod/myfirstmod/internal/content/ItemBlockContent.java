package com.learningtomod.myfirstmod.internal.content;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemBlockContent extends ItemBlock {
    private BlockContent blockContent;

    public ItemBlockContent(BlockContent block) {
        super(block);
        this.blockContent = block;
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName(), "Somehow created a block with a null registry name"));
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack) {
        return this.blockContent.getLocalizedName();
    }

}
