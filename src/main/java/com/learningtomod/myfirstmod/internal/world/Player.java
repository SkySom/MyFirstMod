package com.learningtomod.myfirstmod.internal.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class Player extends Entity {
    private EntityPlayer entityPlayer;

    public Player(EntityPlayer entityPlayer) {
        super(entityPlayer);
        this.entityPlayer = entityPlayer;
    }

    public void sendMessage(String message) {
        if (entityPlayer.getEntityWorld().isRemote) {
            entityPlayer.sendStatusMessage(new TextComponentString(message), false);
        }
    }
}
