package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.PowerUp;
import java.util.ArrayList;
import java.util.List;


public class PowerUpPool extends ObjectPool<PowerUp> {
    public PowerUpPool() {
        super();
    }
    public void setPowerUps(List<PowerUp> powerUps) {
        inUse.addAll(powerUps);
    }

}

