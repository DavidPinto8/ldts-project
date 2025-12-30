package com.t11g02.Sidescroller.controller;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.controller.game.*;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Coin;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class ArenaControllerTest {
    private ArenaController controller;
    private Hero hero;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(10, 10);
        game = new Game();

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new ArenaController(arena);
    }
}
