package com.aor.hero.model;

import com.aor.hero.model.game.elements.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinPool {
    private final List<Coin> inUse;
    private final List<Coin> notInUse;
    private final List<Coin> removalBuffer;

    public CoinPool(int size) {
        inUse = new ArrayList<>();
        notInUse = new ArrayList<>();
        removalBuffer = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            notInUse.add(new Coin(0,0));
        }
    }

    public void spawnAt(int x, int y) {
        if(notInUse.isEmpty()) return;
        Coin c = notInUse.remove(0);
        c.setPosition(new Position(x, y));
        inUse.add(c);
    }

    public void clearBuffer() {
        for(Coin c : removalBuffer) {
            inUse.remove(c);
            notInUse.add(c);
        }
        removalBuffer.clear();
    }

    public void addToRemovalBuffer(Coin coin) {
        if(!removalBuffer.contains(coin))
            removalBuffer.add(coin);
    }

    public List<Coin> getInUse() {
        return inUse;
    }
    public void moveCoins() {
        for (Coin coin : inUse) {
            coin.setPosition(coin.getPosition().getLeft());
            if (coin.getPosition().getX() < 0) {
                addToRemovalBuffer(coin); // Remove moedas que saem da tela
            }
        }
        clearBuffer();
    }
}
