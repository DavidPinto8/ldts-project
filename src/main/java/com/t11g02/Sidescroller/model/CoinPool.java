package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Coin;
import java.util.List;


public class CoinPool extends ObjectPool<Coin> {

    public CoinPool(int size) {
        super();
        for (int i = 0; i < size; i++) {
            notInUse.add(new Coin(0, 0));
        }
    }

    public void setCoins(List<Coin> coins) {
        inUse.addAll(coins);
    }

}
