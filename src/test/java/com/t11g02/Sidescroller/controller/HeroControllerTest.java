package com.t11g02.Sidescroller.controller;

import com.t11g02.Sidescroller.controller.game.HeroController;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroControllerTest {
    private HeroController controller;
    private Hero hero;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new HeroController(arena);
    }

    /* These tests have been commented out because the HeroController's movement logic has changed
       to only allow vertical movement (UP and DOWN). Horizontal movement (LEFT and RIGHT) is no longer implemented
    @Test
    void moveHeroRightEmpty() {
        controller.moveHeroRight();
        assertEquals(new Position(6, 5), hero.getPosition());
    }

    @Test
    void moveHeroRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.moveHeroRight();
        assertEquals(new Position(5, 5), hero.getPosition());
    }*/
}