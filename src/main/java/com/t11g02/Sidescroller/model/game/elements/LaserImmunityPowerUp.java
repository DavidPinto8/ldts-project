package com.t11g02.Sidescroller.model.game.elements;

public class LaserImmunityPowerUp extends PowerUp {

    public LaserImmunityPowerUp(int x, int y) {
        super(x, y);
    }

    @Override
    public void apply(Hero hero, long time) {
        hero.activateLaserImmunity(5000, time);
    }
}
