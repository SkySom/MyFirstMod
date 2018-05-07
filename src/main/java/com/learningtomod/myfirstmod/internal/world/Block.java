package com.learningtomod.myfirstmod.internal.world;

import com.learningtomod.myfirstmod.MyFirstMod;
import com.learningtomod.myfirstmod.content.AllBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Block {
    private IBlockState blockState;
    private BlockPos blockPos;
    private World world;

    private boolean inWorld;

    public Block(IBlockState blockState) {
        this.blockState = blockState;
        this.inWorld = false;
    }

    public Block(IBlockState blockState, @Nullable BlockPos blockPos, @Nullable World world) {
        this.blockState = blockState;
        this.blockPos = blockPos;
        this.world = world;
        this.inWorld = true;
    }

    public void explode(int power) {
        if (inWorld) {
            world.createExplosion(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), power, true);
        } else {
            MyFirstMod.LOGGER.error("Block is not in the world! Can't Explode");
        }
    }

    public void setTo(Block otherBlock) {
        if (inWorld) {
            world.setBlockState(this.blockPos, otherBlock.blockState, 3);
        } else {
            MyFirstMod.LOGGER.error("Block is not in the world, cannot swap!");
        }
    }

    public boolean is(Block otherBlock) {
        return this.blockState.getBlock() == otherBlock.blockState &&
                this.blockState.getBlock().getMetaFromState(this.blockState) ==
                        otherBlock.blockState.getBlock().getMetaFromState(otherBlock.blockState);
    }

    public Block getBlockOnSide(EnumFacing enumFacing) {
        if (inWorld) {
            return new Block(world.getBlockState(blockPos.offset(enumFacing)), blockPos.offset(enumFacing), world);
        } else {
            MyFirstMod.LOGGER.error("Block is not in World, cannot find other blocks");
            return AllBlocks.AIR;
        }
    }

    public void delete() {
        if (inWorld) {
            world.setBlockToAir(blockPos);
        } else {
            MyFirstMod.LOGGER.error("Block is not in World, cannot delete from world");
        }
    }
}
