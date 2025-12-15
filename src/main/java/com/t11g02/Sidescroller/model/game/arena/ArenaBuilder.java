package com.t11g02.Sidescroller.model.game.arena;

import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.model.game.elements.Monster;
import com.t11g02.Sidescroller.model.game.elements.Wall;
import com.t11g02.Sidescroller.model.game.elements.Coin;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;


import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        arena.getCoinPool().setCoins(createCoins());
        arena.getPowerUpPool().setPowerUps(createPowerUps());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Hero createHero();

    protected abstract List<Coin> createCoins();
    protected abstract List<PowerUp> createPowerUps();

}
