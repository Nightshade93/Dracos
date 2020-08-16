package com.github.dracos.playerComponent;

import dev.onyxstudios.cca.api.v3.util.PlayerComponent;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.entity.Entity;

import java.util.*;
import java.util.Random;

public interface playerComponent extends PlayerComponent<Component> {
    int getXP();
    void setXP(int newXP);
    int getLevel();
    void setLevel(int newLevel);
    int getPntsToSpend();
    void setPntsToSpend(int newPoint);
    boolean getHasSANumsRemaining();
    void setHasSANumsRemaining(boolean isSANumsRemaining);
    BaseStat strength = new BaseStat(0);
    BaseStat dexterity = new BaseStat(0);
    BaseStat constitution = new BaseStat(0);
    BaseStat intelligence = new BaseStat(0);
    BaseStat wisdom = new BaseStat(0);
    BaseStat charisma = new BaseStat(0);
    StandardArrayNums eight = new StandardArrayNums(8);
    StandardArrayNums ten = new StandardArrayNums(10);
    StandardArrayNums twelve = new StandardArrayNums(12);
    StandardArrayNums thirteen = new StandardArrayNums(13);
    StandardArrayNums fourteen = new StandardArrayNums(14);
    StandardArrayNums fifteen = new StandardArrayNums(15);
    String getName();
    String getCapName();
    void onLevelUp(boolean beQuiet);
    Entity getEntity();

    //Standard Array
    boolean usingSA = true;

    // Random d6 stat gen for now :D
//    static int d6StatGen() {
//
//        int rand1 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
//        int rand2 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
//        int rand3 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
//        int rand4 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
//        int sum;
//        int smallest;
//
//        if (rand1 <= rand2 && rand1 <= rand3 && rand1 <= rand4) {
//            smallest = rand1;
//        } else if (rand2 <= rand1 && rand2 <= rand3 && rand2 <= rand4){
//            smallest = rand2;
//        } else if (rand3 <= rand1 && rand3 <= rand2 && rand3 <= rand4) {
//            smallest = rand3;
//        } else {
//            smallest = rand4;
//        }
//
//        if (rand1 == smallest){
//            sum = rand2 + rand3 + rand4;
//        } else if (rand2 == smallest){
//            sum = rand1 + rand3 + rand4;
//        } else if (rand3 == smallest) {
//            sum = rand1 + rand2 + rand4;
//        } else {
//            sum = rand1 + rand2 + rand3;
//        }
//
//        return sum;
//    }

}

