package com.github.dracos.playerComponent;

public class BaseStat {

    private int statVal;

    private int number;
    boolean hasBeenSet = false;

    public BaseStat(int val) {

        statVal = val;
        setStatVal(statVal);

    }

//    public void setNumber(int num) {
//        this.number = num;
//    }

    //Sets a stat to specified value.
    public void setStatVal(int newStatVal) {

        if (newStatVal >=3 && newStatVal <=20) {

            this.statVal = newStatVal;
            hasBeenSet = true;

            System.out.println("Stat value set to " + newStatVal);
            return;

        }

        System.out.println("Invalid value for this stat!");
        statVal = 0;

    }

    //Check if a stat has been set.
    public boolean checkIfSet () {
        if (hasBeenSet) {
            return true;
        }
        return false;
    }

    //Gives value of desired stat
    public int getStatVal () {

        if (statVal >= 3) {

            return statVal;

        }

        return 0;

    }

    //Turns the stat value to string form
    public String getStatTxt (int val) {


        String statTxt = "";

        statTxt += val;

        return statTxt;

    }

    //Adds a value to a desired stat
    public void addToStat (int add) {

        statVal += add;

    }

    //Gives the Modifier value of desired stat
    public int getModifier() {

        return (statVal - 10) / 2;

    }

}
