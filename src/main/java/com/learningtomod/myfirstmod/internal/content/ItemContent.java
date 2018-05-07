package com.learningtomod.myfirstmod.internal.content;

import com.learningtomod.myfirstmod.MyFirstMod;
import com.learningtomod.myfirstmod.internal.world.Block;
import com.learningtomod.myfirstmod.internal.world.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemContent extends Item {
    private ItemMethods itemMethods;
    private String itemName;

    public ItemContent(ItemMethods itemMethods) {
        this.itemMethods = itemMethods;
        this.setCreativeTab(MyFirstMod.CREATIVE_TABS);
        this.itemName = itemMethods.getClass().getSimpleName();
        this.setUnlocalizedName(itemName.toLowerCase());
        this.setRegistryName(new ResourceLocation(MyFirstMod.MOD_ID, itemName.toLowerCase()));
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        itemMethods.onRightClickBlock(new com.learningtomod.myfirstmod.internal.world.Item(player.getHeldItem(hand)),
                new Block(world.getBlockState(pos), pos, world), new Player(player));
        return EnumActionResult.SUCCESS;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        itemMethods.onRightClick(new com.learningtomod.myfirstmod.internal.world.Item(player.getHeldItem(hand)), new Player(player));
        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack) {
        return this.itemName;
    }
}
