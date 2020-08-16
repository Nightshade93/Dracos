package com.github.dracos.playerComponent;

public class StandardArrayNums {

    private boolean numIsUsed = false;

    public StandardArrayNums (int saVal) {



    }

    public boolean isUsed () {

        if (numIsUsed) {
            return true;
        }

        return false;

    }

    public void setUsed(boolean isUsed) {

        numIsUsed = isUsed;

    }

}
