package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;

import java.io.IOException;

public class HeroController extends GameController {

    public HeroController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        Position nextPosition = getModel().getHero().getPosition();

        switch (action) {
            case UP -> nextPosition = nextPosition.getUp();
            case DOWN -> nextPosition = nextPosition.getDown();
        }

        if (getModel().isEmpty(nextPosition)) {
            getModel().getHero().setPosition(nextPosition);
            if (getModel().isMonster(nextPosition)) getModel().getHero().decreaseEnergy(time);
        }
    }
}
