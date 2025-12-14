package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

import java.util.Random;

public class PowerUpController extends GameController {

    private long lastSpawn;
    private final Random random;

    public PowerUpController(Arena arena) {
        super(arena);
        this.lastSpawn = 0;
        this.random = new Random();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        spawnPowerUps(time);
        checkCollisions();
        clearPools();
    }

    private void spawnPowerUps(long time) {
        if (time - lastSpawn > 5000) {
            int x = random.nextInt(getModel().getWidth());
            int y = random.nextInt(getModel().getHeight());

            if (getModel().isEmpty(new Position(x, y))) {
                getModel().getDestroyLaserPowerUpPool().getNewPowerUpAt(x, y);
            }
            lastSpawn = time;
        }
    }

    private void checkCollisions() {
        Position heroPos = getModel().getHero().getPosition();

        for (PowerUp p : getModel().getExtraLifePowerUpPool().getInUse()) {
            if (p.getPosition().equals(heroPos)) {
                p.apply(getModel().getHero());
                getModel().getExtraLifePowerUpPool().addToRemovalBuffer(p);
            }
        }

        for (PowerUp p : getModel().getDestroyLaserPowerUpPool().getInUse()) {
            if (p.getPosition().equals(heroPos)) {
                p.apply(getModel().getHero());
                getModel().getDestroyLaserPowerUpPool().addToRemovalBuffer(p);
            }
        }
    }

    private void clearPools() {
        getModel().getExtraLifePowerUpPool().clearBuffer();
        getModel().getDestroyLaserPowerUpPool().clearBuffer();
    }
}
