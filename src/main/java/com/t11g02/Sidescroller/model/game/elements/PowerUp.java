package com.t11g02.Sidescroller.model.game.elements;

public abstract class PowerUp extends Element {

    public PowerUp(int x, int y) {
        super(x, y);
    }

    public abstract void apply(Hero hero);
}
