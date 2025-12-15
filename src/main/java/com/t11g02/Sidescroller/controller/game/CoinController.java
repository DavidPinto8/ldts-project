package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Coin;

import java.util.Random;

public class CoinController extends GameController {

    private final Random random = new Random();

    public CoinController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        for (Coin c : getModel().getCoinPool().getInUse()) {

            // mover moeda para a esquerda
            Position next = c.getPosition().getLeft();

            // colisão com herói (+1 de altura)
            Position heroCollisionPos = new Position(
                    getModel().getHero().getPosition().getX(),
                    getModel().getHero().getPosition().getY() + 1
            );

            if (next.equals(heroCollisionPos)) {
                getModel().getScore().increase(1);
                getModel().getCoinPool().addToRemovalBuffer(c);
                continue;
            }

            // saiu do ecrã
            if (next.getX() < 0) {
                getModel().getCoinPool().addToRemovalBuffer(c);
                continue;
            }

            c.setPosition(next);
        }

        getModel().getCoinPool().clearBuffer();

        // spawn aleatório
        if (random.nextDouble() < 0.05) {
            spawnCoin();
        }
    }

    private void spawnCoin() {
        int x = getModel().getWidth() - 1;
        int y = random.nextInt(2, getModel().getHeight() - 1); // dentro da arena

        getModel().getCoinPool().getInUse().add(new Coin(x, y));
    }
}
