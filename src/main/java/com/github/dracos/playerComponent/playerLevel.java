package com.github.dracos.playerComponent;

import com.github.dracos.playerComponent.playerComponent;
import nerdhub.cardinal.components.api.ComponentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

public class playerLevel implements playerComponent {

    private final PlayerEntity player;
    private int xp = 0;
    private int level = 1;

    public playerLevel(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void fromTag(CompoundTag compoundTag) {
        this.level = compoundTag.getInt("level");
        this.xp = compoundTag.getInt("xp");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putInt("level", this.level);
        tag.putInt("xp", this.xp);
        return tag;
    }

    @Override
    public Entity getEntity() {
        return player;
    }

    @Override
    public ComponentType<?> getComponentType() {
        return null;
    }

    @Override
    public int getXP() {
        return this.xp;
    }

    @Override
    public void setXP(int newXP) {
        this.xp = newXP;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    @Override
    public String getName() {
        return "exp";
    }

    @Override
    public String getCapName() {
        return "Exp";
    }

    @Override
    public void onLevelUp(boolean beQuiet) {
    }

}