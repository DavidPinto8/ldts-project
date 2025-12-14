package com.t11g02.Sidescroller.model.game.elements;

public class Coin extends Element {
    private final int value;

    public Coin(int x, int y) {
        super(x, y);
        this.value = 10;
    }

    public int getValue() {
        return value;
    }
}
