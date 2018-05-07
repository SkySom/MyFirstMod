package com.learningtomod.myfirstmod.internal.world;

import net.minecraft.util.DamageSource;

public class Entity {
    private net.minecraft.entity.Entity entity;

    public Entity(net.minecraft.entity.Entity entity) {
        this.entity = entity;
    }

    public void setOnFire(int seconds) {
        entity.setFire(seconds);
    }

    public void extinguish() {
        entity.extinguish();
    }

    public void setAir(int air) {
        entity.setAir(air);
    }

    public void damage(int amount) {
        entity.attackEntityFrom(DamageSource.GENERIC, amount);
    }

    public void setNoGravity(boolean gravity) {
        entity.setNoGravity(gravity);
    }

    public boolean getNoGravity() {
        return entity.hasNoGravity();
    }

    public boolean equals(Class entity) {
        return this.entity.getClass() == entity;
    }
}
