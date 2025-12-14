package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Coin;

public class CoinPool extends ObjectPool<Coin> {

    public CoinPool(int size) {
        super();
        for (int i = 0; i < size; i++) {
            notInUse.add(new Coin(0, 0));
        }
    }

    public Coin getNewCoinAt(int x, int y) {
        Coin c = super.getNewObject();
        if (c != null) {
            c.setPosition(new Position(x, y));
        }
        return c;
    }
}
