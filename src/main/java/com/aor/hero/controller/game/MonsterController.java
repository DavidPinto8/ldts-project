package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Monster;

import java.io.IOException;
import java.util.Random;

public class MonsterController extends GameController {
    private long lastMovement;
    private int cycle;

    public MonsterController(Arena arena) {
        super(arena);
        cycle=0;
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getLeft());
            getModel().getMonsterPool().clearBuffer(); //Remove the monsters marked for removal
            cycle++;
            if (cycle==2){
                spawnMonsters();
                cycle=0;
            }
            this.lastMovement = time;
        }
    }

    private void spawnMonsters(){
        Random random = new Random();
        for (int i=0; i<random.nextInt(5,10); i++) { //Spawn some monsters
            int y = random.nextInt(1,19);
            getModel().getMonsterPool().getNewMonsterAt(getModel().getWidth() - 1, y);
        }
    }

    private void moveMonster(Monster monster, Position position) {
        if (position.getX()<0){ //If the monster was about to leave the screen from the left
            getModel().getMonsterPool().addToRemovalBuffer(monster); //Mark the monster for removal
        }
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getHero().getPosition().equals(position))
                getModel().getHero().decreaseEnergy();
        }
    }
}
