package com.t11g02.Sidescroller.model.game.arena;

import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.model.game.elements.Monster;
import com.t11g02.Sidescroller.model.game.elements.Wall;
import com.t11g02.Sidescroller.model.game.elements.Coin;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;
import com.t11g02.Sidescroller.model.game.elements.ExtraLifePowerUp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        //URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl"); //old
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + 0 + ".lvl"); //new
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
        }

        return monsters;
    }

    @Override
    protected Hero createHero() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Hero(x, y);
        }
        return null;
    }

    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'C')
                    coins.add(new Coin(x, y));
            }
        }
        return coins;
    }

    @Override
    protected List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '*') {
                    powerUps.add(new ExtraLifePowerUp(x, y));
                }
            }
        }
        return powerUps;
    }


}