package com.t11g02.Sidescroller.model.game.elements;

public class ExtraLifePowerUp extends PowerUp {

    public ExtraLifePowerUp(int x, int y) {
        super(x, y);
    }

    @Override
    public void apply(Hero hero) {
        hero.decreaseEnergy(); // ou increaseEnergy se quiseres dar vida extra
    }
}
