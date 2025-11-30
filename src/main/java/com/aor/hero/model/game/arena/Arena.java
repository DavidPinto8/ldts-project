package com.aor.hero.model.game.arena;

import com.aor.hero.model.MonsterPool;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private MonsterPool monsterPool;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.monsterPool = new MonsterPool(100);
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
