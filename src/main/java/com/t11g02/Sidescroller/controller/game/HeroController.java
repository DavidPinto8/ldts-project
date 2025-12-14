package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;

public class HeroController extends GameController {
    private int cycle = 0;

    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        getModel().getHero().updatePowerUps(time);
        if (action == GUI.ACTION.UP){
            moveHeroUp();
            cycle = 0; //reset the cycle
        } else if(action == GUI.ACTION.DOWN){
            moveHeroDown();
            cycle = 4; //slightly reset the cycle
        } else if (cycle >= 7) {
            moveHeroDown(); //Gravity is pulling us down
            cycle = 0;
        }
        cycle++;
        //We won't be moving the hero horizontally but we will keep these here in case we want to add it later:
        //if (action == GUI.ACTION.RIGHT) moveHeroRight();
        //if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}
