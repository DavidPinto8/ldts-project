package com.t11g02.Sidescroller.model.game.arena;

import com.t11g02.Sidescroller.model.MonsterPool;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.model.game.elements.Monster;
import com.t11g02.Sidescroller.model.game.elements.Wall;
import com.t11g02.Sidescroller.model.CoinPool;
import com.t11g02.Sidescroller.model.Score;
import com.t11g02.Sidescroller.model.game.elements.Coin;
import com.t11g02.Sidescroller.model.PowerUpPool;
import com.t11g02.Sidescroller.model.PowerUpType;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;


import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private MonsterPool monsterPool;
    private List<Wall> walls;

    private CoinPool coinPool;
    private Score score;

    private PowerUpPool extraLifePowerUpPool;
    private PowerUpPool destroyLaserPowerUpPool;



    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.monsterPool = new MonsterPool(100);
        this.coinPool = new CoinPool(50);
        this.score = new Score();
        this.extraLifePowerUpPool = new PowerUpPool(10, PowerUpType.EXTRA_LIFE);
        this.destroyLaserPowerUpPool = new PowerUpPool(10, PowerUpType.DESTROY_LASER);



    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


    public List<Monster> getMonsters() {
        return monsterPool.getInUse();
    }

    public void setMonsters(List<Monster> monsters) {
        monsterPool.setMonsters(monsters);
    }

    public MonsterPool getMonsterPool() {
        return monsterPool;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public CoinPool getCoinPool() {
        return coinPool;
    }

    public Score getScore() {
        return score;
    }

    public PowerUpPool getExtraLifePowerUpPool() {
        return extraLifePowerUpPool;
    }

    public PowerUpPool getDestroyLaserPowerUpPool() {
        return destroyLaserPowerUpPool;
    }



    public boolean isEmpty(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) return false; //Stop Hero and Monsters from going out of bounds
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsterPool.getInUse())
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
