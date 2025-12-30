package com.t11g02.Sidescroller.controller;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.controller.game.HeroController;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroControllerTest {
    private HeroController controller;
    private Hero hero;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new HeroController(arena);
    }

    @Test
    void moveHeroUp() throws IOException {
        controller.step(null, com.t11g02.Sidescroller.gui.GUI.ACTION.UP, 0);
        assertEquals(new Position(5, 4), hero.getPosition());
    }

    @Test
    void moveHeroDown() throws IOException {
        controller.step(null, com.t11g02.Sidescroller.gui.GUI.ACTION.DOWN, 0);
        assertEquals(new Position(5, 6), hero.getPosition());
    }
}