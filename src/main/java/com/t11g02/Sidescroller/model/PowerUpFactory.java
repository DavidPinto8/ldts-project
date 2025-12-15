package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.ExtraLifePowerUp;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

public class PowerUpFactory {

    public static PowerUp createPowerUp(int x, int y) {
        return new ExtraLifePowerUp(x, y);
    }
}
