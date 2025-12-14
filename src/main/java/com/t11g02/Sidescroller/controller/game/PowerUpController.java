package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

public class PowerUpController extends GameController {

    public PowerUpController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        for (PowerUp p : getModel().getPowerUpPool().getInUse()) {
            if (p.getPosition().equals(getModel().getHero().getPosition())) {
                p.apply(getModel().getHero(), time);
                getModel().getPowerUpPool().addToRemovalBuffer(p);
            }
        }
        getModel().getPowerUpPool().clearBuffer();
    }
}
