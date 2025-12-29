package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.ExtraLifePowerUp;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtraLifePowerUpTest {
    private ExtraLifePowerUp powerUp;
    private Hero hero;

    @BeforeEach
    void setUp() {
        powerUp = new ExtraLifePowerUp(0, 0);
        hero = new Hero(0, 0);
    }

    @Test
    void apply() {
        Assertions.assertEquals(10, hero.getEnergy());
        powerUp.apply(hero);
        Assertions.assertEquals(11, hero.getEnergy());
    }
}
