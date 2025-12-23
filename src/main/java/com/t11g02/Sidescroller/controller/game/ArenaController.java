package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Score;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.states.MenuState;
import com.t11g02.Sidescroller.model.menu.Menu;
import java.io.IOException;



public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final PowerUpController powerUpController;
    private final CoinController coinController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.powerUpController = new PowerUpController(arena);
        this.coinController = new CoinController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() <= 0) {
            Score.getInstance().reset();
            game.setState(new MenuState(new Menu()));
        } else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            powerUpController.step(game, action, time);
            coinController.step(game, action, time);
        }
    }
}
