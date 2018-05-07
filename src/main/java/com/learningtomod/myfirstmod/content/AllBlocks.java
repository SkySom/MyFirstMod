package com.learningtomod.myfirstmod.content;

import com.learningtomod.myfirstmod.internal.world.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AllBlocks {
    public static final Block DIAMOND_BLOCK = new Block(Blocks.DIAMOND_BLOCK.getDefaultState());
    public static final Block EMERALD_BLOCK = new Block(Blocks.EMERALD_BLOCK.getDefaultState());
    public static final Block IRON_BLOCK = new Block(Blocks.IRON_BLOCK.getDefaultState());
    public static final Block GOLD_BLOCK = new Block(Blocks.GOLD_BLOCK.getDefaultState());
    public static final Block AIR = new Block(Blocks.AIR.getDefaultState());

    public static Block getBlock(String name) {
        return new Block(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(name)).getDefaultState());
    }
}
