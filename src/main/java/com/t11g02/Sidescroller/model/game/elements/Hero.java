package com.t11g02.Sidescroller.model.game.elements;

public class Hero extends Element {
    private int energy;
    private boolean laserImmunity;


    public Hero(int x, int y) {
        super(x, y);
        this.energy = 10;
        this.laserImmunity = false;

    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }

    public void enableLaserImmunity() {
        this.laserImmunity = true;
    }

    public boolean hasLaserImmunity() {
        return laserImmunity;
    }

}
