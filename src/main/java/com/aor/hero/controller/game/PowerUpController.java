package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.PowerUp;

import java.io.IOException;

public class PowerUpController extends GameController {

    public PowerUpController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().getPowerUpPool().clearBuffer();
        for (PowerUp p : getModel().getPowerUps()) {
            if (p.getPosition().equals(getModel().getHero().getPosition())) {
                getModel().getHero().increaseEnergy();
                getModel().getPowerUpPool().addToRemovalBuffer(p);
            }
        }
        getModel().getPowerUpPool().movePowerUps();
    }
}
