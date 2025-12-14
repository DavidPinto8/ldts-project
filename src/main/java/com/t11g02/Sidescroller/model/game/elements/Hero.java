package com.t11g02.Sidescroller.model.game.elements;

public class Hero extends Element {
    private int energy;
    private boolean laserImmunity;
    private long laserImmunityEndTime;



    public Hero(int x, int y) {
        super(x, y);
        this.energy = 10;
        this.laserImmunity = false;
        this.laserImmunityEndTime = 0;


    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public void increaseEnergy() {
        this.energy++;
    }


    public int getEnergy() {
        return energy;
    }

    public void activateLaserImmunity(long duration, long currentTime) {
        this.laserImmunity = true;
        this.laserImmunityEndTime = currentTime + duration;
    }

    public boolean hasLaserImmunity() {
        return laserImmunity;
    }

    public void updatePowerUps(long currentTime) {
        if (laserImmunity && currentTime > laserImmunityEndTime) {
            laserImmunity = false;
        }
    }


}
