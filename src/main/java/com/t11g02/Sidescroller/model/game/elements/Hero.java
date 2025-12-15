package com.t11g02.Sidescroller.model.game.elements;

public class Hero extends Element {

    private int energy = 10;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy() {
        energy++;
    }

    public void decreaseEnergy() {
        energy--;
    }
}
