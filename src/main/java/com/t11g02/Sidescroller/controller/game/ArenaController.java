package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.menu.Menu;
import com.t11g02.Sidescroller.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}