package com.t11g02.Sidescroller.model.game.elements;

public class DestroyLaserPowerUp extends PowerUp {

    public DestroyLaserPowerUp(int x, int y) {
        super(x, y);
    }

    @Override
    public void apply(Hero hero) {
        hero.enableLaserImmunity();
    }
}
