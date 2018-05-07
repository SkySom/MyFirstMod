package com.learningtomod.myfirstmod.internal.content;

import com.learningtomod.myfirstmod.MyFirstMod;
import com.learningtomod.myfirstmod.internal.world.Player;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockContent extends Block {
    private BlockMethods blockMethods;
    private String blockName;

    public BlockContent(BlockMethods blockMethods) {
        super(Material.ROCK);
        this.blockMethods = blockMethods;
        this.setCreativeTab(MyFirstMod.CREATIVE_TABS);
        this.blockName = blockMethods.getClass().getSimpleName();
        this.setUnlocalizedName(blockName.toLowerCase());
        this.setRegistryName(new ResourceLocation(MyFirstMod.MOD_ID, blockName.toLowerCase()));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        blockMethods.onRightClicked(new com.learningtomod.myfirstmod.internal.world.Block(state, pos, world), new Player(player));
        return true;
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        blockMethods.onWalkedOn(new com.learningtomod.myfirstmod.internal.world.Block(world.getBlockState(pos), pos, world),
                new com.learningtomod.myfirstmod.internal.world.Entity(entity));
    }

    @Override
    public void onBlockExploded(World world, @Nonnull BlockPos pos, @Nonnull Explosion explosion) {
        blockMethods.onExploded(new com.learningtomod.myfirstmod.internal.world.Block(world.getBlockState(pos), pos, world));
        super.onBlockExploded(world, pos, explosion);
    }

    @Override
    @Nonnull
    public String getLocalizedName() {
        return blockName;
    }
}
