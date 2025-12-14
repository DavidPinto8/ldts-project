package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.PowerUp;

public class PowerUpPool extends ObjectPool<PowerUp> {

    public PowerUpPool(int size, PowerUpType type) {
        super();
        for (int i = 0; i < size; i++) {
            notInUse.add(PowerUpFactory.create(type));
        }
    }

    public PowerUp getNewPowerUpAt(int x, int y) {
        PowerUp p = getNewObject();
        if (p != null) {
            p.setPosition(new Position(x, y));
        }
        return p;
    }
}
