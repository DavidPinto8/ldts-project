package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.ExtraLifePowerUp;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

import java.util.Random;

public class PowerUpController extends GameController {

    private final Random random = new Random();

    public PowerUpController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        for (PowerUp p : getModel().getPowerUpPool().getInUse()) {

            // mover power-up
            Position next = p.getPosition().getLeft();

            // colisão com herói (+1 de altura)
            Position heroCollisionPos = new Position(
                    getModel().getHero().getPosition().getX(),
                    getModel().getHero().getPosition().getY() + 1
            );

            if (next.equals(heroCollisionPos)) {
                p.apply(getModel().getHero()); // +1 vida
                getModel().getPowerUpPool().addToRemovalBuffer(p);
                continue;
            }

            // saiu do ecrã
            if (next.getX() < 0) {
                getModel().getPowerUpPool().addToRemovalBuffer(p);
                continue;
            }

            p.setPosition(next);
        }

        getModel().getPowerUpPool().clearBuffer();

        // spawn aleatório
        if (random.nextDouble() < 0.02) {
            spawnPowerUp();
        }
    }

    private void spawnPowerUp() {
        int x = getModel().getWidth() - 1;
        int y = random.nextInt(2, getModel().getHeight() - 1); // dentro da arena

        getModel().getPowerUpPool().getInUse().add(new ExtraLifePowerUp(x, y));
    }
}
