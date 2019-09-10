package com.company;

public class Player {

    private int whichWay;
    private boolean isAlive = false;
    public int idOfPlayer;

    public Player(){
        this.isAlive = false;
    }

    public Player(int whichWay, int idOfPlayer, boolean isAlive){
        this.isAlive = isAlive;
        this.whichWay = whichWay;
        this.idOfPlayer = idOfPlayer;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getWhichWay() {
        return whichWay;
    }
}
