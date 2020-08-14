package com.github.dracos.playerComponent;

public class BaseStat {

    private int statVal;

    private int number;

    public BaseStat(int val) {

        statVal = val;
        setStatVal(statVal);

    }

//    public void setNumber(int num) {
//        this.number = num;
//    }

    public void setStatVal(int newStatVal) {

        if (newStatVal >=3 && newStatVal <=20) {

            this.statVal = newStatVal;

            System.out.println("Stat value set to " + newStatVal);
            return;

        }

        System.out.println("Invalid value for this stat!");
        statVal = 10;

    }

    public int getStatVal () {

        if (statVal >= 3) {

            return statVal;

        }

        return 0;

    }

    public String getStatTxt (int val) {


        String statTxt = "";

        statTxt += val;

        return statTxt;

    }

    public void addToStat (int add) {

        statVal += add;

    }

    public int getModifier() {

        return (statVal - 10) / 2;

    }

}
