package com.aor.hero.model.game.arena;

import com.aor.hero.model.CoinPool;
import com.aor.hero.model.MonsterPool;
import com.aor.hero.model.Position;
import com.aor.hero.model.PowerUpPool;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private MonsterPool monsterPool;
    private List<Wall> walls;
    private CoinPool coinPool;
    private PowerUpPool powerUpPool;

    private int score = 0;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.monsterPool = new MonsterPool(100);
        this.coinPool = new CoinPool(50);
        this.powerUpPool = new PowerUpPool(50);
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

    public List<Coin> getCoins() { return coinPool.getInUse(); }

    public CoinPool getCoinPool() { return coinPool; }

    public List<PowerUp> getPowerUps() { return powerUpPool.getInUse(); }

    public PowerUpPool getPowerUpPool() { return powerUpPool; }

    public int getScore() { return score; }

    public void increaseScore() { score++; }

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
    public void spawnCoin() {
        int y;
        do {
            y = (int)(Math.random() * height);
        } while (!isEmpty(new Position(width - 1, y)) || hero.getPosition().equals(new Position(width - 1, y)));

        coinPool.spawnAt(width - 1, y); // Sempre na coluna mais à direita
    }

    public void spawnPowerUp() {
        int y;
        do {
            y = (int)(Math.random() * height);
        } while (!isEmpty(new Position(width - 1, y)) || hero.getPosition().equals(new Position(width - 1, y)));

        powerUpPool.spawnAt(width - 1, y);
    }
}
