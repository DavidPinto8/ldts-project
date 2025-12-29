package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(5,5);
    }

    @Test
    void increaseEnergy() {
        Assertions.assertEquals(10, hero.getEnergy());
        hero.increaseEnergy();
        Assertions.assertEquals(11, hero.getEnergy());
    }

    @Test
    void decreaseEnergy() {
        Assertions.assertEquals(10, hero.getEnergy());
        hero.decreaseEnergy(1000);
        Assertions.assertEquals(9, hero.getEnergy());
        hero.decreaseEnergy(1200); // should not decrease energy because of cooldown
        Assertions.assertEquals(9, hero.getEnergy());
        hero.decreaseEnergy(2000); // should decrease energy
        Assertions.assertEquals(8, hero.getEnergy());
    }
}
