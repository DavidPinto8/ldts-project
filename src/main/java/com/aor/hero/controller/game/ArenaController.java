package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final CoinController coinController;
    private final PowerUpController powerUpController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.coinController = new CoinController(arena);
        this.powerUpController = new PowerUpController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            coinController.step(game, action, time);
            powerUpController.step(game, action, time);

            if (Math.random() < 0.05) getModel().spawnCoin();      // 5% de chance por ciclo
            if (Math.random() < 0.02) getModel().spawnPowerUp();
        }
    }
}