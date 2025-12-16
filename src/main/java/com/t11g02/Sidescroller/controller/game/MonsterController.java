package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Monster;

import java.io.IOException;
import java.util.Random;

public class MonsterController extends GameController {

    private long lastMovement = 0;
    private int cycle = 0;

    public MonsterController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (time - lastMovement > 500) {

            for (Monster monster : getModel().getMonsters()) {
                moveMonster(monster,time);
            }

            getModel().getMonsterPool().clearBuffer();

            cycle++;
            if (cycle == 2) {
                spawnMonsters();
                cycle = 0;
            }

            lastMovement = time;
        }
    }

    private void moveMonster(Monster monster, long time) {

        Position newPos = monster.getPosition().getLeft();

        if (newPos.getX() < 0) {
            getModel().getMonsterPool().addToRemovalBuffer(monster);
            return;
        }

        if (getModel().isEmpty(newPos)) {
            monster.setPosition(newPos);

            if (newPos.equals(getModel().getHero().getPosition())) {
                getModel().getHero().decreaseEnergy(time);
            }
        }
    }

    private void spawnMonsters() {
        Random random = new Random();

        for (int i = 0; i < random.nextInt(5, 10); i++) {
            int y = random.nextInt(1, getModel().getHeight() - 1);
            getModel().getMonsterPool()
                    .getNewMonsterAt(getModel().getWidth() - 1, y);
        }
    }
}
