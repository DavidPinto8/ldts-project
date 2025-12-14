package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.ExtraLifePowerUp;
import com.t11g02.Sidescroller.model.game.elements.DestroyLaserPowerUp;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

public class PowerUpFactory {

    public static PowerUp create(PowerUpType type) {
        return switch (type) {
            case EXTRA_LIFE -> new ExtraLifePowerUp(0, 0);
            case DESTROY_LASER -> new DestroyLaserPowerUp(0, 0);
        };
    }
}
